package com.example.springboothttpclient.weixin.domain;


public class GeneralToken {


    private String expires_in; //成功有效时间
    private String access_token;  // 普通Token
    private String errcode; //失败ID
    private String errmsg; //失败消息

    public GeneralToken() {
    }

    public GeneralToken(String expires_in, String access_token, String errcode, String errmsg) {
        this.expires_in = expires_in;
        this.access_token = access_token;
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "GeneralToken{" +
                "expires_in='" + expires_in + '\'' +
                ", access_token='" + access_token + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
