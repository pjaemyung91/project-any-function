package com.example.myproject.common.exception;

import lombok.Builder;

public class ErrorResponse {

    private String message;
    private String statusCode;

    @Builder
    public ErrorResponse(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
