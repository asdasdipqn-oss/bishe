package com.liefox.entity.vo;

import java.sql.Date;

/**
 * @Author zjh
 * @Date 2021/6/21 下午 5:10
 **/
public class PageInfoVo {
    /*页*/
    private Integer page;
    /*条*/
    private Integer size;
    /*用户名*/
    private String username;
    /*地址*/
    private String address;
    /*开始时间*/
    private Date startTime;
    /*结束时间*/
    private Date endTime;

    public PageInfoVo() {
    }

    public PageInfoVo(Integer page, Integer size, String username, String address, Date startTime, Date endTime) {
        this.page = page;
        this.size = size;
        this.username = username;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
