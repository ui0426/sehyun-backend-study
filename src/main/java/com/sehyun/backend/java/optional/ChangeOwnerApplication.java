package com.sehyun.backend.java.optional;

public class ChangeOwnerApplication {

    private final String applicationId;
    private String status;

    public ChangeOwnerApplication(String applicationId, String status) {
        this.applicationId = applicationId;
        this.status = status;
    }

    public void completePreCheck() {
        this.status = "PRE_CHECK_COMPLETED";
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getStatus() {
        return status;
    }
}