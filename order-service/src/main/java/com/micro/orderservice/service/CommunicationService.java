package com.micro.orderservice.service;

import com.micro.orderservice.dto.InventoryClientDto;

import java.util.List;

public interface CommunicationService {

    List<InventoryClientDto.InventoryResponseDto> getInventoryData(List<String> skuCodes);
}
