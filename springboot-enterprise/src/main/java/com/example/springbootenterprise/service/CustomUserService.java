package com.example.springbootenterprise.service;

import com.example.springbootenterprise.bean.UserDetailImpl;
import com.example.springbootenterprise.dao.SysUserRepository;
import com.example.springbootenterprise.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService{

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    //重写UserDetailsService接口里面的抽象方法
    //根据用户名 返回一个UserDetails的实现类的实例
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("查找用户：" + s);
        SysUser user = sysUserRepository.findByUsername(s);
        if(user == null)
        {
            throw new UsernameNotFoundException("没有该用户");
        }

        //查到User后将其封装为UserDetails的实现类的实例供程序调用
        //用该User和它对应的Role实体们构造UserDetails的实现类
        return new UserDetailImpl(user);
    }


}
