package com.controller;

import com.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class MemberController {
  private final MemberService memberService;

  @Autowired // 스프링 컨테이너에 있는 memberService를 가져와 연결
  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  @GetMapping("/members/new")
  public String createForm(){
    return "members/createMemberForm";
  }

  @PostMapping("/members/new")
  public String create(MemberForm form) {
    Member member = new Member();
    member.setName(form.getName());

    memberService.join(member);

    return "redirect:/"; // "localhost:8080/" 화면으로 이동
  }

  @GetMapping("/members")
  public String list(Model model) {
    List<Member> members = memberService.findMembers();

    model.addAttribute("members", members);
    return "members/memberList";
  }
}