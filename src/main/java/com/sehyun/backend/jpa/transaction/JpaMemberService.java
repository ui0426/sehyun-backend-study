package com.sehyun.backend.jpa.transaction;

import com.sehyun.backend.jpa.basic.Member;
import com.sehyun.backend.jpa.persistence.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JpaMemberService {

    private final MemberRepository memberRepository;
    private final EntityManager entityManager;

    @Transactional
    public Long createMember(String name) {
        Member member = new Member(name);

        memberRepository.save(member);

        return member.getId();
    }

    @Transactional
    public void changeName(Long memberId, String newName) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        member.changeName(newName);
    }

    @Transactional(readOnly = true)
    public void firstLevelCache(Long memberId) {
        Member member1 = memberRepository.findById(memberId)
                .orElseThrow();

        Member member2 = memberRepository.findById(memberId)
                .orElseThrow();

        System.out.println(member1 == member2);
    }

    @Transactional
    public void flushAndRollback(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        member.changeName("ROLLBACK_TEST");

        memberRepository.flush();

        throw new RuntimeException("rollback");
    }

    @Transactional
    public void changeNameAndFail(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        member.changeName("ROLLBACK_TEST");

        entityManager.flush();

        throw new RuntimeException("rollback test");
    }
}