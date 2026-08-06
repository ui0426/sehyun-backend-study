package com.sehyun.backend.java.interfaceexample;

public class PreCheckResult {

    private final boolean success;
    private final String message;

    public PreCheckResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
