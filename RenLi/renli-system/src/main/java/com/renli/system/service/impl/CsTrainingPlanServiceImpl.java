package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsTrainingPlanMapper;
import com.renli.system.domain.CsTrainingPlan;
import com.renli.system.service.ICsTrainingPlanService;
import com.renli.common.core.text.Convert;

/**
 * 培训计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsTrainingPlanServiceImpl implements ICsTrainingPlanService 
{
    @Autowired
    private CsTrainingPlanMapper csTrainingPlanMapper;

    /**
     * 查询培训计划
     * 
     * @param id 培训计划主键
     * @return 培训计划
     */
    @Override
    public CsTrainingPlan selectCsTrainingPlanById(Long id)
    {
        return csTrainingPlanMapper.selectCsTrainingPlanById(id);
    }

    /**
     * 查询培训计划列表
     * 
     * @param csTrainingPlan 培训计划
     * @return 培训计划
     */
    @Override
    public List<CsTrainingPlan> selectCsTrainingPlanList(CsTrainingPlan csTrainingPlan)
    {
        return csTrainingPlanMapper.selectCsTrainingPlanList(csTrainingPlan);
    }

    /**
     * 新增培训计划
     * 
     * @param csTrainingPlan 培训计划
     * @return 结果
     */
    @Override
    public int insertCsTrainingPlan(CsTrainingPlan csTrainingPlan)
    {
        return csTrainingPlanMapper.insertCsTrainingPlan(csTrainingPlan);
    }

    /**
     * 修改培训计划
     * 
     * @param csTrainingPlan 培训计划
     * @return 结果
     */
    @Override
    public int updateCsTrainingPlan(CsTrainingPlan csTrainingPlan)
    {
        return csTrainingPlanMapper.updateCsTrainingPlan(csTrainingPlan);
    }

    /**
     * 批量删除培训计划
     * 
     * @param ids 需要删除的培训计划主键
     * @return 结果
     */
    @Override
    public int deleteCsTrainingPlanByIds(String ids)
    {
        return csTrainingPlanMapper.deleteCsTrainingPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除培训计划信息
     * 
     * @param id 培训计划主键
     * @return 结果
     */
    @Override
    public int deleteCsTrainingPlanById(Long id)
    {
        return csTrainingPlanMapper.deleteCsTrainingPlanById(id);
    }
}
