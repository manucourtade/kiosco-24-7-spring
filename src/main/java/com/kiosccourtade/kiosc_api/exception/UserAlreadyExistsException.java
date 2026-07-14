package com.kiosccourtade.kiosc_api.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends RuntimeException implements ApiException{
    public UserAlreadyExistsException() {

        super("Username already exists");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
