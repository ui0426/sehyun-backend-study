package com.sehyun.backend.java.generics;

public class BoundedTypeExample {

    public static void main(String[] args) {

        System.out.println(doubleValue(10));
        System.out.println(doubleValue(10L));
        System.out.println(doubleValue(3.14));
    }

    public static <T extends Number> double doubleValue(T value) {
        return value.doubleValue();
    }
}