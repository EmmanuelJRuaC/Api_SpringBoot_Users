package com.api.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Bad Request
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> badUser() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error", "¡Usuario no creado!"));
    }
}
