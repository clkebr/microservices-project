package com.micro.productservice.service;


import com.micro.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDTO);

    List<ProductDto> findAllProducts();
}
