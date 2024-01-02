package com.micro.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude
public class OrderDto {


    private Long id;

    String orderNumber;

    private List<OrderLineItemsDto> orderLineItemsDto;
}
