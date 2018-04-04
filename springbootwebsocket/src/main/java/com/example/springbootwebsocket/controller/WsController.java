package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.model.MarchiMessage;
import com.example.springbootwebsocket.model.MarchiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    //广播模式
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public MarchiResponse say(MarchiMessage message) throws Exception{
        Thread.sleep(3000);
        return new MarchiResponse("Welcome,"+message.getName()+"!");
    }

    //点对点模式
    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg) throws Exception{

        if (principal.getName().equals("wyf")){
            simpMessagingTemplate.convertAndSendToUser("wisely","/queue/notifications",principal.getName()+"-send:"+msg);

        }else{
            simpMessagingTemplate.convertAndSendToUser("wyf","/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }
}
