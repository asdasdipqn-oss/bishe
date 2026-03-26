package com.renli.web.controller.system;

import com.renli.common.config.RuoYiConfig;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.core.domain.entity.SysRole;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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

    @GetMapping("")
    public String index() {
        return "system/attendance";
    }

    @PostMapping("/data")
    @ResponseBody
    public TableDataInfo data(String username, String startTime, String endTime)
    {
        SysUser currentUser = getSysUser();

        if (currentUser == null) {
            TableDataInfo errorRsp = new TableDataInfo();
            errorRsp.setCode(500);
            errorRsp.setMsg("用户未登录");
            return errorRsp;
        }

        // Check if current user is admin or dept manager
        boolean canViewAll = false;
        if (currentUser.getRoles() != null && !currentUser.getRoles().isEmpty()) {
            for (SysRole role : currentUser.getRoles()) {
                String roleKey = role.getRoleKey();
                // Admin or dept manager can view all records
                if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey) || "jl".equals(roleKey)) {
                    canViewAll = true;
                    break;
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

                // Convert to expected format
                List<Map<String, Object>> convertedRecords = new ArrayList<>();
                if (records != null) {
                    for (Map<String, Object> record : records) {
                        Map<String, Object> map = new java.util.HashMap<>();
                        map.put("username", record.get("username"));
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
}
