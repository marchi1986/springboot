package com.example.springbootmvc.controller;

import com.example.springbootmvc.config.ConfigBean;
import com.example.springbootmvc.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class LucyController {
    @Autowired
    ConfigBean configBean;

    @Autowired
    User user;

    @ApiOperation(value = "lucy",notes = "lucy")
    @RequestMapping("/lucy")
    public String lucy(){
        return configBean.getGreeting()+"-"+configBean.getName()+"-"+configBean.getUuid()+"-"+configBean.getMax();
    }
    @ApiOperation(value = "user",notes = "user")
    @RequestMapping("/user")
    public String user(){
        return user.getName()+":"+user.getAge();
    }
}
