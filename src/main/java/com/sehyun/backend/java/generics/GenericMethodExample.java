package com.sehyun.backend.java.generics;

import java.util.List;

public class GenericMethodExample {

    public static void main(String[] args) {

        String name = getFirst(List.of("Kim", "Lee"));
        Integer number = getFirst(List.of(10, 20));

        System.out.println(name);
        System.out.println(number);
    }

    public static <T> T getFirst(List<T> list) {
        return list.get(0);
    }
}