package com.example.springboothttpclient.weixin.domain;

public class WeiXinSendApplicationMesModel {

    public WeiXinSendApplicationMesModel() {
        this.text=new Text();
    }

    public WeiXinSendApplicationMesModel(String touser, String toparty, String totag, String msgtype, String agentid, Integer safe, Text text) {
        this.touser = touser;
        this.toparty = toparty;
        this.totag = totag;
        this.msgtype = msgtype;
        this.agentid = agentid;
        this.safe = safe;
        this.text = text;
    }

    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private String agentid;
    private Integer safe;
    private Text text;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public class Text{

        public Text() {
        }

        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


}
