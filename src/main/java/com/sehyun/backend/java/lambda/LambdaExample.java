package com.sehyun.backend.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {

    public static void main(String[] args) {

        // Function<T, R>
        // 입력값을 받아 다른 값을 반환
        Function<String, Integer> lengthFunction =
                text -> text.length();

        System.out.println(lengthFunction.apply("hello")); // 5


        // Predicate<T>
        // 입력값을 받아 boolean 반환
        Predicate<Integer> isAdult =
                age -> age >= 20;

        System.out.println(isAdult.test(25)); // true


        // Consumer<T>
        // 입력값을 받아 사용하고 반환값 없음
        Consumer<String> printer =
                message -> System.out.println(message);

        printer.accept("Hello Lambda");


        // Supplier<T>
        // 입력 없이 값을 반환
        Supplier<String> messageSupplier =
                () -> "Hello Supplier";

        System.out.println(messageSupplier.get());
    }
}