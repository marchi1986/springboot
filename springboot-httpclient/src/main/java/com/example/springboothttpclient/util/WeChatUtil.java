package com.example.springboothttpclient.util;

import com.alibaba.fastjson.JSONObject;
import com.example.springboothttpclient.service.HttpAPIService;
import com.example.springboothttpclient.weixin.domain.GeneralToken;
import com.example.springboothttpclient.weixin.domain.WeiXinSendApplicationMesModel;

import java.util.HashMap;
import java.util.Map;

public class WeChatUtil {
    public static GeneralToken getToken(String corpid, String corpsecret){
        try {
            Map<String,Object> param=new HashMap<String,Object>();

            param.put("corpid",corpid);
            param.put("corpsecret",corpsecret);
            HttpAPIService httpAPIService=(HttpAPIService) SpringUtil.getBean("httpAPIService");
            String str=httpAPIService.doGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken",param);
            GeneralToken token= JSONObject.parseObject(str, GeneralToken.class);

            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        WeiXinSendApplicationMesModel model=new WeiXinSendApplicationMesModel();
        model.setTouser("MaXiFang");
        model.setTotag("");
        model.setToparty("");
        model.setMsgtype("text");
        model.setAgentid("wx111fb30173cb341c");
        model.setSafe(0);
        model.getText().setContent("你的快递已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。");
        JSONObject jsonObject=new JSONObject();

        String str= jsonObject.toJSONString(model);
        System.out.println(str);
    }
}
