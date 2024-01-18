package com.micro.orderservice.service.serviceImpl;

import com.micro.orderservice.event.OrderPlacedEvent;
import com.micro.orderservice.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerImpl  implements KafkaProducer {

    @Value("${spring.kafka.template.default-topic}")
    private String TOPIC_NAME;

    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @Override
    public void sendMessage(OrderPlacedEvent event) {
        kafkaTemplate.send( TOPIC_NAME, event);
    }
}
