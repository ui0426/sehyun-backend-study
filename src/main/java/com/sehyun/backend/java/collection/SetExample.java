package com.sehyun.backend.java.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetExample {
    public static void run() {
        Set<String> applicationIds = new HashSet<>();

        applicationIds.add("APP-001");
        applicationIds.add("APP-002");
        applicationIds.add("APP-001");

        System.out.println("=== Set 예제 ===");
        System.out.println(applicationIds);
        System.out.println("Set size: " + applicationIds.size());

        Set<ApplicationKey> keys = new HashSet<>();

        keys.add(new ApplicationKey("APP-001", "CUST-001"));
        keys.add(new ApplicationKey("APP-001", "CUST-001"));
        keys.add(new ApplicationKey("APP-002", "CUST-002"));

        System.out.println("ApplicationKey Set size: " + keys.size());
    }

    record ApplicationKey(String applicationId, String customerNumber) {

        @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }

                if (!(o instanceof ApplicationKey)) {
                    return false;
                }

                ApplicationKey that = (ApplicationKey) o;

                return Objects.equals(applicationId, that.applicationId)
                        && Objects.equals(customerNumber, that.customerNumber);
            }

    }
}
