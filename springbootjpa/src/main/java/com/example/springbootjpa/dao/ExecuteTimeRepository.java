package com.example.springbootjpa.dao;


import com.example.springbootjpa.domain.ExecuteTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path="times")
public interface ExecuteTimeRepository extends CustomRepository<ExecuteTime,String> {

    List<ExecuteTime> findByStatus(long status);


    ExecuteTime findByMethodDescAndStatus(String methodDesc,long status);

    @RestResource(path="withMethodDescAndStatusQuery" , rel="withMethodDescAndStatusQuery" )
    @Query("select a from ExecuteTime a where a.methodDesc=:methodDesc and a.status=:status")
    ExecuteTime withMethodDescAndStatusQuery(@Param("methodDesc") String methodDesc,@Param("status") long status);


}
