package com.renli.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 薪资明细对象 cs_salary_detail
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsSalaryDetail extends BaseEntity
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

    /** 薪资月份 */
    @Excel(name = "薪资月份")
    private String salaryMonth;

    /** 基本工资 */
    @Excel(name = "基本工资")
    private BigDecimal baseSalary;

    /** 绩效奖金 */
    @Excel(name = "绩效奖金")
    private BigDecimal performanceBonus;

    /** 福利奖金 */
    @Excel(name = "福利奖金")
    private BigDecimal overtimePay;

    /** 扣款 */
    @Excel(name = "扣款")
    private BigDecimal deduction;

    /** 实发工资 */
    @Excel(name = "实发工资")
    private BigDecimal netSalary;

    /** 详情 */
    @Excel(name = "详情")
    private String detailInfo;

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
    public void setSalaryMonth(String salaryMonth) 
    {
        this.salaryMonth = salaryMonth;
    }

    public String getSalaryMonth() 
    {
        return salaryMonth;
    }
    public void setBaseSalary(BigDecimal baseSalary) 
    {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getBaseSalary() 
    {
        return baseSalary;
    }
    public void setPerformanceBonus(BigDecimal performanceBonus) 
    {
        this.performanceBonus = performanceBonus;
    }

    public BigDecimal getPerformanceBonus() 
    {
        return performanceBonus;
    }
    public void setOvertimePay(BigDecimal overtimePay) 
    {
        this.overtimePay = overtimePay;
    }

    public BigDecimal getOvertimePay() 
    {
        return overtimePay;
    }
    public void setDeduction(BigDecimal deduction) 
    {
        this.deduction = deduction;
    }

    public BigDecimal getDeduction() 
    {
        return deduction;
    }
    public void setNetSalary(BigDecimal netSalary) 
    {
        this.netSalary = netSalary;
    }

    public BigDecimal getNetSalary() 
    {
        return netSalary;
    }
    public void setDetailInfo(String detailInfo) 
    {
        this.detailInfo = detailInfo;
    }

    public String getDetailInfo() 
    {
        return detailInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employee", getEmployee())
            .append("dept", getDept())
            .append("salaryMonth", getSalaryMonth())
            .append("baseSalary", getBaseSalary())
            .append("performanceBonus", getPerformanceBonus())
            .append("overtimePay", getOvertimePay())
            .append("deduction", getDeduction())
            .append("netSalary", getNetSalary())
            .append("detailInfo", getDetailInfo())
            .toString();
    }
}
