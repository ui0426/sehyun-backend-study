package com.sehyun.backend.java.objectmethod;

import java.util.HashSet;
import java.util.Set;

public class ObjectMethodExample {
    public static void main(String[] args) {
        compareMemberV1();
        System.out.println();
        compareMemberV2();
    }

    private static void compareMemberV1() {
        MemberV1 member1 = new MemberV1(1L, "kim");
        MemberV1 member2 = new MemberV1(1L, "kim");

        System.out.println("=== MemberV1: equals/hashCode 재정의 안 함 ===");
        System.out.println("member1 == member2 : " + (member1 == member2));
        System.out.println("member1.equals(member2) : " + member1.equals(member2));

        Set<MemberV1> members = new HashSet<>();
        members.add(member1);
        members.add(member2);

        System.out.println("HashSet size : " + members.size());
    }

    private static void compareMemberV2() {
        MemberV2 member1 = new MemberV2(1L, "kim");
        MemberV2 member2 = new MemberV2(1L, "kim");

        System.out.println("=== MemberV2: equals/hashCode 재정의함 ===");
        System.out.println("member1 == member2 : " + (member1 == member2));
        System.out.println("member1.equals(member2) : " + member1.equals(member2));

        Set<MemberV2> members = new HashSet<>();
        members.add(member1);
        members.add(member2);

        System.out.println("HashSet size : " + members.size());
    }
}
