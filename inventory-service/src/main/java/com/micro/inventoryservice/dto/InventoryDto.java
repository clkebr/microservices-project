package com.micro.inventoryservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryDto {

    private Long id;

    private String skuCode;

    private Integer quantity;

    private boolean isInStock;
}