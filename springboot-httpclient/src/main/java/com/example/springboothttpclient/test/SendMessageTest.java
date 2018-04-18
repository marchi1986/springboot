package com.example.springboothttpclient.test;

import com.alibaba.fastjson.JSONObject;
import com.example.springboothttpclient.domain.HttpResult;
import com.example.springboothttpclient.service.HttpAPIService;
import com.example.springboothttpclient.util.WeChatUtil;
import com.example.springboothttpclient.weixin.domain.GeneralToken;
import com.example.springboothttpclient.weixin.domain.WeiXinSendApplicationMesModel;
import org.apache.http.entity.StringEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMessageTest {
    @Autowired
    private HttpAPIService httpAPIService;


    @Test
    public void test() {
        String url="https://qyapi.weixin.qq.com/cgi-bin/message/send";

        try {
            WeiXinSendApplicationMesModel model=new WeiXinSendApplicationMesModel();
            model.setTouser("LiangXingTai");
            model.setTotag("");
            model.setToparty("");
            model.setMsgtype("text");
            model.setAgentid("1000029");
            model.setSafe(0);
            model.getText().setContent("粉色是你的专属色");
            String str= JSONObject.toJSONString(model);

            Map<String,Object> params=new HashMap<>();
            params.put("access_token","z1cL6l1CU_W4vVFo0Ls8Jcf1bOpNwb8tknIT8facSzudNvwp-_H0Ioqg3UAWMN1cQ0tn7ILUhRHw-J_D2bss_YBy9xvIbrhwxnM7IHAuCBtSPRYR869EKNOP4yeocFcyXIPgLrnZcF26b-dOj7uRE0pvXdI8XDfGtx6g8kXQMXUQNi-hzJwCxOkXJts40n4V9Y3fY0-yaJa4g-nZpJ4ExQ");

            HttpResult result = httpAPIService.doPostForJsonParam(url,params,str);

            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void test2(){

        String url="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=IxfpPbdatv2QOF11JAYSbxjMHigVRfb-kLWoKMuE3TPZSlOxn7Xx6mXQAoPrW-gDsZ0mEZPbERh7ot0oACKLMN_ir3njTvW3cAlB6Pr0J12R65FoN4MoXL9LbVadoNtEeq1vw4LC-5eCMOVLTGtGJhFjDkzV_U2mnFLGk0h8Kl13sdXfcyZYRxytPB5iA28avwToUa4nfyM5nzmYZZSxPg&userid=MaXiFang";

        try {
            HttpResult result = httpAPIService.doPost(url);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
