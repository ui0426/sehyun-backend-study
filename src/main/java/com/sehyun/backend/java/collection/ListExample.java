package com.sehyun.backend.java.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void run() {
        List<String> applicationIds = new ArrayList<>();

        applicationIds.add("APP-001");
        applicationIds.add("APP-002");
        applicationIds.add("APP-001");

        System.out.println("=== List 예제 ===");
        System.out.println(applicationIds);
        System.out.println("첫 번째 신청서 ID: " + applicationIds.get(0));
        System.out.println("List size: " + applicationIds.size());
    }
}
