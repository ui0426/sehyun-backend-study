package com.sehyun.backend.java.interfaceexample;

public class MockPreCheckClient implements PreCheckClient {

    @Override
    public PreCheckResult preCheck(String applicationId) {
        System.out.println("[Mock] 테스트용 사전체크 응답 생성: " + applicationId);

        return new PreCheckResult(true, "Mock 사전체크 성공");
    }
}
