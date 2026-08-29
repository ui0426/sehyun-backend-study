package com.sehyun.backend.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final Lock LOCK = new ReentrantLock();
    private static int count = 0;

    public static void increase() {
        LOCK.lock();
        try {
            count++;
        } finally {
            LOCK.unlock();
        }
    }
}