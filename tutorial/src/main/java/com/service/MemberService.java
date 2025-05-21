package com.service;

import com.domain.Member;
import com.repository.MemberRepository;
import com.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;


public class MemberService {
  private final MemberRepository memberRepository = new MemoryMemberRepository();

  public Long join(Member member) {
    // 중복 회원 검증 메서드 호출
    validateDuplicateMember(member);

    memberRepository.save(member);

    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
      .ifPresent(m->{
        throw new IllegalStateException("이미 존재하는 회원입니다.");
      });
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}