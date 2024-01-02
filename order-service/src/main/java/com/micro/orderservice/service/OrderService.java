package com.micro.orderservice.service;

import com.micro.orderservice.dto.OrderDto;

public interface OrderService {
    OrderDto placeOrder(OrderDto orderDto);
}
