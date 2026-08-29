package com.sehyun.backend.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static final AtomicInteger COUNT = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(AtomicExample::increase);
        Thread threadB = new Thread(AtomicExample::increase);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println("count = " + COUNT.get());
    }

    private static void increase() {
        for (int i = 0; i < 100_000; i++) {
            COUNT.incrementAndGet();
        }
    }
}