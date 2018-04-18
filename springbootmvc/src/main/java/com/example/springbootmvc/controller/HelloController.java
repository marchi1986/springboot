package com.example.springbootmvc.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @ApiOperation(value = "hello",notes = "hello")
    @RequestMapping("/hello")
    public String index(){
        return "Greetings from Spring Boot!";
    }
}
