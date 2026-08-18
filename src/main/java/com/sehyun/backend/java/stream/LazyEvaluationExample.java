package com.sehyun.backend.java.stream;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationExample {

    public static void main(String[] args) {

        List<Integer> numbers =
                List.of(1, 2, 3, 4, 5);

        Stream<Integer> stream = numbers.stream()
                .filter(number -> {
                    System.out.println("filter: " + number);
                    return number % 2 == 0;
                })
                .map(number -> {
                    System.out.println("map: " + number);
                    return number * 10;
                });

        System.out.println("중간 연산 구성 완료");

        List<Integer> result = stream.toList();

        System.out.println("result = " + result);
    }
}
