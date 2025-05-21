package com.test.java.service;

import com.domain.Member;
import com.service.MemberService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
  MemberService memberService = new MemberService();
  
  @Test
  void joinTest(){
    Member member = new Member();
    member.setName("testMember");

    Long saveId = memberService.join(member);

    Member findMember = memberService.findOne(saveId).get();

    assertThat(member.getName()).isEqualTo(findMember.getName());
  }
}