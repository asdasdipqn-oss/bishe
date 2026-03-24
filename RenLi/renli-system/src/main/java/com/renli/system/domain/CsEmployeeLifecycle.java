package com.renli.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 员工全生命周期对象 cs_employee_lifecycle
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsEmployeeLifecycle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String lifecycleName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 入职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hireDate;

    /** 离职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leaveDate;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private String lifecycleStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLifecycleName(String lifecycleName) 
    {
        this.lifecycleName = lifecycleName;
    }

    public String getLifecycleName() 
    {
        return lifecycleName;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setHireDate(Date hireDate) 
    {
        this.hireDate = hireDate;
    }

    public Date getHireDate() 
    {
        return hireDate;
    }
    public void setLeaveDate(Date leaveDate) 
    {
        this.leaveDate = leaveDate;
    }

    public Date getLeaveDate() 
    {
        return leaveDate;
    }
    public void setLifecycleStatus(String lifecycleStatus) 
    {
        this.lifecycleStatus = lifecycleStatus;
    }

    public String getLifecycleStatus() 
    {
        return lifecycleStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lifecycleName", getLifecycleName())
            .append("idCard", getIdCard())
            .append("hireDate", getHireDate())
            .append("leaveDate", getLeaveDate())
            .append("lifecycleStatus", getLifecycleStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
