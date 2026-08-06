package com.sehyun.backend.java.interfaceexample;

public class PreCheckService {

    private final PreCheckClient preCheckClient;

    public PreCheckService(PreCheckClient preCheckClient) {
        this.preCheckClient = preCheckClient;
    }

    public void execute(String applicationId) {
        PreCheckResult result = preCheckClient.preCheck(applicationId);

        if (result.isSuccess()) {
            System.out.println("사전체크 성공 처리: " + result.getMessage());
            return;
        }

        System.out.println("사전체크 실패 처리: " + result.getMessage());
    }
}
