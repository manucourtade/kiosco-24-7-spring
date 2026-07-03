package com.kiosccourtade.kiosc_api.exception;

public class CategoryHasProductsException extends RuntimeException{
    public CategoryHasProductsException(Long id) {
        super("Category with id " + id + " has products associated and cannot be deleted");
    }
}
