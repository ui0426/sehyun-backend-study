package com.sehyun.backend.jpa.relation;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class RelationJpaTest {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RelationMemberRepository memberRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Commit
    void manyToOneSaveTest() {
        Team team = new Team("Backend");
        teamRepository.save(team);

        RelationMember member =
                new RelationMember("Lee", team);

        memberRepository.save(member);

        entityManager.flush();
        entityManager.clear();

        RelationMember findMember =
                memberRepository.findById(member.getId())
                        .orElseThrow();

        assertThat(findMember.getTeam().getId())
                .isEqualTo(team.getId());
    }

    @Test
    void bidirectionalRelationTest() {
        Team team = new Team("Backend");
        teamRepository.save(team);

        RelationMember member = new RelationMember("Lee");

        team.addMember(member);
        memberRepository.save(member);

        assertThat(member.getTeam()).isSameAs(team);
        assertThat(team.getMembers()).contains(member);
    }

    @Test
    void lazyLoadingTest() {
        Team team = new Team("Backend");
        teamRepository.save(team);

        RelationMember member = new RelationMember("Lee");
        team.addMember(member);
        memberRepository.save(member);

        entityManager.flush();
        entityManager.clear();

        System.out.println("===== MEMBER 조회 전 =====");

        RelationMember findMember =
                memberRepository.findById(member.getId())
                        .orElseThrow();

        System.out.println("===== MEMBER 조회 후 =====");

        Team findTeam = findMember.getTeam();
        System.out.println(findTeam.getClass());

        System.out.println("===== getTeam() 호출 후 =====");

        String teamName = findTeam.getName();

        System.out.println("===== getName() 호출 후 =====");

        assertThat(teamName).isEqualTo("Backend");
    }

    @Test
    void nPlusOneTest() {
        Team team1 = new Team("Backend");
        Team team2 = new Team("Frontend");
        Team team3 = new Team("Infra");

        teamRepository.save(team1);
        teamRepository.save(team2);
        teamRepository.save(team3);

        RelationMember member1 = new RelationMember("Lee");
        RelationMember member2 = new RelationMember("Kim");
        RelationMember member3 = new RelationMember("Park");

        team1.addMember(member1);
        team2.addMember(member2);
        team3.addMember(member3);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        entityManager.flush();
        entityManager.clear();

        System.out.println("===== MEMBER 전체 조회 =====");

        List<RelationMember> members = memberRepository.findAll();

        System.out.println("member count = " + members.size());

        System.out.println("===== TEAM 접근 시작 =====");

        for (RelationMember member : members) {
            System.out.println(member.getTeam().getName());
        }

        System.out.println("===== TEAM 접근 종료 =====");
    }

    @Test
    void fetchJoinTest() {
        Team team1 = new Team("Backend");
        Team team2 = new Team("Frontend");
        Team team3 = new Team("Infra");

        teamRepository.save(team1);
        teamRepository.save(team2);
        teamRepository.save(team3);

        RelationMember member1 = new RelationMember("Lee");
        RelationMember member2 = new RelationMember("Kim");
        RelationMember member3 = new RelationMember("Park");

        team1.addMember(member1);
        team2.addMember(member2);
        team3.addMember(member3);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        entityManager.flush();
        entityManager.clear();

        System.out.println("===== FETCH JOIN 조회 =====");

        List<RelationMember> members =
                memberRepository.findAllWithTeam();

        Team team = members.get(0).getTeam();

        System.out.println(team.getClass());

        System.out.println("===== TEAM 접근 시작 =====");

        for (RelationMember member : members) {
            System.out.println(member.getTeam().getName());
        }

        System.out.println("===== TEAM 접근 종료 =====");
    }

    @Test
    void batchFetchTest() {
        Team team1 = new Team("Backend");
        Team team2 = new Team("Frontend");
        Team team3 = new Team("Infra");

        teamRepository.save(team1);
        teamRepository.save(team2);
        teamRepository.save(team3);

        RelationMember member1 = new RelationMember("Lee");
        RelationMember member2 = new RelationMember("Kim");
        RelationMember member3 = new RelationMember("Park");

        team1.addMember(member1);
        team2.addMember(member2);
        team3.addMember(member3);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        entityManager.flush();
        entityManager.clear();

        System.out.println("===== MEMBER 조회 =====");

        List<RelationMember> members =
                memberRepository.findAll();

        System.out.println("===== TEAM 접근 =====");

        for (RelationMember member : members) {
            System.out.println(member.getTeam().getName());
        }
    }
}