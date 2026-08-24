package com.sehyun.backend.java.annotation;

public class OrderService {

    @LogExecutionTime
    public void order() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("주문 처리 완료");
    }
}