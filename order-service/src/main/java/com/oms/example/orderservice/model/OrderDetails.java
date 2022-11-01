package com.oms.example.orderservice.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String orderId;
    @Column
    @OneToOne(mappedBy = "customerId")
    private Customer customer;
    @Column
    private Date orderDate;
    @Column
    private String deliverAddress;

    @OneToMany(mappedBy = "orderDetails",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FoodItem> orderItemList;
    @Column
    private int totalOrders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetails that = (OrderDetails) o;
        return orderId != null && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
