package com.renli.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 简历筛选对象 cs_resume_screening
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsResumeScreening extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 候选人姓名 */
    @Excel(name = "候选人姓名")
    private String candidateName;

    /** 应聘岗位 */
    @Excel(name = "应聘岗位")
    private String applyPosition;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 简历文件路径 */
    @Excel(name = "简历文件路径")
    private String resumeFilePath;

    /** 筛选状态 */
    @Excel(name = "筛选状态")
    private String screeningStatus;

    /** 筛选备注 */
    @Excel(name = "筛选备注")
    private String screeningNote;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCandidateName(String candidateName) 
    {
        this.candidateName = candidateName;
    }

    public String getCandidateName() 
    {
        return candidateName;
    }
    public void setApplyPosition(String applyPosition) 
    {
        this.applyPosition = applyPosition;
    }

    public String getApplyPosition() 
    {
        return applyPosition;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setResumeFilePath(String resumeFilePath) 
    {
        this.resumeFilePath = resumeFilePath;
    }

    public String getResumeFilePath() 
    {
        return resumeFilePath;
    }
    public void setScreeningStatus(String screeningStatus) 
    {
        this.screeningStatus = screeningStatus;
    }

    public String getScreeningStatus() 
    {
        return screeningStatus;
    }
    public void setScreeningNote(String screeningNote) 
    {
        this.screeningNote = screeningNote;
    }

    public String getScreeningNote() 
    {
        return screeningNote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("candidateName", getCandidateName())
            .append("applyPosition", getApplyPosition())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("resumeFilePath", getResumeFilePath())
            .append("screeningStatus", getScreeningStatus())
            .append("screeningNote", getScreeningNote())
            .toString();
    }
}
