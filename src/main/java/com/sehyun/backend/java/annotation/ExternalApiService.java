package com.sehyun.backend.java.annotation;

public class ExternalApiService {

    @Retry(count = 5)
    public void callApi() {
        System.out.println("외부 API 호출");
    }

    @Retry
    public void callApiWithDefaultRetry() {
        System.out.println("기본 재시도 횟수를 사용하는 API 호출");
    }

    public void normalMethod() {
        System.out.println("Annotation이 없는 일반 메서드");
    }
}