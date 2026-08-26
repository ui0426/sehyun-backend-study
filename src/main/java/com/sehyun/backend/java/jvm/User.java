package com.sehyun.backend.java.jvm;

public class User {

    private static int count = 0;

    private int age;
    private Address address;

    public User(int age) {
        this.age = age;
        count++;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static int getCount() {
        return count;
    }
}