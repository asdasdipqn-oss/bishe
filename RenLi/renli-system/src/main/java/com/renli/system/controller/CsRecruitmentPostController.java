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
import com.renli.system.domain.CsRecruitmentPost;
import com.renli.system.service.ICsRecruitmentPostService;
import com.renli.common.core.controller.BaseController;
import com.renli.common.core.domain.AjaxResult;
import com.renli.common.utils.poi.ExcelUtil;
import com.renli.common.core.page.TableDataInfo;

/**
 * 招聘岗位发布Controller
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Controller
@RequestMapping("/system/gangwei")
public class CsRecruitmentPostController extends BaseController
{
    private String prefix = "system/gangwei";

    @Autowired
    private ICsRecruitmentPostService csRecruitmentPostService;

    @RequiresPermissions("system:gangwei:view")
    @GetMapping()
    public String gangwei()
    {
        return prefix + "/gangwei";
    }

    /**
     * 查询招聘岗位发布列表
     */
    @RequiresPermissions("system:gangwei:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsRecruitmentPost csRecruitmentPost)
    {
        startPage();
        List<CsRecruitmentPost> list = csRecruitmentPostService.selectCsRecruitmentPostList(csRecruitmentPost);
        return getDataTable(list);
    }

    /**
     * 导出招聘岗位发布列表
     */
    @RequiresPermissions("system:gangwei:export")
    @Log(title = "招聘岗位发布", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsRecruitmentPost csRecruitmentPost)
    {
        List<CsRecruitmentPost> list = csRecruitmentPostService.selectCsRecruitmentPostList(csRecruitmentPost);
        ExcelUtil<CsRecruitmentPost> util = new ExcelUtil<CsRecruitmentPost>(CsRecruitmentPost.class);
        return util.exportExcel(list, "招聘岗位发布数据");
    }

    /**
     * 新增招聘岗位发布
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存招聘岗位发布
     */
    @RequiresPermissions("system:gangwei:add")
    @Log(title = "招聘岗位发布", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsRecruitmentPost csRecruitmentPost)
    {
        return toAjax(csRecruitmentPostService.insertCsRecruitmentPost(csRecruitmentPost));
    }

    /**
     * 修改招聘岗位发布
     */
    @RequiresPermissions("system:gangwei:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsRecruitmentPost csRecruitmentPost = csRecruitmentPostService.selectCsRecruitmentPostById(id);
        mmap.put("csRecruitmentPost", csRecruitmentPost);
        return prefix + "/edit";
    }

    /**
     * 修改保存招聘岗位发布
     */
    @RequiresPermissions("system:gangwei:edit")
    @Log(title = "招聘岗位发布", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsRecruitmentPost csRecruitmentPost)
    {
        return toAjax(csRecruitmentPostService.updateCsRecruitmentPost(csRecruitmentPost));
    }

    /**
     * 删除招聘岗位发布
     */
    @RequiresPermissions("system:gangwei:remove")
    @Log(title = "招聘岗位发布", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csRecruitmentPostService.deleteCsRecruitmentPostByIds(ids));
    }
}
