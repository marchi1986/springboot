package com.example.springbootjpa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;

@NoRepositoryBean
public interface CustomRepository<T extends Object,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>
{

    Page<T> queryByAuto(T example, Pageable pageable);
}
