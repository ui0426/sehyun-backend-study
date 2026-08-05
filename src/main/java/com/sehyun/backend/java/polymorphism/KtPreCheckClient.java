package com.sehyun.backend.java.polymorphism;

public class KtPreCheckClient implements PreCheckClient{
    @Override
    public void preCheck() {
        System.out.println("KT 외부 시스템으로 명의변경 사전체크를 요청합니다.");
    }
}
