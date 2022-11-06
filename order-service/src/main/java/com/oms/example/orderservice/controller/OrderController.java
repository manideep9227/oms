package com.oms.example.orderservice.controller;

import com.oms.example.orderservice.exception.SystemException;
import com.oms.example.orderservice.model.FoodItem;
import com.oms.example.orderservice.model.OrderDetails;
import com.oms.example.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * RestController for creating OrderItems and Retrieving OrderItems based on orderId
 */
@RestController
@RequestMapping("/oms")
public class OrderController {

    Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderItemService;

    /**
     * API to retrieve OrderItems based on @orderId
     */
    @GetMapping("/getOrderItemInfo/{orderId}")
    public @ResponseBody ResponseEntity<Object> getOrderItems(@PathVariable("orderId") String orderId){
        try{
            LOGGER.info("Getting OrderItems");
            return new ResponseEntity<>(orderItemService.getOrderItem(orderId), HttpStatus.OK);
        }catch (SystemException e){
            LOGGER.error("Exception occurred: {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
    /**
     * API to create new OrderItems
     */
    @PostMapping("/createNewOrderItem")
    public @ResponseBody ResponseEntity<Object> createOrderItem(@RequestBody OrderDetails orderItem){
        try{
            return new ResponseEntity<>(orderItemService.createOrderItem(orderItem),HttpStatus.OK);
        }catch (SystemException e){
            LOGGER.error("Exception occurred: {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
    @GetMapping("/getAllOrders")
    public @ResponseBody ResponseEntity<Object> getAllOrders(){
        try{
            return new ResponseEntity<>(orderItemService.getOrders(),HttpStatus.OK);
        }
        catch (SystemException e){
            LOGGER.error("Exception occurred: {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
}
