package com.renli.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 考勤规则配置对象 cs_attendance_rule
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsAttendanceRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 规则名称 */
    @Excel(name = "规则名称")
    private String ruleName;

    /** 规则详情 */
    @Excel(name = "规则详情")
    private String ruleDetails;

    /** 适用部门 */
    @Excel(name = "适用部门")
    private String applicableDept;

    /** 生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRuleName(String ruleName) 
    {
        this.ruleName = ruleName;
    }

    public String getRuleName() 
    {
        return ruleName;
    }
    public void setRuleDetails(String ruleDetails) 
    {
        this.ruleDetails = ruleDetails;
    }

    public String getRuleDetails() 
    {
        return ruleDetails;
    }
    public void setApplicableDept(String applicableDept) 
    {
        this.applicableDept = applicableDept;
    }

    public String getApplicableDept() 
    {
        return applicableDept;
    }
    public void setEffectiveDate(Date effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() 
    {
        return effectiveDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ruleName", getRuleName())
            .append("ruleDetails", getRuleDetails())
            .append("applicableDept", getApplicableDept())
            .append("effectiveDate", getEffectiveDate())
            .toString();
    }
}
