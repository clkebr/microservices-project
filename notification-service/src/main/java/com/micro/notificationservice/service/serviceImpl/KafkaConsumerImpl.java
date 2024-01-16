package com.micro.notificationservice.service.serviceImpl;

import com.micro.notificationservice.event.OrderPlacedEvent;
import com.micro.notificationservice.service.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerImpl implements KafkaConsumer {



    @Override
    @KafkaListener(topics ="${spring.kafka.template.default-topic}")
    public void handleNotification(ConsumerRecord<String, OrderPlacedEvent> record) {
        //todo: implement send email func
        OrderPlacedEvent event = record.value();
        log.info("Received Notification for order - "+ event.getOrderNumber());

    }
}
