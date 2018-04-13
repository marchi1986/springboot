package com.example.springbootenterprise.dao;

import com.example.springbootenterprise.domain.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SysResourceRepository extends JpaRepository<SysResource,Long>{

    SysResource findByName(String name);
}
