package com.micro.orderservice.controller;

import com.micro.orderservice.dto.OrderDto;
import com.micro.orderservice.entity.ResponseWrapper;
import com.micro.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ResponseWrapper> placeOrder(@RequestBody OrderDto orderDto){

        OrderDto createdOrder = orderService.placeOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("Order placed successfully",createdOrder, HttpStatus.CREATED));
    }
}
