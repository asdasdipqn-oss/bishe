package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsEvaluationResultMapper;
import com.renli.system.domain.CsEvaluationResult;
import com.renli.system.service.ICsEvaluationResultService;
import com.renli.common.core.text.Convert;

/**
 * 培训考核结果Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsEvaluationResultServiceImpl implements ICsEvaluationResultService 
{
    @Autowired
    private CsEvaluationResultMapper csEvaluationResultMapper;

    /**
     * 查询培训考核结果
     * 
     * @param id 培训考核结果主键
     * @return 培训考核结果
     */
    @Override
    public CsEvaluationResult selectCsEvaluationResultById(Long id)
    {
        return csEvaluationResultMapper.selectCsEvaluationResultById(id);
    }

    /**
     * 查询培训考核结果列表
     * 
     * @param csEvaluationResult 培训考核结果
     * @return 培训考核结果
     */
    @Override
    public List<CsEvaluationResult> selectCsEvaluationResultList(CsEvaluationResult csEvaluationResult)
    {
        return csEvaluationResultMapper.selectCsEvaluationResultList(csEvaluationResult);
    }

    /**
     * 新增培训考核结果
     * 
     * @param csEvaluationResult 培训考核结果
     * @return 结果
     */
    @Override
    public int insertCsEvaluationResult(CsEvaluationResult csEvaluationResult)
    {
        return csEvaluationResultMapper.insertCsEvaluationResult(csEvaluationResult);
    }

    /**
     * 修改培训考核结果
     * 
     * @param csEvaluationResult 培训考核结果
     * @return 结果
     */
    @Override
    public int updateCsEvaluationResult(CsEvaluationResult csEvaluationResult)
    {
        return csEvaluationResultMapper.updateCsEvaluationResult(csEvaluationResult);
    }

    /**
     * 批量删除培训考核结果
     * 
     * @param ids 需要删除的培训考核结果主键
     * @return 结果
     */
    @Override
    public int deleteCsEvaluationResultByIds(String ids)
    {
        return csEvaluationResultMapper.deleteCsEvaluationResultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除培训考核结果信息
     * 
     * @param id 培训考核结果主键
     * @return 结果
     */
    @Override
    public int deleteCsEvaluationResultById(Long id)
    {
        return csEvaluationResultMapper.deleteCsEvaluationResultById(id);
    }
}
