package com.micro.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {
    private  String id;
    private  String name;
    private  String description;
    private BigDecimal price;
}
