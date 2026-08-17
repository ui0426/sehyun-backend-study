package com.sehyun.backend.java.exception;

public class InvalidApplicationStatusException extends RuntimeException {

    public InvalidApplicationStatusException(String message) {
        super(message);
    }
}
