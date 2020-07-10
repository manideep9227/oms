package com.oms.example.orderitemservice.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productCode;
    @Column
    private String productName;
    @Column
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId",nullable=false)
    private OrderDetails orderDetails;
}