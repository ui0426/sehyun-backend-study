package com.sehyun.backend.java.stringexample;

public class StringBuilderExample {
    public static void main(String[] args) {
        String result = "";

        for (int i = 1; i <= 5; i++) {
            result += i + " ";
        }

        System.out.println("String result = " + result);

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            builder.append(i).append(" ");
        }

        System.out.println("StringBuilder result = " + builder);
    }
}
