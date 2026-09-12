package com.sehyun.backend.jpa.basic;

import com.sehyun.backend.jpa.persistence.MemberRepository;
import com.sehyun.backend.jpa.transaction.JpaMemberService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberJpaTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager entityManager;
    @Autowired
    JpaMemberService jpaMemberService;

    @Test
    void memberSaveTest() {
        Member member = new Member("Lee");

        Member savedMember = memberRepository.save(member);

        assertThat(savedMember.getId()).isNotNull();
        assertThat(savedMember.getName()).isEqualTo("Lee");
    }

    @Test
    void firstLevelCacheTest() {
        Member member = new Member("Lee");
        Member savedMember = memberRepository.save(member);

        Long memberId = savedMember.getId();

        entityManager.flush();
        entityManager.clear();

        Member member1 = memberRepository.findById(memberId)
                .orElseThrow();

        Member member2 = memberRepository.findById(memberId)
                .orElseThrow();

        assertThat(member1).isSameAs(member2);
    }

    @Test
    void dirtyCheckingTest() {
        Member member = new Member("Lee");
        Member savedMember = memberRepository.save(member);

        entityManager.flush();
        entityManager.clear();

        Member findMember = memberRepository.findById(savedMember.getId())
                .orElseThrow();

        findMember.changeName("Kim");

        entityManager.flush();

        assertThat(findMember.getName()).isEqualTo("Kim");
    }

    @Test
    void flushAndRollbackTest() {
        Member member = new Member("Lee");
        Member savedMember = memberRepository.save(member);

        entityManager.flush();
        entityManager.clear();

        Member findMember = memberRepository.findById(savedMember.getId())
                .orElseThrow();

        findMember.changeName("ROLLBACK_TEST");

        System.out.println("===== BEFORE FLUSH =====");

        entityManager.flush();

        System.out.println("===== AFTER FLUSH =====");

        throw new RuntimeException("rollback test");
    }

}