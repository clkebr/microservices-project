package com.micro.inventoryservice.controller;

import com.micro.inventoryservice.dto.InventoryDto;
import com.micro.inventoryservice.entity.ResponseWrapper;
import com.micro.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping()
    public ResponseEntity<ResponseWrapper> isInStock(@RequestParam List<String> skuCode){
        List<InventoryDto> dtoList = inventoryService.getData(skuCode);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(skuCode+" product is retrieved",dtoList,HttpStatus.OK));
    }


}
