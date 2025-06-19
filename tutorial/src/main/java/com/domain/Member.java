package com.domain;

public class Member {
  private Long id;
  private String name;

  // id getter, setter
  public Long getId() {
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }

  // name getter, setter
  public String getName() {
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  @Override
  public boolean equals(Object o){
    if (this==o) return true;
    if (!(o instanceof Member)) return false;
    Member other = (Member) o;
    return id!=null && id.equals(other.getId());
  }

  @Override
  public int hashCode(){
    return id!=null ? id.hashCode() : 0;
  }
}