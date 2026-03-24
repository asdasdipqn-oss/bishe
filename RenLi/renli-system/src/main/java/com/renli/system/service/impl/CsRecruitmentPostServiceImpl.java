package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsRecruitmentPostMapper;
import com.renli.system.domain.CsRecruitmentPost;
import com.renli.system.service.ICsRecruitmentPostService;
import com.renli.common.core.text.Convert;

/**
 * 招聘岗位发布Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsRecruitmentPostServiceImpl implements ICsRecruitmentPostService 
{
    @Autowired
    private CsRecruitmentPostMapper csRecruitmentPostMapper;

    /**
     * 查询招聘岗位发布
     * 
     * @param id 招聘岗位发布主键
     * @return 招聘岗位发布
     */
    @Override
    public CsRecruitmentPost selectCsRecruitmentPostById(Long id)
    {
        return csRecruitmentPostMapper.selectCsRecruitmentPostById(id);
    }

    /**
     * 查询招聘岗位发布列表
     * 
     * @param csRecruitmentPost 招聘岗位发布
     * @return 招聘岗位发布
     */
    @Override
    public List<CsRecruitmentPost> selectCsRecruitmentPostList(CsRecruitmentPost csRecruitmentPost)
    {
        return csRecruitmentPostMapper.selectCsRecruitmentPostList(csRecruitmentPost);
    }

    /**
     * 新增招聘岗位发布
     * 
     * @param csRecruitmentPost 招聘岗位发布
     * @return 结果
     */
    @Override
    public int insertCsRecruitmentPost(CsRecruitmentPost csRecruitmentPost)
    {
        return csRecruitmentPostMapper.insertCsRecruitmentPost(csRecruitmentPost);
    }

    /**
     * 修改招聘岗位发布
     * 
     * @param csRecruitmentPost 招聘岗位发布
     * @return 结果
     */
    @Override
    public int updateCsRecruitmentPost(CsRecruitmentPost csRecruitmentPost)
    {
        return csRecruitmentPostMapper.updateCsRecruitmentPost(csRecruitmentPost);
    }

    /**
     * 批量删除招聘岗位发布
     * 
     * @param ids 需要删除的招聘岗位发布主键
     * @return 结果
     */
    @Override
    public int deleteCsRecruitmentPostByIds(String ids)
    {
        return csRecruitmentPostMapper.deleteCsRecruitmentPostByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除招聘岗位发布信息
     * 
     * @param id 招聘岗位发布主键
     * @return 结果
     */
    @Override
    public int deleteCsRecruitmentPostById(Long id)
    {
        return csRecruitmentPostMapper.deleteCsRecruitmentPostById(id);
    }
}
