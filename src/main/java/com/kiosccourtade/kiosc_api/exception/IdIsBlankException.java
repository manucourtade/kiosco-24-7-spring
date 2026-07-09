package com.kiosccourtade.kiosc_api.exception;

import org.springframework.http.HttpStatus;

public class IdIsBlankException extends RuntimeException implements ApiException {
    public IdIsBlankException() {
        super("You must have post ID");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }


}
