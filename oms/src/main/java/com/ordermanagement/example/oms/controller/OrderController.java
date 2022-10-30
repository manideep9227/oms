package com.ordermanagement.example.oms.controller;


import org.springframework.web.bind.annotation.*;
/**
 * RestController for creating Orders and OrderItems and Retrieving Orders and OrderItems
 */
@RestController
@RequestMapping("/oms")
public class OrderController {

    private final OrderService orderService;
    private final OrderServiceFeign orderServiceFeign;

    public OrderController(OrderService orderService, OrderServiceFeign orderServiceFeign) {
        this.orderService = orderService;
        this.orderServiceFeign = orderServiceFeign;
    }
    /**
     * API to retrieve Orders based on @orderId
     */
    @GetMapping("/getOrderInfo/{orderId}")
    public OrderDetails getOrders(@PathVariable("orderId") String orderId){
        return orderService.getOrderItem(orderId);
    }
    /**
     * API to create new Orders
     */
    @PostMapping("/createNewOrder")
    public OrderDetails createOrders(@RequestBody OrderDetails order){
        return orderService.createOrderItem(order);
    }
    /**
     * API to retrieve OrderItems based on @productCode
     */
    @GetMapping("/getOrderItemInfo/{productCode}")
    public OrderItem getOrderItems(@PathVariable("productCode") Integer productCode){
        return orderServiceFeign.fetchOrderItemDetails(productCode);
    }
    /**
     * API to create new OrderItems
     */
    @PostMapping("/createNewOrderItem")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
        return orderServiceFeign.createOrderItem(orderItem);
    }
}
