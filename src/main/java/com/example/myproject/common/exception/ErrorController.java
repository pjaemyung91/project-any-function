package com.example.myproject.common.exception;

import com.example.myproject.vue.exception.CreateExperienceFailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorController {

    @ResponseBody
    @ExceptionHandler(AbstractException.class)
    public ResponseEntity errorResponse(AbstractException e) {
        String message = e.getMessage();
        HttpStatus status = e.getStatusCode();

        ErrorResponse errorResponse = ErrorResponse.builder()
            .message(message)
            .statusCode(String.valueOf(status.value()))
            .build();

        return ResponseEntity.status(status).body(errorResponse);
    }

    @ResponseBody
    @ExceptionHandler(CreateExperienceFailException.class)
    public ResponseEntity errorResponse(CreateExperienceFailException e) {
        String message = e.getMessage();
        HttpStatus status = e.getStatusCode();

        ErrorResponse errorResponse = ErrorResponse.builder()
            .message(message)
            .statusCode(String.valueOf(status.value()))
            .build();

        return ResponseEntity.status(status).body(errorResponse);
    }
}
