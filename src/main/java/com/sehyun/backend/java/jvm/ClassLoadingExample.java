package com.sehyun.backend.java.jvm;

public class ClassLoadingExample {

    static int count = 10;

    static {
        count = 20;
        System.out.println("Class initialization");
    }

    public static void main(String[] args) {
        System.out.println("count = " + count);
    }
}