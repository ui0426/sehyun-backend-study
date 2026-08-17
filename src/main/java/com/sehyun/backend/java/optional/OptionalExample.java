package com.sehyun.backend.java.optional;

public class OptionalExample {

    public static void main(String[] args) {
        ChangeOwnerApplicationRepository repository =
                new ChangeOwnerApplicationRepository();

        successCase(repository);

        System.out.println();

        notFoundCase(repository);
    }

    private static void successCase(ChangeOwnerApplicationRepository repository) {
        ChangeOwnerApplication application = repository.findById("APP-001")
                .orElseThrow(() -> new ApplicationNotFoundException("신청서를 찾을 수 없습니다."));

        application.completePreCheck();

        System.out.println("성공 케이스");
        System.out.println("applicationId = " + application.getApplicationId());
        System.out.println("status = " + application.getStatus());
    }

    private static void notFoundCase(ChangeOwnerApplicationRepository repository) {
        try {
            ChangeOwnerApplication application = repository.findById("APP-999")
                    .orElseThrow(() -> new ApplicationNotFoundException("신청서를 찾을 수 없습니다. applicationId=APP-999"));

            application.completePreCheck();
        } catch (ApplicationNotFoundException e) {
            System.out.println("실패 케이스");
            System.out.println(e.getMessage());
        }
    }
}