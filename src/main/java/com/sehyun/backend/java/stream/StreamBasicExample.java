package com.sehyun.backend.java.stream;

import java.util.List;

public class StreamBasicExample {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Kim", 25, true),
                new User("Lee", 35, false),
                new User("Park", 32, true),
                new User("Choi", 40, true),
                new User("Jung", 28, true)
        );

        List<String> names = users.stream()
                .filter(User::isActive)
                .filter(user -> user.getAge() >= 30)
                .map(User::getName)
                .limit(3)
                .toList();

        System.out.println(names);
    }

    static class User {

        private final String name;
        private final int age;
        private final boolean active;

        public User(String name, int age, boolean active) {
            this.name = name;
            this.age = age;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isActive() {
            return active;
        }
    }
}