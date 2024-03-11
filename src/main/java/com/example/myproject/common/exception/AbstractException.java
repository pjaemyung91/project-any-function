package com.example.myproject.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AbstractException extends RuntimeException{

    public AbstractException(String message) {
        super(message);
    }

    public AbstractException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatusCode();
}
