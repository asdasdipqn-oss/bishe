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
import com.renli.system.domain.CsDeptTrainingHrrequest;
import com.renli.system.service.ICsDeptTrainingHrrequestService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/hrrequest")
public class CsDeptTrainingHrrequestController extends BaseController
{
    private String prefix = "system/hrrequest";

    @Autowired
    private ICsDeptTrainingHrrequestService csDeptTrainingHrrequestService;

    @RequiresPermissions("system:hrrequest:view")
    @GetMapping()
    public String hrrequest()
    {
        return prefix + "/hrrequest";
    }

    @RequiresPermissions("system:hrrequest:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsDeptTrainingHrrequest csDeptTrainingHrrequest)
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
            csDeptTrainingHrrequest.setRequestBy(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csDeptTrainingHrrequest.setDeptName(currentUser.getDept().getDeptName());
        }
        
        startPage();
        List<CsDeptTrainingHrrequest> list = csDeptTrainingHrrequestService.selectCsDeptTrainingHrrequestList(csDeptTrainingHrrequest);
        return getDataTable(list);
    }

    @RequiresPermissions("system:hrrequest:export")
    @Log(title = "培训需求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsDeptTrainingHrrequest csDeptTrainingHrrequest)
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
            csDeptTrainingHrrequest.setRequestBy(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csDeptTrainingHrrequest.setDeptName(currentUser.getDept().getDeptName());
        }
        
        List<CsDeptTrainingHrrequest> list = csDeptTrainingHrrequestService.selectCsDeptTrainingHrrequestList(csDeptTrainingHrrequest);
        ExcelUtil<CsDeptTrainingHrrequest> util = new ExcelUtil<CsDeptTrainingHrrequest>(CsDeptTrainingHrrequest.class);
        return util.exportExcel(list, "培训需求数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:hrrequest:add")
    @Log(title = "培训需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsDeptTrainingHrrequest csDeptTrainingHrrequest)
    {
        return toAjax(csDeptTrainingHrrequestService.insertCsDeptTrainingHrrequest(csDeptTrainingHrrequest));
    }

    @RequiresPermissions("system:hrrequest:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsDeptTrainingHrrequest csDeptTrainingHrrequest = csDeptTrainingHrrequestService.selectCsDeptTrainingHrrequestById(id);
        mmap.put("csDeptTrainingHrrequest", csDeptTrainingHrrequest);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:hrrequest:edit")
    @Log(title = "培训需求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsDeptTrainingHrrequest csDeptTrainingHrrequest)
    {
        return toAjax(csDeptTrainingHrrequestService.updateCsDeptTrainingHrrequest(csDeptTrainingHrrequest));
    }

    @RequiresPermissions("system:hrrequest:remove")
    @Log(title = "培训需求", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csDeptTrainingHrrequestService.deleteCsDeptTrainingHrrequestByIds(ids));
    }
}
