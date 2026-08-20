package com.sehyun.backend.java.stream;

import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {

        List<Integer> numbers =
                List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> result = numbers.parallelStream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 10)
                .toList();

        System.out.println(result);
    }
}
