package com.project.KwangJinProJect.repository;

import com.project.KwangJinProJect.domain.Member;

import java.util.Optional;

public interface kwangJinMemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByname(String name);

}
