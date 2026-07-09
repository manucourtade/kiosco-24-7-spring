package com.kiosccourtade.kiosc_api.exception;

import org.springframework.http.HttpStatus;


public interface ApiException {
    HttpStatus getStatus();
    String getMessage();
}
