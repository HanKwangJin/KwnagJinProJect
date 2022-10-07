package com.project.KwangJinProJect.repository;

import com.project.KwangJinProJect.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KwangJinRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
    Member findByUsername(String username);
}

