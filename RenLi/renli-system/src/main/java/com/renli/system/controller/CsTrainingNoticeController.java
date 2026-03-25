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
import com.renli.system.domain.CsTrainingNotice;
import com.renli.system.service.ICsTrainingNoticeService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.utils.DeptPermissionUtils;

@Controller
@RequestMapping("/system/tongzhi")
public class CsTrainingNoticeController extends BaseController
{
    private String prefix = "system/tongzhi";

    @Autowired
    private ICsTrainingNoticeService csTrainingNoticeService;

    @RequiresPermissions("system:tongzhi:view")
    @GetMapping()
    public String tongzhi()
    {
        return prefix + "/tongzhi";
    }

    @RequiresPermissions("system:tongzhi:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsTrainingNotice csTrainingNotice)
    {
        SysUser currentUser = getSysUser();
        String permissionType = DeptPermissionUtils.getUserPermissionType(currentUser);

        // 根据部门权限设置过滤条件
        if (DeptPermissionUtils.isDeptUser(currentUser) || DeptPermissionUtils.isDeptManager(currentUser)) {
            // 普通员工和部门经理只能看自己部门的培训通知
            String deptName = DeptPermissionUtils.getUserVisibleDeptName(currentUser);
            if (deptName != null && !deptName.isEmpty()) {
                csTrainingNotice.setTargetDept(deptName);
            }
        }

        startPage();
        List<CsTrainingNotice> list = csTrainingNoticeService.selectCsTrainingNoticeList(csTrainingNotice);
        return getDataTable(list);
    }

    @RequiresPermissions("system:tongzhi:export")
    @Log(title = "通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsTrainingNotice csTrainingNotice)
    {
        SysUser currentUser = getSysUser();
        String permissionType = DeptPermissionUtils.getUserPermissionType(currentUser);

        // 根据部门权限设置过滤条件
        if (DeptPermissionUtils.isDeptUser(currentUser) || DeptPermissionUtils.isDeptManager(currentUser)) {
            // 普通员工和部门经理只能导出自己部门的培训通知
            String deptName = DeptPermissionUtils.getUserVisibleDeptName(currentUser);
            if (deptName != null && !deptName.isEmpty()) {
                csTrainingNotice.setTargetDept(deptName);
            }
        }

        List<CsTrainingNotice> list = csTrainingNoticeService.selectCsTrainingNoticeList(csTrainingNotice);
        ExcelUtil<CsTrainingNotice> util = new ExcelUtil<CsTrainingNotice>(CsTrainingNotice.class);
        return util.exportExcel(list, "通知数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:tongzhi:add")
    @Log(title = "通知", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsTrainingNotice csTrainingNotice)
    {
        return toAjax(csTrainingNoticeService.insertCsTrainingNotice(csTrainingNotice));
    }

    @RequiresPermissions("system:tongzhi:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsTrainingNotice csTrainingNotice = csTrainingNoticeService.selectCsTrainingNoticeById(id);
        mmap.put("csTrainingNotice", csTrainingNotice);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:tongzhi:edit")
    @Log(title = "通知", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsTrainingNotice csTrainingNotice)
    {
        return toAjax(csTrainingNoticeService.updateCsTrainingNotice(csTrainingNotice));
    }

    @RequiresPermissions("system:tongzhi:remove")
    @Log(title = "通知", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csTrainingNoticeService.deleteCsTrainingNoticeByIds(ids));
    }
}
