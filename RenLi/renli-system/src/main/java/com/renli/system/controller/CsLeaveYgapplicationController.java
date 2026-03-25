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
import com.renli.system.domain.CsLeaveYgapplication;
import com.renli.system.service.ICsLeaveYgapplicationService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.utils.DeptPermissionUtils;

/**
 * 假期申请Controller
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Controller
@RequestMapping("/system/ygapplication")
public class CsLeaveYgapplicationController extends BaseController
{
    private String prefix = "system/ygapplication";

    @Autowired
    private ICsLeaveYgapplicationService csLeaveYgapplicationService;

    @RequiresPermissions("system:ygapplication:view")
    @GetMapping()
    public String ygapplication()
    {
        return prefix + "/ygapplication";
    }

    /**
     * 查询假期申请列表
     */
    @RequiresPermissions("system:ygapplication:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsLeaveYgapplication csLeaveYgapplication)
    {
        SysUser currentUser = getSysUser();
        String permissionType = DeptPermissionUtils.getUserPermissionType(currentUser);

        // 根据部门权限设置过滤条件
        if (DeptPermissionUtils.isDeptUser(currentUser)) {
            // 普通员工只能看自己的请假申请
            csLeaveYgapplication.setEmployee(currentUser.getUserName());
        }
        else if (DeptPermissionUtils.isDeptManager(currentUser)) {
            // 部门经理可以看本部门的请假申请
            String deptName = DeptPermissionUtils.getUserVisibleDeptName(currentUser);
            if (deptName != null && !deptName.isEmpty()) {
                csLeaveYgapplication.setDept(deptName);
            }
        }
        // 管理员可以看所有请假申请

        startPage();
        List<CsLeaveYgapplication> list = csLeaveYgapplicationService.selectCsLeaveYgapplicationList(csLeaveYgapplication);
        return getDataTable(list);
    }

    /**
     * 导出假期申请列表
     */
    @RequiresPermissions("system:ygapplication:export")
    @Log(title = "假期申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsLeaveYgapplication csLeaveYgapplication)
    {
        SysUser currentUser = getSysUser();
        String permissionType = DeptPermissionUtils.getUserPermissionType(currentUser);

        // 根据部门权限设置过滤条件
        if (DeptPermissionUtils.isDeptUser(currentUser)) {
            // 普通员工只能导出自己的请假申请
            csLeaveYgapplication.setEmployee(currentUser.getUserName());
        }
        else if (DeptPermissionUtils.isDeptManager(currentUser)) {
            // 部门经理可以导出本部门的请假申请
            String deptName = DeptPermissionUtils.getUserVisibleDeptName(currentUser);
            if (deptName != null && !deptName.isEmpty()) {
                csLeaveYgapplication.setDept(deptName);
            }
        }
        // 管理员可以导出所有请假申请

        List<CsLeaveYgapplication> list = csLeaveYgapplicationService.selectCsLeaveYgapplicationList(csLeaveYgapplication);
        ExcelUtil<CsLeaveYgapplication> util = new ExcelUtil<CsLeaveYgapplication>(CsLeaveYgapplication.class);
        return util.exportExcel(list, "假期申请数据");
    }

    /**
     * 新增假期申请
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存假期申请
     */
    @RequiresPermissions("system:ygapplication:add")
    @Log(title = "假期申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsLeaveYgapplication csLeaveYgapplication)
    {
        SysUser currentUser = getSysUser();
        csLeaveYgapplication.setEmployee(currentUser.getUserName());
        if (currentUser.getDept() != null) {
            csLeaveYgapplication.setDept(currentUser.getDept().getDeptName());
        }
        return toAjax(csLeaveYgapplicationService.insertCsLeaveYgapplication(csLeaveYgapplication));
    }

    /**
     * 修改假期申请
     */
    @RequiresPermissions("system:ygapplication:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsLeaveYgapplication csLeaveYgapplication = csLeaveYgapplicationService.selectCsLeaveYgapplicationById(id);
        mmap.put("csLeaveYgapplication", csLeaveYgapplication);
        return prefix + "/edit";
    }

    /**
     * 修改保存假期申请
     */
    @RequiresPermissions("system:ygapplication:edit")
    @Log(title = "假期申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsLeaveYgapplication csLeaveYgapplication)
    {
        return toAjax(csLeaveYgapplicationService.updateCsLeaveYgapplication(csLeaveYgapplication));
    }

    /**
     * 删除假期申请
     */
    @RequiresPermissions("system:ygapplication:remove")
    @Log(title = "假期申请", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csLeaveYgapplicationService.deleteCsLeaveYgapplicationByIds(ids));
    }
}