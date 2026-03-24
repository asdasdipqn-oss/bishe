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
import com.renli.system.domain.CsResumeScreening;
import com.renli.system.service.ICsResumeScreeningService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/screening")
public class CsResumeScreeningController extends BaseController
{
    private String prefix = "system/screening";

    @Autowired
    private ICsResumeScreeningService csResumeScreeningService;

    @RequiresPermissions("system:screening:view")
    @GetMapping()
    public String screening()
    {
        return prefix + "/screening";
    }

    @RequiresPermissions("system:screening:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsResumeScreening csResumeScreening)
    {
        SysUser currentUser = getSysUser();
        List<SysRole> roles = currentUser.getRoles();
        
        boolean isNormalUser = true;
        
        if (roles != null) {
            for (SysRole role : roles) {
                String roleKey = role.getRoleKey();
                if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey) || "jl".equals(roleKey)) {
                    isNormalUser = false;
                    break;
                }
            }
        }
        
        if (isNormalUser) {
            csResumeScreening.setCandidateName(currentUser.getUserName());
        }
        
        startPage();
        List<CsResumeScreening> list = csResumeScreeningService.selectCsResumeScreeningList(csResumeScreening);
        return getDataTable(list);
    }

    @RequiresPermissions("system:screening:export")
    @Log(title = "简历筛选", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsResumeScreening csResumeScreening)
    {
        SysUser currentUser = getSysUser();
        List<SysRole> roles = currentUser.getRoles();
        
        boolean isNormalUser = true;
        
        if (roles != null) {
            for (SysRole role : roles) {
                String roleKey = role.getRoleKey();
                if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey) || "jl".equals(roleKey)) {
                    isNormalUser = false;
                    break;
                }
            }
        }
        
        if (isNormalUser) {
            csResumeScreening.setCandidateName(currentUser.getUserName());
        }
        
        List<CsResumeScreening> list = csResumeScreeningService.selectCsResumeScreeningList(csResumeScreening);
        ExcelUtil<CsResumeScreening> util = new ExcelUtil<CsResumeScreening>(CsResumeScreening.class);
        return util.exportExcel(list, "简历筛选数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:screening:add")
    @Log(title = "简历筛选", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsResumeScreening csResumeScreening)
    {
        return toAjax(csResumeScreeningService.insertCsResumeScreening(csResumeScreening));
    }

    @RequiresPermissions("system:screening:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsResumeScreening csResumeScreening = csResumeScreeningService.selectCsResumeScreeningById(id);
        mmap.put("csResumeScreening", csResumeScreening);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:screening:edit")
    @Log(title = "简历筛选", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsResumeScreening csResumeScreening)
    {
        return toAjax(csResumeScreeningService.updateCsResumeScreening(csResumeScreening));
    }

    @RequiresPermissions("system:screening:remove")
    @Log(title = "简历筛选", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csResumeScreeningService.deleteCsResumeScreeningByIds(ids));
    }
}
