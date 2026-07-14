package com.kiosccourtade.kiosc_api.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException implements ApiException {
    public NotFoundException(String entity, Long id) {
        super(entity + " with id " + id + " not found");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
