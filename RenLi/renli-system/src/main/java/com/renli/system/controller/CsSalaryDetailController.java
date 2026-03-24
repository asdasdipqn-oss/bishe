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
import com.renli.system.domain.CsSalaryDetail;
import com.renli.system.service.ICsSalaryDetailService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/detail")
public class CsSalaryDetailController extends BaseController
{
    private String prefix = "system/detail";

    @Autowired
    private ICsSalaryDetailService csSalaryDetailService;

    @RequiresPermissions("system:detail:view")
    @GetMapping()
    public String detail()
    {
        return prefix + "/detail";
    }

    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsSalaryDetail csSalaryDetail)
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
            csSalaryDetail.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csSalaryDetail.setDept(currentUser.getDept().getDeptName());
        }
        
        startPage();
        List<CsSalaryDetail> list = csSalaryDetailService.selectCsSalaryDetailList(csSalaryDetail);
        return getDataTable(list);
    }

    @RequiresPermissions("system:detail:export")
    @Log(title = "薪资明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsSalaryDetail csSalaryDetail)
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
            csSalaryDetail.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csSalaryDetail.setDept(currentUser.getDept().getDeptName());
        }
        
        List<CsSalaryDetail> list = csSalaryDetailService.selectCsSalaryDetailList(csSalaryDetail);
        ExcelUtil<CsSalaryDetail> util = new ExcelUtil<CsSalaryDetail>(CsSalaryDetail.class);
        return util.exportExcel(list, "薪资明细数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:detail:add")
    @Log(title = "薪资明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsSalaryDetail csSalaryDetail)
    {
        return toAjax(csSalaryDetailService.insertCsSalaryDetail(csSalaryDetail));
    }

    @RequiresPermissions("system:detail:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsSalaryDetail csSalaryDetail = csSalaryDetailService.selectCsSalaryDetailById(id);
        mmap.put("csSalaryDetail", csSalaryDetail);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:detail:edit")
    @Log(title = "薪资明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsSalaryDetail csSalaryDetail)
    {
        return toAjax(csSalaryDetailService.updateCsSalaryDetail(csSalaryDetail));
    }

    @RequiresPermissions("system:detail:remove")
    @Log(title = "薪资明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csSalaryDetailService.deleteCsSalaryDetailByIds(ids));
    }
}
