package com.oms.example.orderitemservice.exception;

import com.oms.example.orderitemservice.model.OrderItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {
    @ExceptionHandler(value= OrderItemNotFoundException.class)
    public ResponseEntity<Object> exception(OrderItemNotFoundException exception){
        return new ResponseEntity<>("OrderItem Not Found", HttpStatus.NOT_FOUND);
    }
}
