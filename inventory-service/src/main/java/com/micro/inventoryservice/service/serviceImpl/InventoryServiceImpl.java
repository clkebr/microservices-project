package com.micro.inventoryservice.service.serviceImpl;

import com.micro.inventoryservice.entity.Inventory;
import com.micro.inventoryservice.repository.InventoryRepository;
import com.micro.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        Inventory inventory = inventoryRepository.findInventoryBySkuCode(skuCode);
        return inventory.getQuantity()>0;
    }
}
