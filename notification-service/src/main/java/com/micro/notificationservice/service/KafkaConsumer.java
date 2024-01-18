package com.micro.notificationservice.service;

import com.micro.notificationservice.event.OrderPlacedEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumer {
    void handleNotification(ConsumerRecord<String, OrderPlacedEvent> record);
}
