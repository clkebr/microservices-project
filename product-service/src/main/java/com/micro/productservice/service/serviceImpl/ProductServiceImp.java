package com.micro.productservice.service.serviceImpl;

import com.micro.productservice.dto.ProductDto;
import com.micro.productservice.entity.Product;
import com.micro.productservice.mapper.MapperUtil;
import com.micro.productservice.repository.ProductRepository;
import com.micro.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository repository;
    private final MapperUtil mapperUtil;

    @Override
    public ProductDto createProduct(ProductDto productDTO) {
        return null;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> all = repository.findAll();
        return all.stream()
                .map(product -> mapperUtil.convertToType(product, new ProductDto()))
                .collect(Collectors.toList());

    }
}
