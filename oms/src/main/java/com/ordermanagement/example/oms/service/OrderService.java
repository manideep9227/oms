package com.ordermanagement.example.oms.service;

import com.ordermanagement.example.oms.exception.OrderNotFoundException;
import com.ordermanagement.example.oms.model.OrderDetails;
import com.ordermanagement.example.oms.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDetails getOrderItem(String orderId){
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }
    public OrderDetails createOrderItem(OrderDetails orderDetails){
        return orderRepository.save(orderDetails);
    }
}
