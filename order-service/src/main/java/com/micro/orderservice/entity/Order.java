package com.micro.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "t-orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String orderNumber;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<OrderLineItems> orderLineItemsDto;

}
