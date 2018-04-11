package com.example.springbootjpa.controller;

import com.example.springbootjpa.dao.ExecuteTimeRepository;
import com.example.springbootjpa.domain.ExecuteTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    ExecuteTimeRepository executeTimeRepository;

    /**
     *
     * @param method
     * @param methodDesc
     * @return
     */
    @RequestMapping("/save")
    public ExecuteTime save(String method,String methodDesc){
        ExecuteTime executeTime=executeTimeRepository.save(new ExecuteTime(method,methodDesc,new Timestamp(System.currentTimeMillis()),new Long(0),new Timestamp(System.currentTimeMillis())));

        return executeTime;
    }

    @RequestMapping("/q1")
    public List<ExecuteTime> q1(long status){
        List<ExecuteTime> list=executeTimeRepository.findByStatus(status);
        return list;
    }

    @RequestMapping("/q2")
    public ExecuteTime q2(String methodDesc,long status){
        ExecuteTime executeTime=executeTimeRepository.findByMethodDescAndStatus(methodDesc,status);
        return executeTime;
    }

    @RequestMapping("/q3")
    public ExecuteTime q3(String methodDesc,long status){
        ExecuteTime executeTime=executeTimeRepository.withMethodDescAndStatusQuery(methodDesc,status);
        return executeTime;
    }

    @RequestMapping("/sort")
    public List<ExecuteTime> sort(){
        List<ExecuteTime> list=executeTimeRepository.findAll(new Sort(Sort.Direction.ASC,"lastModifyTime"));
        return list;
    }

    @RequestMapping("/page1")
    public Page<ExecuteTime> page(){

        Pageable pageable =PageRequest.of(1,10);
        Page<ExecuteTime> page=executeTimeRepository.findAll(pageable);
        return page;
    }

    @RequestMapping("/page2")
    public Page<ExecuteTime> page2(ExecuteTime executeTime){

        Pageable pageable =PageRequest.of(1,10);
        Page<ExecuteTime> page=executeTimeRepository.queryByAuto(executeTime,pageable);
        return page;
    }
}
