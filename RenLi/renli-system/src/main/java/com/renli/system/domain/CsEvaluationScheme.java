package com.renli.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 考核方案对象 cs_evaluation_scheme
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsEvaluationScheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 培训编号 */
    @Excel(name = "培训编号")
    private String titleId;

    /** 考核名称 */
    @Excel(name = "考核名称")
    private String schemeName;

    /** 适用考核周期 */
    @Excel(name = "适用考核周期")
    private String evalPeriod;

    /** 考核内容 */
    @Excel(name = "考核内容")
    private String criteria;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitleId(String titleId) 
    {
        this.titleId = titleId;
    }

    public String getTitleId() 
    {
        return titleId;
    }
    public void setSchemeName(String schemeName) 
    {
        this.schemeName = schemeName;
    }

    public String getSchemeName() 
    {
        return schemeName;
    }
    public void setEvalPeriod(String evalPeriod) 
    {
        this.evalPeriod = evalPeriod;
    }

    public String getEvalPeriod() 
    {
        return evalPeriod;
    }
    public void setCriteria(String criteria) 
    {
        this.criteria = criteria;
    }

    public String getCriteria() 
    {
        return criteria;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("titleId", getTitleId())
            .append("schemeName", getSchemeName())
            .append("evalPeriod", getEvalPeriod())
            .append("criteria", getCriteria())
            .toString();
    }
}
