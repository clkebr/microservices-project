package com.micro.inventoryservice.repository;

import com.micro.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findInventoryBySkuCode(String skuCode);
}
