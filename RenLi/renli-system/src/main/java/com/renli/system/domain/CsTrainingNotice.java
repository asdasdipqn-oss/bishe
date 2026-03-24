package com.renli.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.renli.common.annotation.Excel;
import com.renli.common.core.domain.BaseEntity;

/**
 * 通知对象 cs_training_notice
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public class CsTrainingNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 培训编号 */
    @Excel(name = "培训编号")
    private String titleId;

    /** 通知标题 */
    @Excel(name = "通知标题")
    private String title;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String content;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 培训时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "培训时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trainingTime;

    /** 培训地点 */
    @Excel(name = "培训地点")
    private String location;

    /** 部门 */
    @Excel(name = "部门")
    private String targetDept;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }
    public void setTrainingTime(Date trainingTime) 
    {
        this.trainingTime = trainingTime;
    }

    public Date getTrainingTime() 
    {
        return trainingTime;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setTargetDept(String targetDept) 
    {
        this.targetDept = targetDept;
    }

    public String getTargetDept() 
    {
        return targetDept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("titleId", getTitleId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("publishTime", getPublishTime())
            .append("trainingTime", getTrainingTime())
            .append("location", getLocation())
            .append("targetDept", getTargetDept())
            .toString();
    }
}
