package com.micro.orderservice.controller;

import com.micro.orderservice.dto.OrderDto;
import com.micro.orderservice.entity.ResponseWrapper;
import com.micro.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @CircuitBreaker(name = "inventory",fallbackMethod = "inventoryFallback")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<ResponseEntity<ResponseWrapper>>  placeOrder(@RequestBody OrderDto orderDto){

        OrderDto createdOrder = orderService.placeOrder(orderDto);
        return CompletableFuture.supplyAsync(()->
                ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("Order placed successfully",createdOrder, HttpStatus.CREATED)));
    }

    public CompletableFuture<ResponseEntity<ResponseWrapper>> inventoryFallback(OrderDto orderDto, RuntimeException runtimeException) {
        return
                CompletableFuture.supplyAsync(()->
                        ResponseEntity.status(HttpStatus.OK)
                                      .body(new ResponseWrapper("Oops! Something went wrong, please order again.", HttpStatus.OK)));
    }

}
