package com.example.string_service_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(MissingServletRequestParameterException.class)
    // public ResponseEntity<String>
    // handleMissingParams(MissingServletRequestParameterException ex) {
    // String name = ex.getParameterName();
    // return ResponseEntity.badRequest().body("Missing required query parameter: "
    // + name);
    // }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleMalformedInput() {
        return ResponseEntity.badRequest().body("Malformed or improperly encoded input.");
    }
}