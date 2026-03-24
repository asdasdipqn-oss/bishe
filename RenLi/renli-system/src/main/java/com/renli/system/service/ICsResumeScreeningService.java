package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsResumeScreening;

/**
 * 简历筛选Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsResumeScreeningService 
{
    /**
     * 查询简历筛选
     * 
     * @param id 简历筛选主键
     * @return 简历筛选
     */
    public CsResumeScreening selectCsResumeScreeningById(Long id);

    /**
     * 查询简历筛选列表
     * 
     * @param csResumeScreening 简历筛选
     * @return 简历筛选集合
     */
    public List<CsResumeScreening> selectCsResumeScreeningList(CsResumeScreening csResumeScreening);

    /**
     * 新增简历筛选
     * 
     * @param csResumeScreening 简历筛选
     * @return 结果
     */
    public int insertCsResumeScreening(CsResumeScreening csResumeScreening);

    /**
     * 修改简历筛选
     * 
     * @param csResumeScreening 简历筛选
     * @return 结果
     */
    public int updateCsResumeScreening(CsResumeScreening csResumeScreening);

    /**
     * 批量删除简历筛选
     * 
     * @param ids 需要删除的简历筛选主键集合
     * @return 结果
     */
    public int deleteCsResumeScreeningByIds(String ids);

    /**
     * 删除简历筛选信息
     * 
     * @param id 简历筛选主键
     * @return 结果
     */
    public int deleteCsResumeScreeningById(Long id);
}
