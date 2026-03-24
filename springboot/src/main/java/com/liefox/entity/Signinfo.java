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

    public Signinfo() {
    }

    public Signinfo(String username, String temperature, String address, String date) {
        this.username = username;
        this.temperature = temperature;
        this.address = address;
        this.date = date;
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

}
