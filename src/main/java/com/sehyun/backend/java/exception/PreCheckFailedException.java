package com.sehyun.backend.java.exception;

public class PreCheckFailedException extends RuntimeException {

    public PreCheckFailedException(String message) {
        super(message);
    }
}
