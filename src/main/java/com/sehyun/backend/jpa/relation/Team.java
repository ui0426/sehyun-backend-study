package com.sehyun.backend.jpa.relation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<RelationMember> members = new ArrayList<>();

    protected Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public void addMember(RelationMember member) {
        members.add(member);
        member.assignTeam(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RelationMember> getMembers() {
        return members;
    }
}