package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.repository.MemberRepository;
import com.repository.MemoryMemberRepository;
import com.service.MemberService;

@Configuration
public class SpringConfig {
  @Bean
  public MemberService memberService(){
    // spring bean에 등록되어 있는 MemberRepository를 가져옴
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
    return new MemoryMemberRepository();
  }
}