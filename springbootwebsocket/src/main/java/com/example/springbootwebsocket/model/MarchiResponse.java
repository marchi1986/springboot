package com.example.springbootwebsocket.model;

public class MarchiResponse {
    private String responseMessage;

    public MarchiResponse() {
    }

    public MarchiResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
