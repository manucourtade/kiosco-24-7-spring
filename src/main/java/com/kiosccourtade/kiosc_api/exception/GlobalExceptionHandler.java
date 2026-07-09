package com.kiosccourtade.kiosc_api.exception;

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
            error.put(e.getClass().getSimpleName(), apiEx.getMessage());
            return ResponseEntity.status(apiEx.getStatus()).body(error);
        }

        e.printStackTrace(); // log básico en consola, para vos poder debuggear
        Map<String, String> error = new HashMap<>();
        error.put("ERROR", "Internal server error");
        return ResponseEntity.status(500).body(error);
    }
}
