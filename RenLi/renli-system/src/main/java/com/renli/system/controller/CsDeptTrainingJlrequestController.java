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
import com.renli.system.domain.CsDeptTrainingJlrequest;
import com.renli.system.service.ICsDeptTrainingJlrequestService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/jlrequest")
public class CsDeptTrainingJlrequestController extends BaseController
{
    private String prefix = "system/jlrequest";

    @Autowired
    private ICsDeptTrainingJlrequestService csDeptTrainingJlrequestService;

    @RequiresPermissions("system:jlrequest:view")
    @GetMapping()
    public String jlrequest()
    {
        return prefix + "/jlrequest";
    }

    @RequiresPermissions("system:jlrequest:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsDeptTrainingJlrequest csDeptTrainingJlrequest)
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
            csDeptTrainingJlrequest.setRequestBy(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csDeptTrainingJlrequest.setDeptName(currentUser.getDept().getDeptName());
        }
        
        startPage();
        List<CsDeptTrainingJlrequest> list = csDeptTrainingJlrequestService.selectCsDeptTrainingJlrequestList(csDeptTrainingJlrequest);
        return getDataTable(list);
    }

    @RequiresPermissions("system:jlrequest:export")
    @Log(title = "培训需求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsDeptTrainingJlrequest csDeptTrainingJlrequest)
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
            csDeptTrainingJlrequest.setRequestBy(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csDeptTrainingJlrequest.setDeptName(currentUser.getDept().getDeptName());
        }
        
        List<CsDeptTrainingJlrequest> list = csDeptTrainingJlrequestService.selectCsDeptTrainingJlrequestList(csDeptTrainingJlrequest);
        ExcelUtil<CsDeptTrainingJlrequest> util = new ExcelUtil<CsDeptTrainingJlrequest>(CsDeptTrainingJlrequest.class);
        return util.exportExcel(list, "培训需求数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:jlrequest:add")
    @Log(title = "培训需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsDeptTrainingJlrequest csDeptTrainingJlrequest)
    {
        return toAjax(csDeptTrainingJlrequestService.insertCsDeptTrainingJlrequest(csDeptTrainingJlrequest));
    }

    @RequiresPermissions("system:jlrequest:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsDeptTrainingJlrequest csDeptTrainingJlrequest = csDeptTrainingJlrequestService.selectCsDeptTrainingJlrequestById(id);
        mmap.put("csDeptTrainingJlrequest", csDeptTrainingJlrequest);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:jlrequest:edit")
    @Log(title = "培训需求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsDeptTrainingJlrequest csDeptTrainingJlrequest)
    {
        return toAjax(csDeptTrainingJlrequestService.updateCsDeptTrainingJlrequest(csDeptTrainingJlrequest));
    }

    @RequiresPermissions("system:jlrequest:remove")
    @Log(title = "培训需求", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csDeptTrainingJlrequestService.deleteCsDeptTrainingJlrequestByIds(ids));
    }
}
