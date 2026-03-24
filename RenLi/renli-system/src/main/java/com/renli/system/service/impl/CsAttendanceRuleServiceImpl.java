package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsAttendanceRuleMapper;
import com.renli.system.domain.CsAttendanceRule;
import com.renli.system.service.ICsAttendanceRuleService;
import com.renli.common.core.text.Convert;

/**
 * 考勤规则配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsAttendanceRuleServiceImpl implements ICsAttendanceRuleService 
{
    @Autowired
    private CsAttendanceRuleMapper csAttendanceRuleMapper;

    /**
     * 查询考勤规则配置
     * 
     * @param id 考勤规则配置主键
     * @return 考勤规则配置
     */
    @Override
    public CsAttendanceRule selectCsAttendanceRuleById(Long id)
    {
        return csAttendanceRuleMapper.selectCsAttendanceRuleById(id);
    }

    /**
     * 查询考勤规则配置列表
     * 
     * @param csAttendanceRule 考勤规则配置
     * @return 考勤规则配置
     */
    @Override
    public List<CsAttendanceRule> selectCsAttendanceRuleList(CsAttendanceRule csAttendanceRule)
    {
        return csAttendanceRuleMapper.selectCsAttendanceRuleList(csAttendanceRule);
    }

    /**
     * 新增考勤规则配置
     * 
     * @param csAttendanceRule 考勤规则配置
     * @return 结果
     */
    @Override
    public int insertCsAttendanceRule(CsAttendanceRule csAttendanceRule)
    {
        return csAttendanceRuleMapper.insertCsAttendanceRule(csAttendanceRule);
    }

    /**
     * 修改考勤规则配置
     * 
     * @param csAttendanceRule 考勤规则配置
     * @return 结果
     */
    @Override
    public int updateCsAttendanceRule(CsAttendanceRule csAttendanceRule)
    {
        return csAttendanceRuleMapper.updateCsAttendanceRule(csAttendanceRule);
    }

    /**
     * 批量删除考勤规则配置
     * 
     * @param ids 需要删除的考勤规则配置主键
     * @return 结果
     */
    @Override
    public int deleteCsAttendanceRuleByIds(String ids)
    {
        return csAttendanceRuleMapper.deleteCsAttendanceRuleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤规则配置信息
     * 
     * @param id 考勤规则配置主键
     * @return 结果
     */
    @Override
    public int deleteCsAttendanceRuleById(Long id)
    {
        return csAttendanceRuleMapper.deleteCsAttendanceRuleById(id);
    }
}
