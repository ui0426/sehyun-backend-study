package com.sehyun.backend.java.stream;

import java.util.List;

public class ShortCircuitExample {

    public static void main(String[] args) {

        List<Integer> numbers =
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream()
                .filter(number -> {
                    System.out.println("filter: " + number);
                    return number % 2 == 0;
                })
                .map(number -> {
                    System.out.println("map: " + number);
                    return number * 10;
                })
                .limit(3)
                .toList();

        System.out.println("result = " + result);
    }
}