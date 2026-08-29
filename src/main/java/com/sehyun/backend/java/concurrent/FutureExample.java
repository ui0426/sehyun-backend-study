package com.sehyun.backend.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(() -> 10 + 20);
        Integer result = future.get();

        System.out.println("result = " + result);
        executor.shutdown();
    }
}