package com.sehyun.backend.java.gc;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {

    private static final List<User> USERS = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 100_000; i++) {
            USERS.add(new User(i));
        }

        System.out.println("users size = " + USERS.size());
    }

    static class User {

        private final int id;

        User(int id) {
            this.id = id;
        }
    }
}