package com.renli.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 培训计划对象 cs_training_plan
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsTrainingPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 培训编号 */
    @Excel(name = "培训编号")
    private String titleId;

    /** 计划名称 */
    @Excel(name = "计划名称")
    private String planName;

    /** 目标部门 */
    @Excel(name = "目标部门")
    private String deptTarget;

    /** 培训内容 */
    @Excel(name = "培训内容")
    private String trainingContent;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

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
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setDeptTarget(String deptTarget) 
    {
        this.deptTarget = deptTarget;
    }

    public String getDeptTarget() 
    {
        return deptTarget;
    }
    public void setTrainingContent(String trainingContent) 
    {
        this.trainingContent = trainingContent;
    }

    public String getTrainingContent() 
    {
        return trainingContent;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("titleId", getTitleId())
            .append("planName", getPlanName())
            .append("deptTarget", getDeptTarget())
            .append("trainingContent", getTrainingContent())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .toString();
    }
}
