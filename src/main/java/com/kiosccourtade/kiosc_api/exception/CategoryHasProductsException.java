package com.kiosccourtade.kiosc_api.exception;

import org.springframework.http.HttpStatus;

public class CategoryHasProductsException extends RuntimeException implements ApiException{
    public CategoryHasProductsException(Long id) {
        super("Category with id " + id + " has products associated and cannot be deleted");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
