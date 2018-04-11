package com.example.springbootjpa.dao.impl;

import com.example.springbootjpa.dao.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import javax.persistence.EntityManager;
import java.io.Serializable;
import static com.example.springbootjpa.specs.CustomerSpecs.byAuto;
import org.springframework.data.domain.Pageable;

public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository <T,ID> implements CustomRepository <T,ID>{


    private final EntityManager entityManager;


    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass,em);
        this.entityManager = em;
    }

    @Override
    public Page<T> queryByAuto(T example, Pageable pageable) {
        Specification spec=byAuto(entityManager,example);
        return findAll(spec,pageable);
    }
}
