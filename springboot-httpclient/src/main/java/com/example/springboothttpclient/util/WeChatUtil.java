package com.example.springboothttpclient.util;

import com.alibaba.fastjson.JSONObject;
import com.example.springboothttpclient.service.HttpAPIService;
import com.example.springboothttpclient.weixin.domain.GeneralToken;

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
}
