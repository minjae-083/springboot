package com.test.java.service;

import com.domain.Member;
import com.repository.MemoryMemberRepository;
import com.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
  MemoryMemberRepository memberRepository;
  MemberService memberService;
  
  @Test
  void joinTest(){
    // given
    Member member = new Member();
    member.setName("testMember");

    // when
    // 회원가입, 반환 id를 saveId에 저장
    Long saveId = memberService.join(member);

    // then
    // 회원가입한 member의 id로 회원 조회, 해당 객체 findMember에 저장
    Member findMember = memberService.findOne(saveId).get();
    // 객체 동일성 비교
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @BeforeEach
  public void beforeEach(){
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }
  @AfterEach
  public void afterEach(){
    memberRepository.clearStore();
  }
}