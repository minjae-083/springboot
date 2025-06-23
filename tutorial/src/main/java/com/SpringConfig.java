package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import com.repository.MemberRepository;
import com.repository.JdbcMemberRepository;
import com.service.MemberService;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import com.repository.JdbcTemplateMemberRepository;

@Configuration
public class SpringConfig {
  private DataSource dataSource;
  @Autowired
  public SpringConfig(DataSource dataSource){
    this.dataSource=dataSource;
  }
  
  @Bean
  public MemberService memberService(){
    // spring bean에 등록되어 있는 MemberRepository를 가져옴
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
    // return new JdbcMemberRepository(dataSource);
    return new JdbcTemplateMemberRepository(dataSource);
  }
}