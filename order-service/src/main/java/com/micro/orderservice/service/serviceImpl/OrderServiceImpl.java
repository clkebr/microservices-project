package com.micro.orderservice.service.serviceImpl;

import com.micro.orderservice.dto.OrderDto;
import com.micro.orderservice.entity.Order;
import com.micro.orderservice.mapper.MapperUtil;
import com.micro.orderservice.repository.OrderRepository;
import com.micro.orderservice.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final MapperUtil mapperUtil;
    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public OrderDto placeOrder(OrderDto orderDto) {

        Order order = mapperUtil.convertToType(orderDto,new Order());
        order.setOrderNumber(UUID.randomUUID().toString());
        Order save = orderRepository.save(order);


        return mapperUtil.convertToType(save, new OrderDto());
    }
}
