package com.sehyun.backend.java.oop;

public class ChangeOwnerApplication {

    private String status;
    private String message;

    public ChangeOwnerApplication() {
        this.status = "READY";
        this.message = "명의변경 신청 준비";
    }

    public void completePreCheck() {
        this.status = "PRE_CHECK_SUCCESS";
        this.message = "사전체크가 성공했습니다.";
    }

    public void failPreCheck() {
        this.status = "PRE_CHECK_FAIL";
        this.message = "사전체크가 실패했습니다.";
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
