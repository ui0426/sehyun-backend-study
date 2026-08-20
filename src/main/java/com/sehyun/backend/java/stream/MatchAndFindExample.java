package com.sehyun.backend.java.stream;

import java.util.List;

public class MatchAndFindExample {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Kim", 32, true),
                new User("Lee", 25, false),
                new User("Park", 40, true)
        );

        boolean existsAdult = users.stream()
                .anyMatch(user -> user.age() >= 30);

        boolean allActive = users.stream()
                .allMatch(User::active);

        User firstActive = users.stream()
                .filter(User::active)
                .findFirst()
                .orElseThrow();

        System.out.println("existsAdult = " + existsAdult);
        System.out.println("allActive = " + allActive);
        System.out.println("firstActive = " + firstActive);
    }

    record User(String name, int age, boolean active) {
    }
}
