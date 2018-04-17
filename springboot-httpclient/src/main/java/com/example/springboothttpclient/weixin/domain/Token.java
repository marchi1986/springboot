package com.example.springboothttpclient.weixin.domain;

public class Token {
    private Token() {}
    private  String token;
    private static Token instance  = new Token();
    public static Token getInstance() {
        return instance;
    }
    public  String getToken() {
        return token;
    }
    public  void setToken(String token) {
        this.token = token;
    }
}
