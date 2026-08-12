package com.sehyun.backend.java.modifier;

public class FinalExample {

    public static void main(String[] args) {
        final int number = 10;
        // number = 20; // 컴파일 에러

        final Member member = new Member("kim");
        // member = new Member("lee"); // 컴파일 에러

        member.changeName("lee"); // 가능
        System.out.println(member.getName());
    }

    static class Member {

        private String name;

        public Member(String name) {
            this.name = name;
        }

        public void changeName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}