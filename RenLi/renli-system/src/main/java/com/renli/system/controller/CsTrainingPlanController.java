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
import com.renli.system.domain.CsTrainingPlan;
import com.renli.system.service.ICsTrainingPlanService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.utils.DeptPermissionUtils;

@Controller
@RequestMapping("/system/plan")
public class CsTrainingPlanController extends BaseController
{
    private String prefix = "system/plan";

    @Autowired
    private ICsTrainingPlanService csTrainingPlanService;

    @RequiresPermissions("system:plan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/plan";
    }

    @RequiresPermissions("system:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsTrainingPlan csTrainingPlan)
    {
        SysUser currentUser = getSysUser();
        String permissionType = DeptPermissionUtils.getUserPermissionType(currentUser);

        // 根据部门权限设置过滤条件
        if (DeptPermissionUtils.isDeptUser(currentUser) || DeptPermissionUtils.isDeptManager(currentUser)) {
            // 普通员工和部门经理只能看自己部门的培训计划
            String deptName = DeptPermissionUtils.getUserVisibleDeptName(currentUser);
            if (deptName != null && !deptName.isEmpty()) {
                csTrainingPlan.setDeptTarget(deptName);
            }
        }

        startPage();
        List<CsTrainingPlan> list = csTrainingPlanService.selectCsTrainingPlanList(csTrainingPlan);
        return getDataTable(list);
    }

    @RequiresPermissions("system:plan:export")
    @Log(title = "培训计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsTrainingPlan csTrainingPlan)
    {
        SysUser currentUser = getSysUser();
        String permissionType = DeptPermissionUtils.getUserPermissionType(currentUser);

        // 根据部门权限设置过滤条件
        if (DeptPermissionUtils.isDeptUser(currentUser) || DeptPermissionUtils.isDeptManager(currentUser)) {
            // 普通员工和部门经理只能导出自己部门的培训计划
            String deptName = DeptPermissionUtils.getUserVisibleDeptName(currentUser);
            if (deptName != null && !deptName.isEmpty()) {
                csTrainingPlan.setDeptTarget(deptName);
            }
        }

        List<CsTrainingPlan> list = csTrainingPlanService.selectCsTrainingPlanList(csTrainingPlan);
        ExcelUtil<CsTrainingPlan> util = new ExcelUtil<CsTrainingPlan>(CsTrainingPlan.class);
        return util.exportExcel(list, "培训计划数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:plan:add")
    @Log(title = "培训计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsTrainingPlan csTrainingPlan)
    {
        return toAjax(csTrainingPlanService.insertCsTrainingPlan(csTrainingPlan));
    }

    @RequiresPermissions("system:plan:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsTrainingPlan csTrainingPlan = csTrainingPlanService.selectCsTrainingPlanById(id);
        mmap.put("csTrainingPlan", csTrainingPlan);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:plan:edit")
    @Log(title = "培训计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsTrainingPlan csTrainingPlan)
    {
        return toAjax(csTrainingPlanService.updateCsTrainingPlan(csTrainingPlan));
    }

    @RequiresPermissions("system:plan:remove")
    @Log(title = "培训计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csTrainingPlanService.deleteCsTrainingPlanByIds(ids));
    }
}
