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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     * 获取当前用户角色
     */
    @GetMapping("/currentUser")
    @ResponseBody
    public AjaxResult getCurrentUser() {
        try {
            SysUser currentUser = getSysUser();
            if (currentUser == null) {
                return AjaxResult.error("用户未登录");
            }

            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("userName", currentUser.getUserName());

            // Get role names
            List<String> roleNames = new ArrayList<>();
            if (currentUser.getRoles() != null) {
                for (SysRole role : currentUser.getRoles()) {
                    String roleName = role.getRoleName();
                    if (roleName != null && !roleName.isEmpty()) {
                        roleNames.add(roleName);
                    }
                }
            }
            userInfo.put("roles", roleNames);

            return AjaxResult.success(userInfo);
        } catch (Exception e) {
            logger.error("获取用户信息失败", e);
            return AjaxResult.error("获取用户信息失败");
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
        boolean canViewDept = false;  // Manager can view records in their own department
        boolean canDelete = false;
        if (currentUser.getRoles() != null && !currentUser.getRoles().isEmpty()) {
            for (SysRole role : currentUser.getRoles()) {
                String roleKey = role.getRoleKey();
                // Admin user should show as "管理员"
                if ("admin".equals(roleKey)) {
                    isAdmin = true;
                }
                // Admin, gly, hr can view all records
                if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey)) {
                    canViewAll = true;
                }
                // Manager (jl) can view records in their own department
                if ("jl".equals(roleKey)) {
                    canViewDept = true;
                }
                // Admin and gly can delete records
                if ("admin".equals(roleKey) || "gly".equals(roleKey)) {
                    canDelete = true;
                    break;
                }
            }
        }

        // Regular users can only see their own records, users who can view all can search all users
        // Managers can view all records in their department
        String usernameParam = null;
        List<String> usernameList = null;  // List of usernames for department filter

        // If user is a manager (jl), get all users in their department
        if (canViewDept && currentUser.getDept() != null && currentUser.getDept().getDeptId() != null) {
            Long currentDeptId = currentUser.getDept().getDeptId();
            SysUser deptQuery = new SysUser();
            deptQuery.setDeptId(currentDeptId);
            List<SysUser> deptUsers = userService.selectUserList(deptQuery);
            if (deptUsers != null && !deptUsers.isEmpty()) {
                usernameList = new ArrayList<>();
                for (SysUser u : deptUsers) {
                    usernameList.add(u.getLoginName());
                }
            }
            logger.info("经理 {} 查询本部门 {} 的打卡记录，共 {} 名员工", currentUser.getUserName(), currentUser.getDept().getDeptName(), usernameList != null ? usernameList.size() : 0);
        }

        // Handle department filter: if dept is provided, get all users in that dept
        // Note: Only admin/gly/hr users can manually select department to filter
        if (dept != null && !dept.isEmpty() && canViewAll) {
            // Query users in the manually selected department
            SysUser queryUser = new SysUser();
            SysUser deptQuery = new SysUser();
            // Find dept by name and set dept_id
            List<SysDept> allDepts = deptService.selectDeptList(new SysDept());
            Long deptId = null;
            if (allDepts != null) {
                for (SysDept d : allDepts) {
                    if (dept.equals(d.getDeptName())) {
                        deptId = d.getDeptId();
                        break;
                    }
                }
            }
            if (deptId != null) {
                deptQuery.setDeptId(deptId);
                List<SysUser> deptUsers = userService.selectUserList(deptQuery);
                if (deptUsers != null && !deptUsers.isEmpty()) {
                    usernameList = new ArrayList<>();
                    for (SysUser u : deptUsers) {
                        usernameList.add(u.getLoginName());
                    }
                }
            }
        }

        // Determine what records to query
        if (!canViewAll && !canViewDept) {
            // Regular user: can only see their own records
            usernameParam = currentUser.getUserName();
            logger.info("普通用户 {} 只能查看自己的打卡记录", currentUser.getUserName());
        } else if (usernameList != null && !usernameList.isEmpty()) {
            // Manager (jl) or admin with department filter: will handle by filtering after query
            usernameParam = "";
        } else if (canViewAll) {
            // Admin/gly/hr without specific filter: get all records
            if (username != null && !username.isEmpty()) {
                usernameParam = username;
            } else {
                usernameParam = "";
            }
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
            } else {
                // Admin user without username filter - send empty to get all
                requestBody.put("username", "");
            }
            // Optional: add address filter if needed
            requestBody.put("address", "");
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
                        String recordUsername = (String) record.get("username");

                        // Apply department filter if usernameList is set
                        if (usernameList != null && !usernameList.isEmpty() && !usernameList.contains(recordUsername)) {
                            continue;  // Skip this record if username not in department
                        }

                        Map<String, Object> map = new java.util.HashMap<>();
                        map.put("id", record.get("id"));
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
                // If department filter was applied, use actual filtered count
                long actualTotal = convertedRecords.size();
                rspData.setTotal(actualTotal);
                logger.info("查询打卡记录成功，返回 {} 条记录", actualTotal);
            } else {
                rspData.setRows(new ArrayList<>());
                rspData.setTotal(0);
                logger.info("查询打卡记录成功，无数据");
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
                // Admin and gly can delete records
                if ("admin".equals(roleKey) || "gly".equals(roleKey)) {
                    canDelete = true;
                    break;
                }
            }
        }

        if (!canDelete) {
            return AjaxResult.error("没有权限删除考勤记录");
        }

        try {
            int result = signinfoMapper.deleteById(id);
            if (result > 0) {
                return AjaxResult.success();
            } else {
                return AjaxResult.error("删除失败，记录不存在");
            }
        } catch (Exception e) {
            logger.error("删除打卡记录失败", e);
            return AjaxResult.error("删除失败: " + e.getMessage());
        }
    }
}
