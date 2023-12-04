package com.app.test.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity argumentNotValid(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getFieldErrors()
                        .stream()
                        .map(ErrorMessage::new)
                        .collect(Collectors.toList()));
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity arithmeticError(ArithmeticException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorMessage(ex.getMessage(), ex.getCause()));
    }

}
