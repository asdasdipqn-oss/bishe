package com.renli.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 薪资项目配置对象 cs_salary_item_config
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsSalaryItemConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 薪资名称 */
    @Excel(name = "薪资名称")
    private String itemName;

    /** 适用部门 */
    @Excel(name = "适用部门")
    private String applicableDept;

    /** 适用范围 */
    @Excel(name = "适用范围")
    private String post;

    /** 薪资详情 */
    @Excel(name = "薪资详情")
    private String salayDetails;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setApplicableDept(String applicableDept) 
    {
        this.applicableDept = applicableDept;
    }

    public String getApplicableDept() 
    {
        return applicableDept;
    }
    public void setPost(String post) 
    {
        this.post = post;
    }

    public String getPost() 
    {
        return post;
    }
    public void setSalayDetails(String salayDetails) 
    {
        this.salayDetails = salayDetails;
    }

    public String getSalayDetails() 
    {
        return salayDetails;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemName", getItemName())
            .append("applicableDept", getApplicableDept())
            .append("post", getPost())
            .append("salayDetails", getSalayDetails())
            .toString();
    }
}
