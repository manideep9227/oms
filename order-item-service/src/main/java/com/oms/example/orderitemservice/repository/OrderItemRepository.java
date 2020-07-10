package com.oms.example.orderitemservice.repository;

import com.oms.example.orderitemservice.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {

}
