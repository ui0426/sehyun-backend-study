package com.sehyun.backend.java.lambda;

import java.util.List;

public class MethodReferenceExample {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("sehyun", 32),
                new User("kim", 25),
                new User("lee", 40)
        );

        users.stream()
                .map(User::getName)
                .forEach(System.out::println);
    }

    static class User {

        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}