package com.sehyun.backend.java.interfaceexample;

public class KtPreCheckClient implements PreCheckClient {

    @Override
    public PreCheckResult preCheck(String applicationId) {
        System.out.println("[KT 연동] 명의변경 사전체크 요청: " + applicationId);

        return new PreCheckResult(true, "KT 사전체크 성공");
    }
}
