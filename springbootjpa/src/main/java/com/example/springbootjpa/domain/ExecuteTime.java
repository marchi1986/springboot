package com.example.springbootjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class ExecuteTime implements Serializable{

  @Id
  private String method;
  private String methodDesc;
  private java.sql.Timestamp lastExeTime;
  private Long status;
  private java.sql.Timestamp lastModifyTime;

    public ExecuteTime() {
        super();
    }

    public ExecuteTime(String method, String methodDesc, Timestamp lastExeTime, Long status, Timestamp lastModifyTime) {
        this.method = method;
        this.methodDesc = methodDesc;
        this.lastExeTime = lastExeTime;
        this.status = status;
        this.lastModifyTime = lastModifyTime;
    }

    public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }


  public String getMethodDesc() {
    return methodDesc;
  }

  public void setMethodDesc(String methodDesc) {
    this.methodDesc = methodDesc;
  }


  public java.sql.Timestamp getLastExeTime() {
    return lastExeTime;
  }

  public void setLastExeTime(java.sql.Timestamp lastExeTime) {
    this.lastExeTime = lastExeTime;
  }


  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }


  public java.sql.Timestamp getLastModifyTime() {
    return lastModifyTime;
  }

  public void setLastModifyTime(java.sql.Timestamp lastModifyTime) {
    this.lastModifyTime = lastModifyTime;
  }

}
