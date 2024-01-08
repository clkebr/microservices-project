package com.micro.inventoryservice.controller;

import com.micro.inventoryservice.entity.ResponseWrapper;
import com.micro.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    public ResponseEntity<ResponseWrapper> isInStock(@PathVariable("sku-code") String skuCode){
        boolean inStock = inventoryService.isInStock(skuCode);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(skuCode+" product is retrieved","Product is in stock --> "+inStock,HttpStatus.OK));
    }


}
