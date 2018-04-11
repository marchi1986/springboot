package com.example.springbootenterprise.domain;

public class Msg {
    private String title;
    private String coneten;
    private String etraInfo;

    public Msg() {
    }

    public Msg(String title, String coneten, String etraInfo) {
        this.title = title;
        this.coneten = coneten;
        this.etraInfo = etraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConeten() {
        return coneten;
    }

    public void setConeten(String coneten) {
        this.coneten = coneten;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
