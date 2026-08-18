package com.sehyun.backend.java.lambda;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        Calculator add =
                (a, b) -> a + b;

        Calculator multiply =
                (a, b) -> a * b;

        System.out.println(add.calculate(10, 20));       // 30
        System.out.println(multiply.calculate(10, 20));  // 200
    }

    @FunctionalInterface
    interface Calculator {

        int calculate(int a, int b);

        default void printDescription() {
            System.out.println("Calculator");
        }

        static void hello() {
            System.out.println("Hello");
        }
    }
}