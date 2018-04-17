package com.example.springboothttpclient.weixin.listener;

import com.example.springboothttpclient.util.WeChatUtil;
import com.example.springboothttpclient.weixin.domain.GeneralToken;
import com.example.springboothttpclient.weixin.domain.Token;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PmsServletContextListener implements ServletContextListener {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    /**
     *
     ServletContextListener是servlet容器中的一个API接口, 它用来监听ServletContext的生命周期，也就是相当于用来监听Web应用的生命周期。今天我们就来说说如何在Springboot 1.5.2这个轻量型框架中如何使用它。
     其实配置ServletContextListener与其它Filter, Listener, Servlet方法是一致的，具体可参考Springboot 1.5.2 官方文档
     首先写一个类来实现ServletContextListener接口，并实现contextInitialized(), contextDestroyed()两个父类方法，并使用@WebListener注解， 具体代码如下：
     */

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        logger.info("liting: contextDestroyed");
        System.out.println("liting: contextDestroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        String corpid="wx111fb30173cb341c";
        String corpsecret="VLfnT8gTstCoO8UD6KXrmlzt41JZfG5gVvVvu-IjC4s";
        GeneralToken token= WeChatUtil.getToken(corpid,corpsecret);

        if(token != null && StringUtils.isNotEmpty(token.getAccess_token())){
            Token.getInstance().setToken(token.getAccess_token());
        }
    }



    /**
     * 其次在Springboot web 应用启动代码中添加@ServletComponentScan注解，使我们的Springboot应用在启动时能扫描到该Listener.
     */

}
