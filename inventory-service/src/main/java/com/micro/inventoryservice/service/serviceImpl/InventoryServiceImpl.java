package com.micro.inventoryservice.service.serviceImpl;

import com.micro.inventoryservice.dto.InventoryDto;
import com.micro.inventoryservice.entity.Inventory;
import com.micro.inventoryservice.mapper.MapperUtil;
import com.micro.inventoryservice.repository.InventoryRepository;
import com.micro.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final MapperUtil mapperUtil;

    @Override
    @Transactional(readOnly = true)
    public List<InventoryDto> getData(List<String> skuCode) {
       List<Inventory> inventoryList = inventoryRepository.findInventoryBySkuCodeIn(skuCode);
        return inventoryList.stream()
                .map(inventory -> mapperUtil.convertToType(inventory,new InventoryDto()))
                .peek(inventoryDto -> inventoryDto.setInStock(inventoryDto.getQuantity() > 0 ))
                .collect(Collectors.toList());
    }
}
