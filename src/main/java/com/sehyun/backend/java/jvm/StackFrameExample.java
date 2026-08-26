package com.sehyun.backend.java.jvm;

public class StackFrameExample {

    public static void main(String[] args) {
        int result = add(10, 20);
        System.out.println(result);
    }

    private static int add(int a, int b) {
        int result = a + b;
        return result;
    }
}