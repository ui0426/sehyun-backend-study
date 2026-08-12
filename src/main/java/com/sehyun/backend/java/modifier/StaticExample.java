package com.sehyun.backend.java.modifier;

public class StaticExample {

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();

        System.out.println("counter1 count = " + counter1.getCount());
        System.out.println("counter2 count = " + counter2.getCount());
        System.out.println("counter3 count = " + counter3.getCount());

        System.out.println("total count = " + Counter.getTotalCount());
    }

    static class Counter {

        private static int totalCount = 0;

        private int count = 0;

        public Counter() {
            totalCount++;
            count++;
        }

        public static int getTotalCount() {
            return totalCount;
        }

        public int getCount() {
            return count;
        }
    }
}