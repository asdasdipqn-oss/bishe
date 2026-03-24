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
import com.renli.system.domain.CsEvaluationResult;
import com.renli.system.service.ICsEvaluationResultService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/result")
public class CsEvaluationResultController extends BaseController
{
    private String prefix = "system/result";

    @Autowired
    private ICsEvaluationResultService csEvaluationResultService;

    @RequiresPermissions("system:result:view")
    @GetMapping()
    public String result()
    {
        return prefix + "/result";
    }

    @RequiresPermissions("system:result:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsEvaluationResult csEvaluationResult)
    {
        SysUser currentUser = getSysUser();
        List<SysRole> roles = currentUser.getRoles();
        
        boolean isNormalUser = true;
        boolean isDeptManager = false;
        
        if (roles != null) {
            for (SysRole role : roles) {
                String roleKey = role.getRoleKey();
                if ("jl".equals(roleKey)) {
                    isDeptManager = true;
                    isNormalUser = false;
                    break;
                }
                else if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey)) {
                    isNormalUser = false;
                    break;
                }
            }
        }
        
        if (isNormalUser) {
            csEvaluationResult.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csEvaluationResult.setEmployee(null);
        }
        
        startPage();
        List<CsEvaluationResult> list = csEvaluationResultService.selectCsEvaluationResultList(csEvaluationResult);
        return getDataTable(list);
    }

    @RequiresPermissions("system:result:export")
    @Log(title = "培训考核结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsEvaluationResult csEvaluationResult)
    {
        SysUser currentUser = getSysUser();
        List<SysRole> roles = currentUser.getRoles();
        
        boolean isNormalUser = true;
        boolean isDeptManager = false;
        
        if (roles != null) {
            for (SysRole role : roles) {
                String roleKey = role.getRoleKey();
                if ("jl".equals(roleKey)) {
                    isDeptManager = true;
                    isNormalUser = false;
                    break;
                }
                else if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey)) {
                    isNormalUser = false;
                    break;
                }
            }
        }
        
        if (isNormalUser) {
            csEvaluationResult.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csEvaluationResult.setEmployee(null);
        }
        
        List<CsEvaluationResult> list = csEvaluationResultService.selectCsEvaluationResultList(csEvaluationResult);
        ExcelUtil<CsEvaluationResult> util = new ExcelUtil<CsEvaluationResult>(CsEvaluationResult.class);
        return util.exportExcel(list, "培训考核结果数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:result:add")
    @Log(title = "培训考核结果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsEvaluationResult csEvaluationResult)
    {
        return toAjax(csEvaluationResultService.insertCsEvaluationResult(csEvaluationResult));
    }

    @RequiresPermissions("system:result:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsEvaluationResult csEvaluationResult = csEvaluationResultService.selectCsEvaluationResultById(id);
        mmap.put("csEvaluationResult", csEvaluationResult);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:result:edit")
    @Log(title = "培训考核结果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsEvaluationResult csEvaluationResult)
    {
        return toAjax(csEvaluationResultService.updateCsEvaluationResult(csEvaluationResult));
    }

    @RequiresPermissions("system:result:remove")
    @Log(title = "培训考核结果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csEvaluationResultService.deleteCsEvaluationResultByIds(ids));
    }
}
