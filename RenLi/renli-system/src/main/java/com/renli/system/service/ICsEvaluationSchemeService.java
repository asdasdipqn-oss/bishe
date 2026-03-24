package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsEvaluationScheme;

/**
 * 考核方案Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsEvaluationSchemeService 
{
    /**
     * 查询考核方案
     * 
     * @param id 考核方案主键
     * @return 考核方案
     */
    public CsEvaluationScheme selectCsEvaluationSchemeById(Long id);

    /**
     * 查询考核方案列表
     * 
     * @param csEvaluationScheme 考核方案
     * @return 考核方案集合
     */
    public List<CsEvaluationScheme> selectCsEvaluationSchemeList(CsEvaluationScheme csEvaluationScheme);

    /**
     * 新增考核方案
     * 
     * @param csEvaluationScheme 考核方案
     * @return 结果
     */
    public int insertCsEvaluationScheme(CsEvaluationScheme csEvaluationScheme);

    /**
     * 修改考核方案
     * 
     * @param csEvaluationScheme 考核方案
     * @return 结果
     */
    public int updateCsEvaluationScheme(CsEvaluationScheme csEvaluationScheme);

    /**
     * 批量删除考核方案
     * 
     * @param ids 需要删除的考核方案主键集合
     * @return 结果
     */
    public int deleteCsEvaluationSchemeByIds(String ids);

    /**
     * 删除考核方案信息
     * 
     * @param id 考核方案主键
     * @return 结果
     */
    public int deleteCsEvaluationSchemeById(Long id);
}
