package com.ordermanagement.example.oms.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String orderId;
    @Column
    private String customerName;
    @Column
    private Date orderDate;
    @Column
    private String shippingAddress;
    @OneToMany(mappedBy = "orderDetails",fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;
    @Column
    private int totalOrders;
}
