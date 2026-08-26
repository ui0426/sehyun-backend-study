package com.sehyun.backend.java.jvm;

public class MemoryExample {

    public static void main(String[] args) {
        int localAge = 30;

        User user = new User(localAge);
        Address address = new Address("Seoul");

        user.setAddress(address);

        User sameUser = user;

        System.out.println(user == sameUser);
        System.out.println(User.getCount());
    }
}