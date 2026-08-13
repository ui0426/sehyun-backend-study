package com.sehyun.backend.java.collection;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void run() {
        Map<String, String> statusMap = new HashMap<>();

        statusMap.put("APP-001", "REQUESTED");
        statusMap.put("APP-002", "PRE_CHECK_COMPLETED");
        statusMap.put("APP-001", "COMPLETED");

        System.out.println("=== Map 예제 ===");
        System.out.println("APP-001 상태: " + statusMap.get("APP-001"));
        System.out.println("APP-002 상태: " + statusMap.get("APP-002"));
        System.out.println("Map size: " + statusMap.size());
    }
}
