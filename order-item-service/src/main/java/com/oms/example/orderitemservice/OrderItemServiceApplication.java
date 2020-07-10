package com.oms.example.orderitemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OrderItemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderItemServiceApplication.class, args);
    }

}
