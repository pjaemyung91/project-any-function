package com.example.myproject.vue.exception;

import com.example.myproject.common.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class CreateExperienceFailException extends AbstractException {

    public CreateExperienceFailException(String message) {
        super(message);
    }

    public CreateExperienceFailException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
