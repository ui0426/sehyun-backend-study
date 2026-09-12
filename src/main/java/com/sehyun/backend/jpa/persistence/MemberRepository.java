package com.sehyun.backend.jpa.persistence;

import com.sehyun.backend.jpa.basic.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}