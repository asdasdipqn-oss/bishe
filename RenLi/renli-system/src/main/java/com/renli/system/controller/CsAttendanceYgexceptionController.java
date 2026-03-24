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
import com.renli.system.domain.CsAttendanceYgexception;
import com.renli.system.service.ICsAttendanceYgexceptionService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/ygexception")
public class CsAttendanceYgexceptionController extends BaseController
{
    private String prefix = "system/ygexception";

    @Autowired
    private ICsAttendanceYgexceptionService csAttendanceYgexceptionService;

    @RequiresPermissions("system:ygexception:view")
    @GetMapping()
    public String ygexception()
    {
        return prefix + "/ygexception";
    }

    @RequiresPermissions("system:ygexception:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsAttendanceYgexception csAttendanceYgexception)
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
            csAttendanceYgexception.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csAttendanceYgexception.setDept(currentUser.getDept().getDeptName());
        }
        
        startPage();
        List<CsAttendanceYgexception> list = csAttendanceYgexceptionService.selectCsAttendanceYgexceptionList(csAttendanceYgexception);
        return getDataTable(list);
    }

    @RequiresPermissions("system:ygexception:export")
    @Log(title = "考勤异常申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsAttendanceYgexception csAttendanceYgexception)
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
            csAttendanceYgexception.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csAttendanceYgexception.setDept(currentUser.getDept().getDeptName());
        }
        
        List<CsAttendanceYgexception> list = csAttendanceYgexceptionService.selectCsAttendanceYgexceptionList(csAttendanceYgexception);
        ExcelUtil<CsAttendanceYgexception> util = new ExcelUtil<CsAttendanceYgexception>(CsAttendanceYgexception.class);
        return util.exportExcel(list, "考勤异常申请数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:ygexception:add")
    @Log(title = "考勤异常申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsAttendanceYgexception csAttendanceYgexception)
    {
        return toAjax(csAttendanceYgexceptionService.insertCsAttendanceYgexception(csAttendanceYgexception));
    }

    @RequiresPermissions("system:ygexception:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsAttendanceYgexception csAttendanceYgexception = csAttendanceYgexceptionService.selectCsAttendanceYgexceptionById(id);
        mmap.put("csAttendanceYgexception", csAttendanceYgexception);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:ygexception:edit")
    @Log(title = "考勤异常申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsAttendanceYgexception csAttendanceYgexception)
    {
        return toAjax(csAttendanceYgexceptionService.updateCsAttendanceYgexception(csAttendanceYgexception));
    }

    @RequiresPermissions("system:ygexception:remove")
    @Log(title = "考勤异常申请", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csAttendanceYgexceptionService.deleteCsAttendanceYgexceptionByIds(ids));
    }
}
