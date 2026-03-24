package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsResumeYhscreening;

/**
 * 简历筛选Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsResumeYhscreeningMapper 
{
    /**
     * 查询简历筛选
     * 
     * @param id 简历筛选主键
     * @return 简历筛选
     */
    public CsResumeYhscreening selectCsResumeYhscreeningById(Long id);

    /**
     * 查询简历筛选列表
     * 
     * @param csResumeYhscreening 简历筛选
     * @return 简历筛选集合
     */
    public List<CsResumeYhscreening> selectCsResumeYhscreeningList(CsResumeYhscreening csResumeYhscreening);

    /**
     * 新增简历筛选
     * 
     * @param csResumeYhscreening 简历筛选
     * @return 结果
     */
    public int insertCsResumeYhscreening(CsResumeYhscreening csResumeYhscreening);

    /**
     * 修改简历筛选
     * 
     * @param csResumeYhscreening 简历筛选
     * @return 结果
     */
    public int updateCsResumeYhscreening(CsResumeYhscreening csResumeYhscreening);

    /**
     * 删除简历筛选
     * 
     * @param id 简历筛选主键
     * @return 结果
     */
    public int deleteCsResumeYhscreeningById(Long id);

    /**
     * 批量删除简历筛选
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsResumeYhscreeningByIds(String[] ids);
}
