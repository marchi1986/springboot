package com.example.springboothttpclient.test;

import com.example.springboothttpclient.service.HttpAPIService;
import com.example.springboothttpclient.util.WeChatUtil;
import com.example.springboothttpclient.weixin.domain.GeneralToken;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientManagerFactoryBenTest {

    @Autowired
    private HttpAPIService httpAPIService;

    @Test
    public void test() {
        String corpid="wx111fb30173cb341c";
        String corpsecret="VLfnT8gTstCoO8UD6KXrmlzt41JZfG5gVvVvu-IjC4s";
        GeneralToken token= WeChatUtil.getToken(corpid,corpsecret);
        System.out.println(token);
    }
}
