package com.liefox.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author LIEFox
 * @since 2021-06-19
 */
public class Signinfo {

    private String username;

    private String temperature;

    private String address;

    private String date;

    private String dept;

    public Signinfo() {
    }

    public Signinfo(String username, String temperature, String address, String date, String dept) {
        this.username = username;
        this.temperature = temperature;
        this.address = address;
        this.date = date;
        this.dept = dept;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
