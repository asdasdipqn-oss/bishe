package com.renli.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 培训考核结果对象 cs_evaluation_result
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsEvaluationResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 员工 */
    @Excel(name = "员工")
    private String employee;

    /** 培训编号 */
    @Excel(name = "培训编号")
    private String titleId;

    /** 考核周期 */
    @Excel(name = "考核周期")
    private String evalPeriod;

    /** 考核得分 */
    @Excel(name = "考核得分")
    private BigDecimal score;

    /** 评语 */
    @Excel(name = "评语")
    private String comment;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployee(String employee) 
    {
        this.employee = employee;
    }

    public String getEmployee() 
    {
        return employee;
    }
    public void setTitleId(String titleId) 
    {
        this.titleId = titleId;
    }

    public String getTitleId() 
    {
        return titleId;
    }
    public void setEvalPeriod(String evalPeriod) 
    {
        this.evalPeriod = evalPeriod;
    }

    public String getEvalPeriod() 
    {
        return evalPeriod;
    }
    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employee", getEmployee())
            .append("titleId", getTitleId())
            .append("evalPeriod", getEvalPeriod())
            .append("score", getScore())
            .append("comment", getComment())
            .toString();
    }
}
