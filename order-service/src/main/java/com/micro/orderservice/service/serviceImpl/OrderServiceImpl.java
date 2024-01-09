package com.micro.orderservice.service.serviceImpl;

import com.micro.orderservice.dto.InventoryClientDto;
import com.micro.orderservice.dto.OrderDto;
import com.micro.orderservice.entity.Order;
import com.micro.orderservice.entity.OrderLineItems;
import com.micro.orderservice.exception.OutOfStockException;
import com.micro.orderservice.mapper.MapperUtil;
import com.micro.orderservice.repository.OrderRepository;
import com.micro.orderservice.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;



@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final MapperUtil mapperUtil;
    private final OrderRepository orderRepository;

    private final CommunicationServiceImp communicationService;

    @Transactional
    @Override
    public OrderDto placeOrder(OrderDto orderDto) {

        Order order = mapperUtil.convertToType(orderDto,new Order());
        order.setOrderNumber(UUID.randomUUID().toString());
        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode).toList();

        //consume inventory client
        List<InventoryClientDto.InventoryResponseDto> inventoryData = communicationService.getInventoryData(skuCodes);


        // check all orders in stock or not
        boolean allProductsInStock = inventoryData.stream().allMatch(InventoryClientDto.InventoryResponseDto::isInStock);

        Order saved;
        if(allProductsInStock){
           saved =  orderRepository.save(order);
        }else{
            throw new OutOfStockException("Product is not in stock, please try again later");
        }

        return mapperUtil.convertToType(saved, new OrderDto());
    }
}
