package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsTrainingPlan;

/**
 * 培训计划Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsTrainingPlanMapper 
{
    /**
     * 查询培训计划
     * 
     * @param id 培训计划主键
     * @return 培训计划
     */
    public CsTrainingPlan selectCsTrainingPlanById(Long id);

    /**
     * 查询培训计划列表
     * 
     * @param csTrainingPlan 培训计划
     * @return 培训计划集合
     */
    public List<CsTrainingPlan> selectCsTrainingPlanList(CsTrainingPlan csTrainingPlan);

    /**
     * 新增培训计划
     * 
     * @param csTrainingPlan 培训计划
     * @return 结果
     */
    public int insertCsTrainingPlan(CsTrainingPlan csTrainingPlan);

    /**
     * 修改培训计划
     * 
     * @param csTrainingPlan 培训计划
     * @return 结果
     */
    public int updateCsTrainingPlan(CsTrainingPlan csTrainingPlan);

    /**
     * 删除培训计划
     * 
     * @param id 培训计划主键
     * @return 结果
     */
    public int deleteCsTrainingPlanById(Long id);

    /**
     * 批量删除培训计划
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsTrainingPlanByIds(String[] ids);
}
