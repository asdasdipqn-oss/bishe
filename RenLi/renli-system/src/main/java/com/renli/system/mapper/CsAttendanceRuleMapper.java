package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsAttendanceRule;

/**
 * 考勤规则配置Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsAttendanceRuleMapper 
{
    /**
     * 查询考勤规则配置
     * 
     * @param id 考勤规则配置主键
     * @return 考勤规则配置
     */
    public CsAttendanceRule selectCsAttendanceRuleById(Long id);

    /**
     * 查询考勤规则配置列表
     * 
     * @param csAttendanceRule 考勤规则配置
     * @return 考勤规则配置集合
     */
    public List<CsAttendanceRule> selectCsAttendanceRuleList(CsAttendanceRule csAttendanceRule);

    /**
     * 新增考勤规则配置
     * 
     * @param csAttendanceRule 考勤规则配置
     * @return 结果
     */
    public int insertCsAttendanceRule(CsAttendanceRule csAttendanceRule);

    /**
     * 修改考勤规则配置
     * 
     * @param csAttendanceRule 考勤规则配置
     * @return 结果
     */
    public int updateCsAttendanceRule(CsAttendanceRule csAttendanceRule);

    /**
     * 删除考勤规则配置
     * 
     * @param id 考勤规则配置主键
     * @return 结果
     */
    public int deleteCsAttendanceRuleById(Long id);

    /**
     * 批量删除考勤规则配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsAttendanceRuleByIds(String[] ids);
}
