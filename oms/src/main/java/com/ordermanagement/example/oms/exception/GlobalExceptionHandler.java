package com.ordermanagement.example.oms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {
    @ExceptionHandler(value= OrderNotFoundException.class)
    public ResponseEntity<Object> exception(OrderNotFoundException exception){
        return new ResponseEntity<>("Order Not Found : "+exception.getCause(), HttpStatus.NOT_FOUND);
    }
}
