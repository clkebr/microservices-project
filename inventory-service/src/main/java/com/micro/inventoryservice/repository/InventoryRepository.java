package com.micro.inventoryservice.repository;

import com.micro.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

   List<Inventory> findInventoryBySkuCodeIn(List<String> skuCode);
}
