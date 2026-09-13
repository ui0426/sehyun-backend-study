package com.sehyun.backend.jpa.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelationMemberRepository
        extends JpaRepository<RelationMember, Long> {

    @Query("""
    select m
    from RelationMember m
    join fetch m.team
    """)
    List<RelationMember> findAllWithTeam();

}