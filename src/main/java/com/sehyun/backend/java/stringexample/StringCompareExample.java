package com.sehyun.backend.java.stringexample;

public class StringCompareExample {

    public static void main(String[] args) {
        String a = "kim";
        String b = "kim";
        String c = new String("kim");

        System.out.println("a == b : " + (a == b));
        System.out.println("a == c : " + (a == c));
        System.out.println("a.equals(c) : " + a.equals(c));

        String status = null;

        System.out.println("\"READY\".equals(status) : " + "READY".equals(status));
        // System.out.println(status.equals("READY")); // NullPointerException 발생
    }
}
