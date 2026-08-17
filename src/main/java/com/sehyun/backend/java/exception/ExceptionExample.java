package com.sehyun.backend.java.exception;

public class ExceptionExample {

    public static void main(String[] args) {
        successCase();

        System.out.println();

        preCheckFailedCase();

        System.out.println();

        invalidStatusCase();
    }

    private static void successCase() {
        ChangeOwnerApplication application =
                new ChangeOwnerApplication("REQUESTED");

        application.completePreCheck(true);

        System.out.println("성공 케이스 status = " + application.getStatus());
    }

    private static void preCheckFailedCase() {
        ChangeOwnerApplication application =
                new ChangeOwnerApplication("REQUESTED");

        try {
            application.completePreCheck(false);
        } catch (PreCheckFailedException e) {
            System.out.println("사전체크 실패 처리: " + e.getMessage());
        }
    }

    private static void invalidStatusCase() {
        ChangeOwnerApplication application =
                new ChangeOwnerApplication("COMPLETED");

        try {
            application.completePreCheck(true);
        } catch (InvalidApplicationStatusException e) {
            System.out.println("상태 오류 처리: " + e.getMessage());
        }
    }
}
