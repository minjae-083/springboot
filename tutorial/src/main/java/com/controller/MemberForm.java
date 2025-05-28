package com.controller;

public class MemberForm {
  // createMemberForm.html의 input의 name속성의 값인 "name"과 같아야 함
  private String name;

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }
}