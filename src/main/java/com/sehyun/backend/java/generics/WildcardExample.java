package com.sehyun.backend.java.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

//    extends → 읽기
//    super   → 쓰기

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3);

        printNumbers(integers);

        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);

        System.out.println(numbers);
    }

    public static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }

    public static void addIntegers(List<? super Integer> numbers) {
        numbers.add(10);
        numbers.add(20);
    }
}