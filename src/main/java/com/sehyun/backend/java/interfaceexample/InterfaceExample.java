package com.sehyun.backend.java.interfaceexample;

public class InterfaceExample {

    public static void main(String[] args) {
        String applicationId = "CHANGE-OWNER-001";

        PreCheckClient ktClient = new KtPreCheckClient();
        PreCheckService ktService = new PreCheckService(ktClient);
        ktService.execute(applicationId);

        System.out.println();

        PreCheckClient mockClient = new MockPreCheckClient();
        PreCheckService mockService = new PreCheckService(mockClient);
        mockService.execute(applicationId);
    }
}
