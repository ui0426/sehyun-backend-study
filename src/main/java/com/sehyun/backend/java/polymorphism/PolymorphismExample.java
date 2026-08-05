package com.sehyun.backend.java.polymorphism;

public class PolymorphismExample {

    public static void main(String[] args) {
        PreCheckClient ktClient = new KtPreCheckClient();
        PreCheckService ktService = new PreCheckService(ktClient);
        ktService.executePreCheck();

        PreCheckClient mockClient = new MockPreCheckClient();
        PreCheckService mockService = new PreCheckService(mockClient);
        mockService.executePreCheck();
    }
}
