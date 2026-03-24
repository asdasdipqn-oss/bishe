package com.renli.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 考勤异常申请对象 cs_attendance_ygexception
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsAttendanceYgexception extends BaseEntity
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

    /** 异常日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "异常日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date exceptionDate;

    /** 说明 */
    @Excel(name = "说明")
    private String explanation;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String exceptionStatus;

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
    public void setExceptionDate(Date exceptionDate) 
    {
        this.exceptionDate = exceptionDate;
    }

    public Date getExceptionDate() 
    {
        return exceptionDate;
    }
    public void setExplanation(String explanation) 
    {
        this.explanation = explanation;
    }

    public String getExplanation() 
    {
        return explanation;
    }
    public void setExceptionStatus(String exceptionStatus) 
    {
        this.exceptionStatus = exceptionStatus;
    }

    public String getExceptionStatus() 
    {
        return exceptionStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employee", getEmployee())
            .append("dept", getDept())
            .append("exceptionDate", getExceptionDate())
            .append("explanation", getExplanation())
            .append("exceptionStatus", getExceptionStatus())
            .toString();
    }
}
