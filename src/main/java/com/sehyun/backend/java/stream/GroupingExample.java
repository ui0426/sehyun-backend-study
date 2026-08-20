package com.sehyun.backend.java.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Kim", "DEV", true),
                new User("Lee", "DEV", false),
                new User("Park", "SALES", true),
                new User("Choi", "SALES", true)
        );

        Map<String, List<User>> usersByDepartment = users.stream()
                .collect(Collectors.groupingBy(User::department));

        Map<Boolean, List<User>> usersByActive = users.stream()
                .collect(Collectors.partitioningBy(User::active));

        System.out.println(usersByDepartment);
        System.out.println(usersByActive);
    }

    record User(
            String name,
            String department,
            boolean active
    ) {
    }
}
