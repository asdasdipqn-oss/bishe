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
import com.renli.system.domain.CsResumeYhscreening;
import com.renli.system.service.ICsResumeYhscreeningService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/yhscreening")
public class CsResumeYhscreeningController extends BaseController
{
    private String prefix = "system/yhscreening";

    @Autowired
    private ICsResumeYhscreeningService csResumeYhscreeningService;

    @RequiresPermissions("system:yhscreening:view")
    @GetMapping()
    public String yhscreening()
    {
        return prefix + "/yhscreening";
    }

    @RequiresPermissions("system:yhscreening:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsResumeYhscreening csResumeYhscreening)
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
            csResumeYhscreening.setCandidateName(currentUser.getUserName());
        }
        
        startPage();
        List<CsResumeYhscreening> list = csResumeYhscreeningService.selectCsResumeYhscreeningList(csResumeYhscreening);
        return getDataTable(list);
    }

    @RequiresPermissions("system:yhscreening:export")
    @Log(title = "简历筛选", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsResumeYhscreening csResumeYhscreening)
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
            csResumeYhscreening.setCandidateName(currentUser.getUserName());
        }
        
        List<CsResumeYhscreening> list = csResumeYhscreeningService.selectCsResumeYhscreeningList(csResumeYhscreening);
        ExcelUtil<CsResumeYhscreening> util = new ExcelUtil<CsResumeYhscreening>(CsResumeYhscreening.class);
        return util.exportExcel(list, "简历筛选数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:yhscreening:add")
    @Log(title = "简历筛选", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsResumeYhscreening csResumeYhscreening)
    {
        return toAjax(csResumeYhscreeningService.insertCsResumeYhscreening(csResumeYhscreening));
    }

    @RequiresPermissions("system:yhscreening:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsResumeYhscreening csResumeYhscreening = csResumeYhscreeningService.selectCsResumeYhscreeningById(id);
        mmap.put("csResumeYhscreening", csResumeYhscreening);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:yhscreening:edit")
    @Log(title = "简历筛选", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsResumeYhscreening csResumeYhscreening)
    {
        return toAjax(csResumeYhscreeningService.updateCsResumeYhscreening(csResumeYhscreening));
    }

    @RequiresPermissions("system:yhscreening:remove")
    @Log(title = "简历筛选", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csResumeYhscreeningService.deleteCsResumeYhscreeningByIds(ids));
    }
}
