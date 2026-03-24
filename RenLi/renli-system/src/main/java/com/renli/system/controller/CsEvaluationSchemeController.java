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
import com.renli.system.domain.CsEvaluationScheme;
import com.renli.system.service.ICsEvaluationSchemeService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;

/**
 * 考核方案Controller
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Controller
@RequestMapping("/system/scheme")
public class CsEvaluationSchemeController extends BaseController
{
    private String prefix = "system/scheme";

    @Autowired
    private ICsEvaluationSchemeService csEvaluationSchemeService;

    @RequiresPermissions("system:scheme:view")
    @GetMapping()
    public String scheme()
    {
        return prefix + "/scheme";
    }

    /**
     * 查询考核方案列表
     */
    @RequiresPermissions("system:scheme:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsEvaluationScheme csEvaluationScheme)
    {
        startPage();
        List<CsEvaluationScheme> list = csEvaluationSchemeService.selectCsEvaluationSchemeList(csEvaluationScheme);
        return getDataTable(list);
    }

    /**
     * 导出考核方案列表
     */
    @RequiresPermissions("system:scheme:export")
    @Log(title = "考核方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsEvaluationScheme csEvaluationScheme)
    {
        List<CsEvaluationScheme> list = csEvaluationSchemeService.selectCsEvaluationSchemeList(csEvaluationScheme);
        ExcelUtil<CsEvaluationScheme> util = new ExcelUtil<CsEvaluationScheme>(CsEvaluationScheme.class);
        return util.exportExcel(list, "考核方案数据");
    }

    /**
     * 新增考核方案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考核方案
     */
    @RequiresPermissions("system:scheme:add")
    @Log(title = "考核方案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsEvaluationScheme csEvaluationScheme)
    {
        return toAjax(csEvaluationSchemeService.insertCsEvaluationScheme(csEvaluationScheme));
    }

    /**
     * 修改考核方案
     */
    @RequiresPermissions("system:scheme:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsEvaluationScheme csEvaluationScheme = csEvaluationSchemeService.selectCsEvaluationSchemeById(id);
        mmap.put("csEvaluationScheme", csEvaluationScheme);
        return prefix + "/edit";
    }

    /**
     * 修改保存考核方案
     */
    @RequiresPermissions("system:scheme:edit")
    @Log(title = "考核方案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsEvaluationScheme csEvaluationScheme)
    {
        return toAjax(csEvaluationSchemeService.updateCsEvaluationScheme(csEvaluationScheme));
    }

    /**
     * 删除考核方案
     */
    @RequiresPermissions("system:scheme:remove")
    @Log(title = "考核方案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csEvaluationSchemeService.deleteCsEvaluationSchemeByIds(ids));
    }
}
