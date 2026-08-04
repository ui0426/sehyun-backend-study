package com.sehyun.backend.java.oop.encapsulation;

public class ChangeOwnerApplicationV3 {

    private static final String READY = "READY";
    private static final String PRE_CHECK_SUCCESS = "PRE_CHECK_SUCCESS";
    private static final String PRE_CHECK_FAIL = "PRE_CHECK_FAIL";

    private String status;
    private String message;

    public ChangeOwnerApplicationV3() {
        this.status = READY;
        this.message = "명의변경 신청 준비";
    }

    public void completePreCheck() {
        validateReady();

        this.status = PRE_CHECK_SUCCESS;
        this.message = "사전체크 성공";
    }

    public void failPreCheck() {
        validateReady();

        this.status = PRE_CHECK_FAIL;
        this.message = "사전체크 실패";
    }

    private void validateReady() {
        if (!this.status.equals(READY)) {
            throw new IllegalStateException("READY 상태에서만 사전체크 결과 처리가 가능합니다.");
        }
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
