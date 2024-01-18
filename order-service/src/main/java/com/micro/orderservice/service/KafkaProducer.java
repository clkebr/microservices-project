package com.micro.orderservice.service;

import com.micro.orderservice.event.OrderPlacedEvent;

public interface KafkaProducer {
    void sendMessage(OrderPlacedEvent event);

}
