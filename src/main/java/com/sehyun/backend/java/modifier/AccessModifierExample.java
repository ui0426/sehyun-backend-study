package com.sehyun.backend.java.modifier;

public class AccessModifierExample {

    public static void main(String[] args) {
        ChangeOwnerApplication application =
                new ChangeOwnerApplication("REQUESTED");

        application.completePreCheck();

        System.out.println(application.getStatus());

        // application.status = "UNKNOWN"; // private이라 접근 불가
    }

    static class ChangeOwnerApplication {

        private String status;

        public ChangeOwnerApplication(String status) {
            this.status = status;
        }

        public void completePreCheck() {
            if (!"REQUESTED".equals(status)) {
                throw new IllegalStateException("사전체크를 완료할 수 없는 상태입니다.");
            }

            this.status = "PRE_CHECK_COMPLETED";
        }

        public String getStatus() {
            return status;
        }
    }
}