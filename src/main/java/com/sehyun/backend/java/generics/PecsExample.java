package com.sehyun.backend.java.generics;

import java.util.ArrayList;
import java.util.List;

public class PecsExample {

    public static void main(String[] args) {

        List<Integer> source = List.of(1, 2, 3);
        List<Number> target = new ArrayList<>();

        copy(source, target);

        System.out.println(target);
    }

    public static void copy(
            List<? extends Number> source,
            List<? super Number> target
    ) {
        for (Number number : source) {
            target.add(number);
        }
    }
}