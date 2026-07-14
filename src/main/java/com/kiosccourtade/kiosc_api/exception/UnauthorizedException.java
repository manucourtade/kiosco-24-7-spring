package com.kiosccourtade.kiosc_api.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends RuntimeException implements ApiException {
    public UnauthorizedException() {

        super("The user is not AUTHORIZED, please log in at /auth/login");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
