package com.renli.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 假期申请对象 cs_leave_ygapplication
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsLeaveYgapplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 员工 */
    @Excel(name = "员工")
    private String employee;

    /** 部门 */
    @Excel(name = "部门")
    private String dept;

    /** 请假类型 */
    @Excel(name = "请假类型")
    private String leaveType;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 请假原因 */
    @Excel(name = "请假原因")
    private String reason;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String applicationStatus;

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
    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDept() 
    {
        return dept;
    }
    public void setLeaveType(String leaveType) 
    {
        this.leaveType = leaveType;
    }

    public String getLeaveType() 
    {
        return leaveType;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setApplicationStatus(String applicationStatus) 
    {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationStatus() 
    {
        return applicationStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employee", getEmployee())
            .append("dept", getDept())
            .append("leaveType", getLeaveType())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("reason", getReason())
            .append("applicationStatus", getApplicationStatus())
            .toString();
    }
}
