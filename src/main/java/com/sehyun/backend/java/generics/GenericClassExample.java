package com.sehyun.backend.java.generics;

public class GenericClassExample {

    public static void main(String[] args) {

        Box<String> stringBox = new Box<>();
        stringBox.set("hello");

        Box<Integer> integerBox = new Box<>();
        integerBox.set(100);

        System.out.println(stringBox.get());
        System.out.println(integerBox.get());
    }

    static class Box<T> {

        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }
}
