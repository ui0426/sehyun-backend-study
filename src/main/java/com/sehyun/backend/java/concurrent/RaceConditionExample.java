package com.sehyun.backend.java.concurrent;

public class RaceConditionExample {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(RaceConditionExample::increase);
        Thread threadB = new Thread(RaceConditionExample::increase);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println("count = " + count);
    }

    private static void increase() {
        for (int i = 0; i < 100_000; i++) {
            count++;
        }
    }
}