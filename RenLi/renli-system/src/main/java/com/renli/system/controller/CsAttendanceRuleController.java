package com.renli.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.renli.common.annotation.Log;
import com.renli.common.enums.BusinessType;
import com.renli.system.domain.CsAttendanceRule;
import com.renli.system.service.ICsAttendanceRuleService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;

/**
 * 考勤规则配置Controller
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Controller
@RequestMapping("/system/rule")
public class CsAttendanceRuleController extends BaseController
{
    private String prefix = "system/rule";

    @Autowired
    private ICsAttendanceRuleService csAttendanceRuleService;

    @RequiresPermissions("system:rule:view")
    @GetMapping()
    public String rule()
    {
        return prefix + "/rule";
    }

    /**
     * 查询考勤规则配置列表
     */
    @RequiresPermissions("system:rule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsAttendanceRule csAttendanceRule)
    {
        startPage();
        List<CsAttendanceRule> list = csAttendanceRuleService.selectCsAttendanceRuleList(csAttendanceRule);
        return getDataTable(list);
    }

    /**
     * 导出考勤规则配置列表
     */
    @RequiresPermissions("system:rule:export")
    @Log(title = "考勤规则配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsAttendanceRule csAttendanceRule)
    {
        List<CsAttendanceRule> list = csAttendanceRuleService.selectCsAttendanceRuleList(csAttendanceRule);
        ExcelUtil<CsAttendanceRule> util = new ExcelUtil<CsAttendanceRule>(CsAttendanceRule.class);
        return util.exportExcel(list, "考勤规则配置数据");
    }

    /**
     * 新增考勤规则配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤规则配置
     */
    @RequiresPermissions("system:rule:add")
    @Log(title = "考勤规则配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsAttendanceRule csAttendanceRule)
    {
        return toAjax(csAttendanceRuleService.insertCsAttendanceRule(csAttendanceRule));
    }

    /**
     * 修改考勤规则配置
     */
    @RequiresPermissions("system:rule:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsAttendanceRule csAttendanceRule = csAttendanceRuleService.selectCsAttendanceRuleById(id);
        mmap.put("csAttendanceRule", csAttendanceRule);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤规则配置
     */
    @RequiresPermissions("system:rule:edit")
    @Log(title = "考勤规则配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsAttendanceRule csAttendanceRule)
    {
        return toAjax(csAttendanceRuleService.updateCsAttendanceRule(csAttendanceRule));
    }

    /**
     * 删除考勤规则配置
     */
    @RequiresPermissions("system:rule:remove")
    @Log(title = "考勤规则配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csAttendanceRuleService.deleteCsAttendanceRuleByIds(ids));
    }
}
