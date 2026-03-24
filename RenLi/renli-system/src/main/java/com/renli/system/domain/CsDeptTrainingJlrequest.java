package com.renli.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 培训需求对象 cs_dept_training_jlrequest
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsDeptTrainingJlrequest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 培训编号 */
    @Excel(name = "培训编号")
    private String titleId;

    /** 申请部门 */
    @Excel(name = "申请部门")
    private String deptName;

    /** 申请人 */
    @Excel(name = "申请人")
    private String requestBy;

    /** 培训主题 */
    @Excel(name = "培训主题")
    private String trainingTopic;

    /** 申请理由 */
    @Excel(name = "申请理由")
    private String reason;

    /** 期望培训时长 */
    @Excel(name = "期望培训时长")
    private String expectedTime;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String requestStatus;

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
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setRequestBy(String requestBy) 
    {
        this.requestBy = requestBy;
    }

    public String getRequestBy() 
    {
        return requestBy;
    }
    public void setTrainingTopic(String trainingTopic) 
    {
        this.trainingTopic = trainingTopic;
    }

    public String getTrainingTopic() 
    {
        return trainingTopic;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setExpectedTime(String expectedTime) 
    {
        this.expectedTime = expectedTime;
    }

    public String getExpectedTime() 
    {
        return expectedTime;
    }
    public void setRequestStatus(String requestStatus) 
    {
        this.requestStatus = requestStatus;
    }

    public String getRequestStatus() 
    {
        return requestStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("titleId", getTitleId())
            .append("deptName", getDeptName())
            .append("requestBy", getRequestBy())
            .append("trainingTopic", getTrainingTopic())
            .append("reason", getReason())
            .append("expectedTime", getExpectedTime())
            .append("requestStatus", getRequestStatus())
            .toString();
    }
}
