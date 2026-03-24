package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsRecruitmentPost;

/**
 * 招聘岗位发布Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsRecruitmentPostService 
{
    /**
     * 查询招聘岗位发布
     * 
     * @param id 招聘岗位发布主键
     * @return 招聘岗位发布
     */
    public CsRecruitmentPost selectCsRecruitmentPostById(Long id);

    /**
     * 查询招聘岗位发布列表
     * 
     * @param csRecruitmentPost 招聘岗位发布
     * @return 招聘岗位发布集合
     */
    public List<CsRecruitmentPost> selectCsRecruitmentPostList(CsRecruitmentPost csRecruitmentPost);

    /**
     * 新增招聘岗位发布
     * 
     * @param csRecruitmentPost 招聘岗位发布
     * @return 结果
     */
    public int insertCsRecruitmentPost(CsRecruitmentPost csRecruitmentPost);

    /**
     * 修改招聘岗位发布
     * 
     * @param csRecruitmentPost 招聘岗位发布
     * @return 结果
     */
    public int updateCsRecruitmentPost(CsRecruitmentPost csRecruitmentPost);

    /**
     * 批量删除招聘岗位发布
     * 
     * @param ids 需要删除的招聘岗位发布主键集合
     * @return 结果
     */
    public int deleteCsRecruitmentPostByIds(String ids);

    /**
     * 删除招聘岗位发布信息
     * 
     * @param id 招聘岗位发布主键
     * @return 结果
     */
    public int deleteCsRecruitmentPostById(Long id);
}
