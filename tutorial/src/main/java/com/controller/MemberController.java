package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.MemberService;

@Controller
public class MemberController {
  private final MemberService memberService;

  @Autowired // 스프링 컨테이너에 있는 memberService를 가져와 연결
  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }
}