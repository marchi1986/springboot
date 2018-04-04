package com.example.springbootmvc;

import com.example.springbootmvc.model.PersonDO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class SpringbootmvcApplication {

	@RequestMapping("/")
	public String index(Model model){
		PersonDO single=new PersonDO("aa",11);
		List<PersonDO> list=new ArrayList<PersonDO>();
		PersonDO p1=new PersonDO("xx",11);
		PersonDO p2=new PersonDO("yy",22);
		PersonDO p3=new PersonDO("zz",33);

		list.add(p1);
		list.add(p2);
		list.add(p3);

		model.addAttribute("singlePerson",single);
		model.addAttribute("people",list);

		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmvcApplication.class, args);
	}
}
