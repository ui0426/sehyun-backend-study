package com.sehyun.backend.java.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChangeOwnerApplicationRepository {

    private final Map<String, ChangeOwnerApplication> store = new HashMap<>();

    public ChangeOwnerApplicationRepository() {
        store.put("APP-001", new ChangeOwnerApplication("APP-001", "REQUESTED"));
    }

    public Optional<ChangeOwnerApplication> findById(String applicationId) {
        return Optional.ofNullable(store.get(applicationId));
    }
}
