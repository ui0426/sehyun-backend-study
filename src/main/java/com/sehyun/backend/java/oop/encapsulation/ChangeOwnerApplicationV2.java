package com.sehyun.backend.java.oop.encapsulation;

public class ChangeOwnerApplicationV2 {
    private String status;
    private String message;

    public ChangeOwnerApplicationV2() {
        this.status = "READY";
        this.message = "명의변경 신청 준비";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
