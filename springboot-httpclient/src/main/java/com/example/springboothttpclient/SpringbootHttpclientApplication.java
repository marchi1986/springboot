package com.example.springboothttpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootHttpclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHttpclientApplication.class, args);
	}
}
