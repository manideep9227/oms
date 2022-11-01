package com.oms.example.orderservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String customerId;
    @Column
    private String customerName;
    @Column
    private String emailId;
    @Column
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId",nullable=false)
    private OrderDetails orderDetails;

    @OneToOne(mappedBy = "customer")
    private OrderDetails order;

}
