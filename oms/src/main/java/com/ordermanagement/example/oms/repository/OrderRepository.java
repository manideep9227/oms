package com.ordermanagement.example.oms.repository;

import com.ordermanagement.example.oms.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails,String> {

}
