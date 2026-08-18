package com.sehyun.backend.java.lambda;

import java.util.Optional;

public class OptionalLambdaExample {

    public static void main(String[] args) {

        Optional<String> optional =
                Optional.empty();

        String value = optional.orElseThrow(
                () -> new IllegalArgumentException("값이 존재하지 않습니다.")
        );

        System.out.println(value);
    }
}