package com.sehyun.backend.java.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(value -> value * 2);

        future.thenAccept(result -> System.out.println("result = " + result)).join();
    }
}