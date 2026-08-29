package com.sehyun.backend.java.gc;

public class ReachabilityExample {

    public static void main(String[] args) {
        User user = new User("Sehyun");

        System.out.println(user);

        user = null;

        // User 객체는 더 이상 해당 지역변수를 통해
        // GC Root에서 도달할 수 없는 상태가 된다.
        //
        // 단, 즉시 GC된다는 의미는 아니다.
    }

    static class User {

        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{name='%s'}".formatted(name);
        }
    }
}