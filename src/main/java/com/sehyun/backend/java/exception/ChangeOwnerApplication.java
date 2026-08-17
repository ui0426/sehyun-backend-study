package com.sehyun.backend.java.exception;

public class ChangeOwnerApplication {

    private String status;

    public ChangeOwnerApplication(String status) {
        this.status = status;
    }

    public void completePreCheck(boolean preCheckSuccess) {
        if (!"REQUESTED".equals(status)) {
            throw new InvalidApplicationStatusException(
                    "사전체크를 완료할 수 없는 상태입니다. currentStatus=" + status
            );
        }

        if (!preCheckSuccess) {
            throw new PreCheckFailedException("명의변경 사전체크에 실패했습니다.");
        }

        this.status = "PRE_CHECK_COMPLETED";
    }

    public String getStatus() {
        return status;
    }
}
