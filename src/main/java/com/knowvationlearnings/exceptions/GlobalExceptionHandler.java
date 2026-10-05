package com.knowvationlearnings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<MyErrorDetails> productNotFoundHandler(
            ProductNotFoundException pnf,
            WebRequest wr) {

        MyErrorDetails error = new MyErrorDetails(
                LocalDateTime.now(),
                pnf.getMessage(),
                wr.getDescription(false)
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }
}
