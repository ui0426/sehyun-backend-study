package com.sehyun.backend.java.concurrent;

public class SynchronizedExample {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(SynchronizedExample::increase);
        Thread threadB = new Thread(SynchronizedExample::increase);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println("count = " + count);
    }

    private static synchronized void increase() {
        for (int i = 0; i < 100_000; i++) {
            count++;
        }
    }
}