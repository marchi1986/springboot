package com.example.springbootwebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()//设置SpringSecurity对/和“login”路径不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//设置SpringSecurity的登录页面访问的路径为/login
                .defaultSuccessUrl("/chat")//登录成功后转向/chat
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    //在内存中分别配置两个用户，角色USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())//在此处应用自定义PasswordEncoder
                .withUser("wyf").password("wyf").roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER");
    }

    //静态资源，不拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
