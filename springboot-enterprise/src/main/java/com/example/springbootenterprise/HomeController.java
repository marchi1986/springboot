package com.example.springbootenterprise;

import com.example.springbootenterprise.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String index(Model model){
        Msg msg=new Msg("测试标题","测试内容","额外信息");
        model.addAttribute("msg",msg);
        return "home";
    }

    @RequestMapping("/security")
    public String security(Model model){
        Msg msg=new Msg("测试标题","测试内容","额外信息");
        model.addAttribute("msg",msg);
        return "home";
    }
}
