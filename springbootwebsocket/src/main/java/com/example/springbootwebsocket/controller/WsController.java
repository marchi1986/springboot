package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.model.MarchiMessage;
import com.example.springbootwebsocket.model.MarchiResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public MarchiResponse say(MarchiMessage message) throws Exception{
        Thread.sleep(3000);
        return new MarchiResponse("Welcome,"+message.getName()+"!");
    }
}
