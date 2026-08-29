package com.sehyun.backend.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executor.submit(() -> System.out.println(
                    Thread.currentThread().getName() + " - task: " + taskNumber
            ));
        }

        executor.shutdown();
    }
}