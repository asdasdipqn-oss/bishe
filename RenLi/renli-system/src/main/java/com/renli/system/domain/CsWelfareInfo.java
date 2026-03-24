package com.renli.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 员工福利信息对象 cs_welfare_info
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsWelfareInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 员工 */
    @Excel(name = "员工")
    private String employee;

    /** 福利类型 */
    @Excel(name = "福利类型")
    private String welfareType;

    /** 福利金额 */
    @Excel(name = "福利金额")
    private Long money;

    /** 福利详情 */
    @Excel(name = "福利详情")
    private String description;

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
    public void setWelfareType(String welfareType) 
    {
        this.welfareType = welfareType;
    }

    public String getWelfareType() 
    {
        return welfareType;
    }
    public void setMoney(Long money) 
    {
        this.money = money;
    }

    public Long getMoney() 
    {
        return money;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employee", getEmployee())
            .append("welfareType", getWelfareType())
            .append("money", getMoney())
            .append("description", getDescription())
            .toString();
    }
}
