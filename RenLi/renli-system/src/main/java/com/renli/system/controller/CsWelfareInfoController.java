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
import com.renli.system.domain.CsWelfareInfo;
import com.renli.system.service.ICsWelfareInfoService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;
import com.renli.common.core.domain.entity.SysUser;
import com.renli.common.core.domain.entity.SysRole;

@Controller
@RequestMapping("/system/info")
public class CsWelfareInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private ICsWelfareInfoService csWelfareInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsWelfareInfo csWelfareInfo)
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
            csWelfareInfo.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csWelfareInfo.setEmployee(null);
        }
        
        startPage();
        List<CsWelfareInfo> list = csWelfareInfoService.selectCsWelfareInfoList(csWelfareInfo);
        return getDataTable(list);
    }

    @RequiresPermissions("system:info:export")
    @Log(title = "员工福利信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsWelfareInfo csWelfareInfo)
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
            csWelfareInfo.setEmployee(currentUser.getUserName());
        }
        else if (isDeptManager) {
            csWelfareInfo.setEmployee(null);
        }
        
        List<CsWelfareInfo> list = csWelfareInfoService.selectCsWelfareInfoList(csWelfareInfo);
        ExcelUtil<CsWelfareInfo> util = new ExcelUtil<CsWelfareInfo>(CsWelfareInfo.class);
        return util.exportExcel(list, "员工福利信息数据");
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("system:info:add")
    @Log(title = "员工福利信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsWelfareInfo csWelfareInfo)
    {
        return toAjax(csWelfareInfoService.insertCsWelfareInfo(csWelfareInfo));
    }

    @RequiresPermissions("system:info:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsWelfareInfo csWelfareInfo = csWelfareInfoService.selectCsWelfareInfoById(id);
        mmap.put("csWelfareInfo", csWelfareInfo);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:info:edit")
    @Log(title = "员工福利信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsWelfareInfo csWelfareInfo)
    {
        return toAjax(csWelfareInfoService.updateCsWelfareInfo(csWelfareInfo));
    }

    @RequiresPermissions("system:info:remove")
    @Log(title = "员工福利信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csWelfareInfoService.deleteCsWelfareInfoByIds(ids));
    }
}
