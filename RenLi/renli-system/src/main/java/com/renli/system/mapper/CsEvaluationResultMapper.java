package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsEvaluationResult;

/**
 * 培训考核结果Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsEvaluationResultMapper 
{
    /**
     * 查询培训考核结果
     * 
     * @param id 培训考核结果主键
     * @return 培训考核结果
     */
    public CsEvaluationResult selectCsEvaluationResultById(Long id);

    /**
     * 查询培训考核结果列表
     * 
     * @param csEvaluationResult 培训考核结果
     * @return 培训考核结果集合
     */
    public List<CsEvaluationResult> selectCsEvaluationResultList(CsEvaluationResult csEvaluationResult);

    /**
     * 新增培训考核结果
     * 
     * @param csEvaluationResult 培训考核结果
     * @return 结果
     */
    public int insertCsEvaluationResult(CsEvaluationResult csEvaluationResult);

    /**
     * 修改培训考核结果
     * 
     * @param csEvaluationResult 培训考核结果
     * @return 结果
     */
    public int updateCsEvaluationResult(CsEvaluationResult csEvaluationResult);

    /**
     * 删除培训考核结果
     * 
     * @param id 培训考核结果主键
     * @return 结果
     */
    public int deleteCsEvaluationResultById(Long id);

    /**
     * 批量删除培训考核结果
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsEvaluationResultByIds(String[] ids);
}
