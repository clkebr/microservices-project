package com.micro.productservice.controller;

import com.micro.productservice.dto.ProductDto;
import com.micro.productservice.entity.ResponseWrapper;
import com.micro.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDto productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("Product is successfully created ",productDTO,HttpStatus.CREATED));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllProduct(){
        List<ProductDto> productDTOS = productService.findAllProducts();
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productDTOS,HttpStatus.OK));
    }


}
