package com.oms.example.orderservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String ratingId;
    @Column
    private int rating;
    @Column
    private String feedback;
    @ManyToOne
    @JoinColumn(name="restaurantId")
    @ToString.Exclude
    private Restaurant restaurant;

}
