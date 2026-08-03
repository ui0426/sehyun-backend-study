package com.sehyun.backend.java.oop;

public class OopExample {

    public static void main(String[] args) {
        ChangeOwnerApplication application = new ChangeOwnerApplication();

        System.out.println(application.getStatus());
        System.out.println(application.getMessage());

        application.completePreCheck();

        System.out.println(application.getStatus());
        System.out.println(application.getMessage());
    }
}
