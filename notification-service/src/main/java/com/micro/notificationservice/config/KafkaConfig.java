//package com.micro.notificationservice.config;
//
//import com.micro.notificationservice.event.OrderPlacedEvent;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
//@Configuration
//public class KafkaConfig {
//
//    @Bean
//    public ConsumerFactory<String, OrderPlacedEvent> orderPlacedEventConsumerFactory() {
//        Map<String, Object> properties = new HashMap<>();
//        // configure properties if needed
//
//        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(), new JsonDeserializer<>(OrderPlacedEvent.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, OrderPlacedEvent> orderPlacedEventKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, OrderPlacedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(orderPlacedEventConsumerFactory());
//        return factory;
//    }
//}
