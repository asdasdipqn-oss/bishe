package com.renli.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 招聘岗位发布对象 cs_recruitment_post
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsRecruitmentPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String positionName;

    /** 岗位薪资 */
    @Excel(name = "岗位薪资")
    private String department;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String workLocation;

    /** 岗位描述 */
    @Excel(name = "岗位描述")
    private String jobDescription;

    /** 任职要求 */
    @Excel(name = "任职要求")
    private String requirements;

    /** 招聘状态 */
    @Excel(name = "招聘状态")
    private String postStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPositionName(String positionName) 
    {
        this.positionName = positionName;
    }

    public String getPositionName() 
    {
        return positionName;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setWorkLocation(String workLocation) 
    {
        this.workLocation = workLocation;
    }

    public String getWorkLocation() 
    {
        return workLocation;
    }
    public void setJobDescription(String jobDescription) 
    {
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() 
    {
        return jobDescription;
    }
    public void setRequirements(String requirements) 
    {
        this.requirements = requirements;
    }

    public String getRequirements() 
    {
        return requirements;
    }
    public void setPostStatus(String postStatus) 
    {
        this.postStatus = postStatus;
    }

    public String getPostStatus() 
    {
        return postStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("positionName", getPositionName())
            .append("department", getDepartment())
            .append("workLocation", getWorkLocation())
            .append("jobDescription", getJobDescription())
            .append("requirements", getRequirements())
            .append("postStatus", getPostStatus())
            .toString();
    }
}
