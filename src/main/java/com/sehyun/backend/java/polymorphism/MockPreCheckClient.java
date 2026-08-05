package com.sehyun.backend.java.polymorphism;

public class MockPreCheckClient implements PreCheckClient {
    @Override
    public void preCheck() {
        System.out.println("테스트용 사전체크 성공 응답을 반환합니다.");
    }
}
