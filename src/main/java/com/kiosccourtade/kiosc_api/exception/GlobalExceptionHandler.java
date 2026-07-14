package com.kiosccourtade.kiosc_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleGlobal(RuntimeException e) {
        if (e instanceof ApiException apiEx) {
            Map<String, String> error = new HashMap<>();
            error.put("error", apiEx.getMessage());
            return ResponseEntity.status(apiEx.getStatus()).body(error);
        }
        Map<String, String> error = new HashMap<>();
        error.put("ERROR", "Internal server error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }
}
