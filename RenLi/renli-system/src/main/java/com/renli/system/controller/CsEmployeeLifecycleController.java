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
import com.renli.system.domain.CsEmployeeLifecycle;
import com.renli.system.service.ICsEmployeeLifecycleService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;

/**
 * 员工全生命周期Controller
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Controller
@RequestMapping("/system/lifecycle")
public class CsEmployeeLifecycleController extends BaseController
{
    private String prefix = "system/lifecycle";

    @Autowired
    private ICsEmployeeLifecycleService csEmployeeLifecycleService;

    @RequiresPermissions("system:lifecycle:view")
    @GetMapping()
    public String lifecycle()
    {
        return prefix + "/lifecycle";
    }

    /**
     * 查询员工全生命周期列表
     */
    @RequiresPermissions("system:lifecycle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsEmployeeLifecycle csEmployeeLifecycle)
    {
        startPage();
        List<CsEmployeeLifecycle> list = csEmployeeLifecycleService.selectCsEmployeeLifecycleList(csEmployeeLifecycle);
        return getDataTable(list);
    }

    /**
     * 导出员工全生命周期列表
     */
    @RequiresPermissions("system:lifecycle:export")
    @Log(title = "员工全生命周期", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsEmployeeLifecycle csEmployeeLifecycle)
    {
        List<CsEmployeeLifecycle> list = csEmployeeLifecycleService.selectCsEmployeeLifecycleList(csEmployeeLifecycle);
        ExcelUtil<CsEmployeeLifecycle> util = new ExcelUtil<CsEmployeeLifecycle>(CsEmployeeLifecycle.class);
        return util.exportExcel(list, "员工全生命周期数据");
    }

    /**
     * 新增员工全生命周期
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工全生命周期
     */
    @RequiresPermissions("system:lifecycle:add")
    @Log(title = "员工全生命周期", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsEmployeeLifecycle csEmployeeLifecycle)
    {
        return toAjax(csEmployeeLifecycleService.insertCsEmployeeLifecycle(csEmployeeLifecycle));
    }

    /**
     * 修改员工全生命周期
     */
    @RequiresPermissions("system:lifecycle:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsEmployeeLifecycle csEmployeeLifecycle = csEmployeeLifecycleService.selectCsEmployeeLifecycleById(id);
        mmap.put("csEmployeeLifecycle", csEmployeeLifecycle);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工全生命周期
     */
    @RequiresPermissions("system:lifecycle:edit")
    @Log(title = "员工全生命周期", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsEmployeeLifecycle csEmployeeLifecycle)
    {
        return toAjax(csEmployeeLifecycleService.updateCsEmployeeLifecycle(csEmployeeLifecycle));
    }

    /**
     * 删除员工全生命周期
     */
    @RequiresPermissions("system:lifecycle:remove")
    @Log(title = "员工全生命周期", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csEmployeeLifecycleService.deleteCsEmployeeLifecycleByIds(ids));
    }
}
