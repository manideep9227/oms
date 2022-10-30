package com.oms.example.orderservice.repository;

import com.oms.example.orderservice.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderItem,Integer> {

}
