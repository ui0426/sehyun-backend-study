package com.sehyun.backend.java.annotation;

import java.lang.reflect.Method;

public class AnnotationExample {

    public static void main(String[] args) throws Exception {
        ExternalApiService service = new ExternalApiService();

        Method[] methods = ExternalApiService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Retry.class)) {
                Retry retry = method.getAnnotation(Retry.class);

                System.out.println(
                        method.getName()
                                + " - retry count: "
                                + retry.count()
                );

                // 메소드 호출하기
                for(int i = 0; i < retry.count(); i++) method.invoke(service);

            }
        }
    }
}