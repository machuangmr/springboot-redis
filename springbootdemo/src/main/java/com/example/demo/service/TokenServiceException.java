package com.example.demo.service;

public class TokenServiceException extends RuntimeException {
    public TokenServiceException(String message) {
        super(message);
    }

    TokenServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
