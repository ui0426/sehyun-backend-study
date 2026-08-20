package com.sehyun.backend.java.stream;

import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {

        List<Team> teams = List.of(
                new Team("Backend", List.of(
                        new Member("Kim"),
                        new Member("Lee")
                )),
                new Team("Frontend", List.of(
                        new Member("Park"),
                        new Member("Choi")
                ))
        );

        List<String> memberNames = teams.stream()
                .flatMap(team -> team.members().stream())
                .map(Member::name)
                .toList();

        System.out.println(memberNames);
    }

    record Team(String name, List<Member> members) {
    }

    record Member(String name) {
    }
}
