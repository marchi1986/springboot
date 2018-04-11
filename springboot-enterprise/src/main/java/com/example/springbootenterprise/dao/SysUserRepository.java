package com.example.springbootenterprise.dao;

import com.example.springbootenterprise.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Long>{

    SysUser findByUsername(String username);
}
