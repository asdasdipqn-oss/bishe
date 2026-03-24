package com.renli.web.controller.system;

import com.renli.common.config.RuoYiConfig;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
