package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsEvaluationSchemeMapper;
import com.renli.system.domain.CsEvaluationScheme;
import com.renli.system.service.ICsEvaluationSchemeService;
import com.renli.common.core.text.Convert;

/**
 * 考核方案Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsEvaluationSchemeServiceImpl implements ICsEvaluationSchemeService 
{
    @Autowired
    private CsEvaluationSchemeMapper csEvaluationSchemeMapper;

    /**
     * 查询考核方案
     * 
     * @param id 考核方案主键
     * @return 考核方案
     */
    @Override
    public CsEvaluationScheme selectCsEvaluationSchemeById(Long id)
    {
        return csEvaluationSchemeMapper.selectCsEvaluationSchemeById(id);
    }

    /**
     * 查询考核方案列表
     * 
     * @param csEvaluationScheme 考核方案
     * @return 考核方案
     */
    @Override
    public List<CsEvaluationScheme> selectCsEvaluationSchemeList(CsEvaluationScheme csEvaluationScheme)
    {
        return csEvaluationSchemeMapper.selectCsEvaluationSchemeList(csEvaluationScheme);
    }

    /**
     * 新增考核方案
     * 
     * @param csEvaluationScheme 考核方案
     * @return 结果
     */
    @Override
    public int insertCsEvaluationScheme(CsEvaluationScheme csEvaluationScheme)
    {
        return csEvaluationSchemeMapper.insertCsEvaluationScheme(csEvaluationScheme);
    }

    /**
     * 修改考核方案
     * 
     * @param csEvaluationScheme 考核方案
     * @return 结果
     */
    @Override
    public int updateCsEvaluationScheme(CsEvaluationScheme csEvaluationScheme)
    {
        return csEvaluationSchemeMapper.updateCsEvaluationScheme(csEvaluationScheme);
    }

    /**
     * 批量删除考核方案
     * 
     * @param ids 需要删除的考核方案主键
     * @return 结果
     */
    @Override
    public int deleteCsEvaluationSchemeByIds(String ids)
    {
        return csEvaluationSchemeMapper.deleteCsEvaluationSchemeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考核方案信息
     * 
     * @param id 考核方案主键
     * @return 结果
     */
    @Override
    public int deleteCsEvaluationSchemeById(Long id)
    {
        return csEvaluationSchemeMapper.deleteCsEvaluationSchemeById(id);
    }
}
