package com.oms.example.orderservice.service;

import com.oms.example.orderservice.exception.OrderNotFoundException;
import com.oms.example.orderservice.model.OrderDetails;
import com.oms.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDetails getOrderItem(String orderId){
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }
    public OrderDetails createOrderItem(OrderDetails orderItem){
        return orderRepository.save(orderItem);
    }

    public List<OrderDetails> getOrders(){
        return StreamSupport.stream(orderRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
