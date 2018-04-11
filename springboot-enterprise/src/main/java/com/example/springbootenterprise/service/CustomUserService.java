package com.example.springbootenterprise.service;

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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser user=sysUserRepository.findByUsername(s);
        if (user==null){
            throw new UsernameNotFoundException("用户名:"+s+"不存在!");
        }

        return user;
    }
}
