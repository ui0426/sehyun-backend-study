package com.sehyun.backend.java.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1L, "Kim", "DEV"),
                new User(2L, "Lee", "DEV"),
                new User(3L, "Park", "SALES")
        );

        Map<Long, String> userMap = users.stream()
                .collect(Collectors.toMap(
                        User::id,
                        User::name
                ));

        Map<String, User> lastUserByDepartment = users.stream()
                .collect(Collectors.toMap(
                        User::department,
                        user -> user,
                        (existing, replacement) -> replacement
                ));

        System.out.println(userMap);
        System.out.println(lastUserByDepartment);
    }

    record User(Long id, String name, String department) {
    }
}
