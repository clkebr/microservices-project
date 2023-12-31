package com.micro.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderLineItemsDto {


    private String skuCode;

    private BigDecimal price;

    private int quantity;

}
