package com.example.springbootenterprise.bean;

import com.example.springbootenterprise.domain.SysRole;
import com.example.springbootenterprise.domain.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailImpl implements UserDetails{

    private String username;
    private String password;
    private List<SysRole> roles;

    //无参构造
    public UserDetailImpl() {
    }

    //用User构造
    public UserDetailImpl(SysUser user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles=user.getRoles();
    }

    @Override
    //返回用户所有角色的封装，一个Role对应一个GrantedAuthority
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(SysRole role : roles) {
            System.out.println("用户拥有权限:"+role.getName());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public List<SysRole> getRoles(){
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    //判断账号是否已经过期，默认没有过期
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //判断账号是否被锁定，默认没有锁定
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //判断信用凭证是否过期，默认没有过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //判断账号是否可用，默认可用
    public boolean isEnabled() {
        return true;
    }
}
