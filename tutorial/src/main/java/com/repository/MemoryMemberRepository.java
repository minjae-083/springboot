package com.repository;

import com.domain.Member;
import java.util.*;


public class MemoryMemberRepository implements MemberRepository{
  private static Map<Long, Member> store = new HashMap<>();

  private static long sequence = 0L;

  @Override
  public Member save(Member member){
    member.setId(++sequence); // key값 설정
    store.put(member.getId(), member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id){
    return Optional.ofNullable(store.get(id)); // null일 경우 Optional로 감싸서 반환
  }

  @Override
  public Optional<Member> findByName(String name){
    return store.values().stream() // store에 저장된 값들을 루프
      .filter(member->member.getName().equals(name)) // member를 param으로 전달, getName으로 이름이 같은지 확인
      .findAny(); // 하나라도 찾으면 반환
  }

  @Override
  public List<Member> findAll(){
    return new ArrayList<>(store.values());
  }
}