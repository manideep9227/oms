package com.ordermanagement.example.oms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails,String> {

}
