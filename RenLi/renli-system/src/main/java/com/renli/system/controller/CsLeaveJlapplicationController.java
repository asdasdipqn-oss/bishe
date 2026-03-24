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
import com.renli.system.domain.CsLeaveJlapplication;
import com.renli.system.service.ICsLeaveJlapplicationService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/jlapplication")
public class CsLeaveJlapplicationController extends BaseController
{
    private String prefix = "system/jlapplication";

    @Autowired
    private ICsLeaveJlapplicationService csLeaveJlapplicationService;

    @RequiresPermissions("system:jlapplication:view")
    @GetMapping()
    public String jlapplication()
    {
        return prefix + "/jlapplication";
    }

    @RequiresPermissions("system:jlapplication:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsLeaveJlapplication csLeaveJlapplication)
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
            csLeaveJlapplication.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csLeaveJlapplication.setDept(currentUser.getDept().getDeptName());
        }
        
        startPage();
        List<CsLeaveJlapplication> list = csLeaveJlapplicationService.selectCsLeaveJlapplicationList(csLeaveJlapplication);
        return getDataTable(list);
    }

    @RequiresPermissions("system:jlapplication:export")
    @Log(title = "假期审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsLeaveJlapplication csLeaveJlapplication)
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
            csLeaveJlapplication.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csLeaveJlapplication.setDept(currentUser.getDept().getDeptName());
        }
        
        List<CsLeaveJlapplication> list = csLeaveJlapplicationService.selectCsLeaveJlapplicationList(csLeaveJlapplication);
        ExcelUtil<CsLeaveJlapplication> util = new ExcelUtil<CsLeaveJlapplication>(CsLeaveJlapplication.class);
        return util.exportExcel(list, "假期审批数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:jlapplication:add")
    @Log(title = "假期审批", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsLeaveJlapplication csLeaveJlapplication)
    {
        SysUser currentUser = getSysUser();
        csLeaveJlapplication.setEmployee(currentUser.getUserName());
        if (currentUser.getDept() != null) {
            csLeaveJlapplication.setDept(currentUser.getDept().getDeptName());
        }
        return toAjax(csLeaveJlapplicationService.insertCsLeaveJlapplication(csLeaveJlapplication));
    }

    @RequiresPermissions("system:jlapplication:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsLeaveJlapplication csLeaveJlapplication = csLeaveJlapplicationService.selectCsLeaveJlapplicationById(id);
        mmap.put("csLeaveJlapplication", csLeaveJlapplication);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:jlapplication:edit")
    @Log(title = "假期审批", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsLeaveJlapplication csLeaveJlapplication)
    {
        return toAjax(csLeaveJlapplicationService.updateCsLeaveJlapplication(csLeaveJlapplication));
    }

    @RequiresPermissions("system:jlapplication:remove")
    @Log(title = "假期审批", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csLeaveJlapplicationService.deleteCsLeaveJlapplicationByIds(ids));
    }
}
