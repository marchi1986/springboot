package com.example.springbootenterprise.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class SysResource {

  private static final long serialVersionUID=1L;

  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @ManyToMany(mappedBy = "resources",fetch = FetchType.EAGER)
  private List<SysRole> roles;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SysRole> getRoles() {
    return roles;
  }

  public void setRoles(List<SysRole> roles) {
    this.roles = roles;
  }
}
