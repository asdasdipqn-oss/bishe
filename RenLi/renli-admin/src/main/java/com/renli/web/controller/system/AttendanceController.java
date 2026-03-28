package com.renli.web.controller.system;

import com.renli.common.config.RuoYiConfig;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.core.domain.entity.SysDept;
import com.renli.common.core.domain.entity.SysRole;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.page.TableDataInfo;
import com.renli.system.domain.Signinfo;
import com.renli.system.mapper.SigninfoMapper;
import com.renli.system.service.ISysDeptService;
import com.renli.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考勤管理控制器
 */
@Controller
@RequestMapping("/system/attendance")
public class AttendanceController extends BaseController {

    @Autowired
    private RuoYiConfig serverConfig;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private SigninfoMapper signinfoMapper;

    @GetMapping("")
    public String index() {
        return "system/attendance";
    }

    /**
     * 获取部门列表
     */
    @GetMapping("/depts")
    @ResponseBody
    public AjaxResult getDepts() {
        try {
            List<SysDept> deptList = deptService.selectDeptList(new SysDept());
            return AjaxResult.success(deptList);
        } catch (Exception e) {
            logger.error("获取部门列表失败", e);
            return AjaxResult.error("获取部门列表失败");
        }
    }

    @PostMapping("/data")
    @ResponseBody
    public TableDataInfo data(String username, String startTime, String endTime, String dept)
    {
        SysUser currentUser = getSysUser();

        if (currentUser == null) {
            TableDataInfo errorRsp = new TableDataInfo();
            errorRsp.setCode(500);
            errorRsp.setMsg("用户未登录");
            return errorRsp;
        }

        // Check if current user is admin or dept manager
        boolean isAdmin = false;
        boolean canViewAll = false;
        boolean canDelete = false;
        if (currentUser.getRoles() != null && !currentUser.getRoles().isEmpty()) {
            for (SysRole role : currentUser.getRoles()) {
                String roleKey = role.getRoleKey();
                // Admin user should show as "管理员"
                if ("admin".equals(roleKey)) {
                    isAdmin = true;
                }
                // Admin or dept manager can view all records
                if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey) || "jl".equals(roleKey)) {
                    canViewAll = true;
                }
                // Only admin and gly can delete records
                if ("admin".equals(roleKey) || "gly".equals(roleKey)) {
                    canDelete = true;
                }
            }
        }

        // Regular users can only see their own records, users who can view all can search all users
        String usernameParam = null;
        if (!canViewAll) {
            usernameParam = currentUser.getUserName();
        } else if (username != null && !username.isEmpty()) {
            // User with view-all permission searching for specific username
            usernameParam = username;
        }

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8088/signinfo/findAll1";

            // Build request body
            Map<String, Object> requestBody = new java.util.HashMap<>();
            requestBody.put("page", 1);
            requestBody.put("size", 100);
            if (usernameParam != null && !usernameParam.isEmpty()) {
                requestBody.put("username", usernameParam);
            } else if (username != null && !username.isEmpty()) {
                // Admin user searching for specific username
                requestBody.put("username", username);
            } else {
                // Admin user without username filter - send empty to get all
                requestBody.put("username", "");
            }
            // Optional: add address filter if needed
            requestBody.put("address", "");
            // Add dept filter if provided
            if (dept != null && !dept.isEmpty()) {
                requestBody.put("dept", dept);
            }
            // Date range filtering
            if (startTime != null && !startTime.isEmpty()) {
                requestBody.put("startTime", startTime);
            }
            if (endTime != null && !endTime.isEmpty()) {
                requestBody.put("endTime", endTime);
            }

            // Call 8088 service
            @SuppressWarnings("unchecked")
            Map<String, Object> response = restTemplate.postForObject(url, requestBody, Map.class);

            TableDataInfo rspData = new TableDataInfo();
            rspData.setCode(0);

            if (response != null && response.containsKey("records")) {
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> records = (List<Map<String, Object>>) response.get("records");

                // Cache for user dept names to avoid repeated queries
                Map<String, String> userDeptCache = new HashMap<>();

                // Convert to expected format
                List<Map<String, Object>> convertedRecords = new ArrayList<>();
                if (records != null) {
                    for (Map<String, Object> record : records) {
                        Map<String, Object> map = new java.util.HashMap<>();
                        map.put("id", record.get("id"));
                        String recordUsername = (String) record.get("username");
                        map.put("username", recordUsername);

                        // Get dept name from database if not in cache
                        String deptName = userDeptCache.get(recordUsername);
                        if (deptName == null) {
                            SysUser recordUser = userService.selectUserByLoginName(recordUsername);
                            boolean isAdminUser = false;
                            if (recordUser != null && recordUser.getRoles() != null && !recordUser.getRoles().isEmpty()) {
                                for (SysRole role : recordUser.getRoles()) {
                                    String roleKey = role.getRoleKey();
                                    if ("admin".equals(roleKey) || "gly".equals(roleKey)) {
                                        isAdminUser = true;
                                        break;
                                    }
                                }
                            }
                            if (isAdminUser) {
                                deptName = "管理员";
                            } else if (recordUser != null && recordUser.getDept() != null) {
                                deptName = recordUser.getDept().getDeptName();
                            }
                            if (deptName == null) {
                                deptName = (String) record.get("dept");
                            }
                            userDeptCache.put(recordUsername, deptName);
                        }
                        map.put("canDelete", canDelete ? "true" : "false");
                        map.put("dept", deptName);
                        map.put("temperature", record.get("temperature"));
                        map.put("address", record.get("address"));
                        map.put("date", record.get("date"));
                        convertedRecords.add(map);
                    }
                }
                rspData.setRows(convertedRecords);
                Object total = response.get("total");
                rspData.setTotal(total != null ? Long.parseLong(total.toString()) : 0);
            } else {
                rspData.setRows(new ArrayList<>());
                rspData.setTotal(0);
            }

            return rspData;

        } catch (Exception e) {
            logger.error("查询打卡记录失败", e);
            TableDataInfo errorRsp = new TableDataInfo();
            errorRsp.setCode(500);
            errorRsp.setMsg("查询失败: " + e.getMessage());
            return errorRsp;
        }
    }

    /**
     * 删除打卡记录
     */
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(@RequestParam Long id)
    {
        SysUser currentUser = getSysUser();

        if (currentUser == null) {
            return AjaxResult.error("用户未登录");
        }

        // Check if user has permission to delete
        boolean canDelete = false;
        if (currentUser.getRoles() != null && !currentUser.getRoles().isEmpty()) {
            for (SysRole role : currentUser.getRoles()) {
                String roleKey = role.getRoleKey();
                // Admin or dept manager can delete records
                if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey) || "jl".equals(roleKey)) {
                    canDelete = true;
                    break;
                }
            }
        }

        if (!canDelete) {
            return AjaxResult.error("没有权限删除考勤记录");
        }

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8088/signinfo/delete?id=" + id;

            // Call 8088 service to delete
            @SuppressWarnings("unchecked")
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            Integer code = (Integer) response.get("code");
            String result = (String) response.get("result");

            if (code != null && code == 0 && "success".equals(result)) {
                return AjaxResult.success();
            } else {
                return AjaxResult.error("删除失败");
            }
        } catch (Exception e) {
            logger.error("删除打卡记录失败", e);
            return AjaxResult.error("删除失败: " + e.getMessage());
        }
    }
}
