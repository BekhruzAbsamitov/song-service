package com.epam.songservice.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException{

    private HttpStatus status;

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
