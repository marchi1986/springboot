package com.example.springbootwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker//通过注解开启使用STOMP协议来传输基于代理的消息，这时控制器支持使用@MessageMapping，就像使用@RequestMapping
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {


    //注册STOMP协议的节点，并映射的指定的URL
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册一个STOMP的endpoint，并指定使用SockJs协议
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
        //注册一个STOMP的endpoint，并指定使用SockJs协议
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    //配置消息代理
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式应配置一个/topic消息代理
        registry.enableSimpleBroker("/queue","/topic");
    }
}
