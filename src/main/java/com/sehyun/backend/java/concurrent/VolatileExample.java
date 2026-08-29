package com.sehyun.backend.java.concurrent;

public class VolatileExample {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) {
                // 작업
            }
            System.out.println("worker 종료");
        });

        worker.start();
        Thread.sleep(1000);
        running = false;
        worker.join();
    }
}