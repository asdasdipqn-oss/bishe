package com.renli.system.controller;

import com.renli.common.core.domain.entity.SysRole;
import com.renli.common.core.domain.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.core.page.TableDataInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/attendance")
public class AttendanceController extends BaseController
{
    private String prefix = "system/attendance";

    @GetMapping()
    public String attendance()
    {
        return prefix;
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

        // Check if current user is admin
        boolean isAdmin = false;
        if (currentUser.getRoles() != null && !currentUser.getRoles().isEmpty()) {
            for (SysRole role : currentUser.getRoles()) {
                if ("admin".equals(role.getRoleKey())) {
                    isAdmin = true;
                    break;
                }
            }
        }

        // Determine username parameter to send to 8088 service
        String usernameParam = null;
        if (!isAdmin) {
            // Non-admin users can only see their own records
            usernameParam = currentUser.getUserName();
        }
        // Admin users: if username is provided, use it; otherwise send empty to get all records

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

                // Convert to the expected format
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
