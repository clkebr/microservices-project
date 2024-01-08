package com.micro.inventoryservice.service;

import com.micro.inventoryservice.dto.InventoryDto;

import java.util.List;

public interface InventoryService {
    List<InventoryDto> getData(List<String> skuCode);
}
