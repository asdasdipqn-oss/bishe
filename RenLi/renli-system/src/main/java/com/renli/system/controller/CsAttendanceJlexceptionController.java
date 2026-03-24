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
import com.renli.system.domain.CsAttendanceJlexception;
import com.renli.system.service.ICsAttendanceJlexceptionService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;

/**
 * 考勤异常审批Controller
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Controller
@RequestMapping("/system/jlexception")
public class CsAttendanceJlexceptionController extends BaseController
{
    private String prefix = "system/jlexception";

    @Autowired
    private ICsAttendanceJlexceptionService csAttendanceJlexceptionService;

    @RequiresPermissions("system:jlexception:view")
    @GetMapping()
    public String jlexception()
    {
        return prefix + "/jlexception";
    }

    /**
     * 查询考勤异常审批列表
     */
    @RequiresPermissions("system:jlexception:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsAttendanceJlexception csAttendanceJlexception)
    {
        startPage();
        List<CsAttendanceJlexception> list = csAttendanceJlexceptionService.selectCsAttendanceJlexceptionList(csAttendanceJlexception);
        return getDataTable(list);
    }

    /**
     * 导出考勤异常审批列表
     */
    @RequiresPermissions("system:jlexception:export")
    @Log(title = "考勤异常审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsAttendanceJlexception csAttendanceJlexception)
    {
        List<CsAttendanceJlexception> list = csAttendanceJlexceptionService.selectCsAttendanceJlexceptionList(csAttendanceJlexception);
        ExcelUtil<CsAttendanceJlexception> util = new ExcelUtil<CsAttendanceJlexception>(CsAttendanceJlexception.class);
        return util.exportExcel(list, "考勤异常审批数据");
    }

    /**
     * 新增考勤异常审批
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤异常审批
     */
    @RequiresPermissions("system:jlexception:add")
    @Log(title = "考勤异常审批", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsAttendanceJlexception csAttendanceJlexception)
    {
        return toAjax(csAttendanceJlexceptionService.insertCsAttendanceJlexception(csAttendanceJlexception));
    }

    /**
     * 修改考勤异常审批
     */
    @RequiresPermissions("system:jlexception:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsAttendanceJlexception csAttendanceJlexception = csAttendanceJlexceptionService.selectCsAttendanceJlexceptionById(id);
        mmap.put("csAttendanceJlexception", csAttendanceJlexception);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤异常审批
     */
    @RequiresPermissions("system:jlexception:edit")
    @Log(title = "考勤异常审批", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsAttendanceJlexception csAttendanceJlexception)
    {
        return toAjax(csAttendanceJlexceptionService.updateCsAttendanceJlexception(csAttendanceJlexception));
    }

    /**
     * 删除考勤异常审批
     */
    @RequiresPermissions("system:jlexception:remove")
    @Log(title = "考勤异常审批", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csAttendanceJlexceptionService.deleteCsAttendanceJlexceptionByIds(ids));
    }
}
