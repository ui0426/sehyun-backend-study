package com.sehyun.backend.java.annotation;

import java.lang.reflect.Method;

public class LogExecutionTimeExample {

    public static void main(String[] args) throws Exception {
        OrderService service = new OrderService();

        Method method = OrderService.class.getDeclaredMethod("order");

        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long start = System.currentTimeMillis();

            method.invoke(service);

            long end = System.currentTimeMillis();

            System.out.println("실행 시간: " + (end - start) + "ms");
        }
    }
}