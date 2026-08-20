package com.sehyun.backend.java.stream;

import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        int multiply = numbers.stream()
                .reduce(1, (acc, number) -> acc * number);

        System.out.println("sum = " + sum);
        System.out.println("multiply = " + multiply);
    }
}
