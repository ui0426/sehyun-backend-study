package com.sehyun.backend.java.polymorphism;

public class PreCheckService {
    private final PreCheckClient preCheckClient;

    public PreCheckService(PreCheckClient preCheckClient) {
        this.preCheckClient = preCheckClient;
    }

    public void executePreCheck() {
        preCheckClient.preCheck();
    }
}
