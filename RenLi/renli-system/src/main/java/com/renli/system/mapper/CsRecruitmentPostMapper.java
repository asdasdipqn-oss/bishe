package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsRecruitmentPost;

/**
 * 招聘岗位发布Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsRecruitmentPostMapper 
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
     * 删除招聘岗位发布
     * 
     * @param id 招聘岗位发布主键
     * @return 结果
     */
    public int deleteCsRecruitmentPostById(Long id);

    /**
     * 批量删除招聘岗位发布
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsRecruitmentPostByIds(String[] ids);
}
