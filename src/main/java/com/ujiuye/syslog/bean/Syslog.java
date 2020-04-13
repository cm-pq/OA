package com.ujiuye.syslog.bean;

import java.util.Date;

public class Syslog {
    private Integer sid;

    @Override
    public String toString() {
        return "Syslog{" +
                "sid=" + sid +
                ", sysusername='" + sysusername + '\'' +
                ", systime=" + systime +
                ", sysurl='" + sysurl + '\'' +
                '}';
    }

    private String sysusername;

    private Date systime;

    private String sysurl;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSysusername() {
        return sysusername;
    }

    public void setSysusername(String sysusername) {
        this.sysusername = sysusername == null ? null : sysusername.trim();
    }

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public String getSysurl() {
        return sysurl;
    }

    public void setSysurl(String sysurl) {
        this.sysurl = sysurl == null ? null : sysurl.trim();
    }
}