package com.micro.orderservice.dto;


import lombok.Data;

import java.util.List;

@Data
public class InventoryClientDto {


    public Boolean success;
    public String message;
    public Integer code;
    public List<InventoryResponseDto> data;

    @Data
    public static class InventoryResponseDto {

        private Long id;

        private String skuCode;

        private Integer quantity;

        private boolean isInStock;
    }
}
