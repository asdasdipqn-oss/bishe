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
import com.renli.system.domain.CsSalaryItemConfig;
import com.renli.system.service.ICsSalaryItemConfigService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;

/**
 * 薪资项目配置Controller
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Controller
@RequestMapping("/system/xinzi")
public class CsSalaryItemConfigController extends BaseController
{
    private String prefix = "system/xinzi";

    @Autowired
    private ICsSalaryItemConfigService csSalaryItemConfigService;

    @RequiresPermissions("system:xinzi:view")
    @GetMapping()
    public String xinzi()
    {
        return prefix + "/xinzi";
    }

    /**
     * 查询薪资项目配置列表
     */
    @RequiresPermissions("system:xinzi:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsSalaryItemConfig csSalaryItemConfig)
    {
        startPage();
        List<CsSalaryItemConfig> list = csSalaryItemConfigService.selectCsSalaryItemConfigList(csSalaryItemConfig);
        return getDataTable(list);
    }

    /**
     * 导出薪资项目配置列表
     */
    @RequiresPermissions("system:xinzi:export")
    @Log(title = "薪资项目配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsSalaryItemConfig csSalaryItemConfig)
    {
        List<CsSalaryItemConfig> list = csSalaryItemConfigService.selectCsSalaryItemConfigList(csSalaryItemConfig);
        ExcelUtil<CsSalaryItemConfig> util = new ExcelUtil<CsSalaryItemConfig>(CsSalaryItemConfig.class);
        return util.exportExcel(list, "薪资项目配置数据");
    }

    /**
     * 新增薪资项目配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存薪资项目配置
     */
    @RequiresPermissions("system:xinzi:add")
    @Log(title = "薪资项目配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsSalaryItemConfig csSalaryItemConfig)
    {
        return toAjax(csSalaryItemConfigService.insertCsSalaryItemConfig(csSalaryItemConfig));
    }

    /**
     * 修改薪资项目配置
     */
    @RequiresPermissions("system:xinzi:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsSalaryItemConfig csSalaryItemConfig = csSalaryItemConfigService.selectCsSalaryItemConfigById(id);
        mmap.put("csSalaryItemConfig", csSalaryItemConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存薪资项目配置
     */
    @RequiresPermissions("system:xinzi:edit")
    @Log(title = "薪资项目配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsSalaryItemConfig csSalaryItemConfig)
    {
        return toAjax(csSalaryItemConfigService.updateCsSalaryItemConfig(csSalaryItemConfig));
    }

    /**
     * 删除薪资项目配置
     */
    @RequiresPermissions("system:xinzi:remove")
    @Log(title = "薪资项目配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csSalaryItemConfigService.deleteCsSalaryItemConfigByIds(ids));
    }
}
