package com.spring3.core3.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
