package com.sehyun.backend.java.oop.encapsulation;

public class EncapsulationExample {

    public static void main(String[] args) {
//        ChangeOwnerApplicationV1 application = new ChangeOwnerApplicationV1();
//
//        application.status = "PRE_CHECK_SUCCESS";
//        application.message = "사전체크 실패";
//
//        System.out.println(application.status);
//        System.out.println(application.message);

//        ChangeOwnerApplicationV2 application = new ChangeOwnerApplicationV2();
//
//        application.setStatus("PRE_CHECK_SUCCESS");
//        application.setMessage("사전체크 실패");
//
//        System.out.println(application.getStatus());
//        System.out.println(application.getMessage());

        ChangeOwnerApplicationV3 application = new ChangeOwnerApplicationV3();

//        application.completePreCheck();
//
//        System.out.println(application.getStatus());
//        System.out.println(application.getMessage());

        application.completePreCheck();
        application.failPreCheck();

        System.out.println(application.getStatus());
        System.out.println(application.getMessage());

    }
}
