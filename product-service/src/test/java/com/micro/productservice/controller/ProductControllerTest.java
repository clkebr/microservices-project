package com.micro.productservice.controller;

import com.micro.productservice.config.TestConfig;
import com.micro.productservice.dto.ProductDto;
import com.micro.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class ProductControllerTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
     dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private MockMvc mockMVC;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldCreateProduct() throws Exception {

        //given
        ProductDto productDTO = getProductRequest();
        String request = objectMapper.writeValueAsString(productDTO);

        //when
        mockMVC.perform(MockMvcRequestBuilders.post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        //then
                .andExpect(status().isCreated());
    }
    @Test
    void shouldGetAllProducts() throws Exception {

        //given
        ProductDto productDTO = getProductRequest();
        String request = objectMapper.writeValueAsString(productDTO);

        mockMVC.perform(MockMvcRequestBuilders.post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request));

        //when
      mockMVC.perform(MockMvcRequestBuilders.get("/api/products")
                .contentType(MediaType.APPLICATION_JSON))
        //then
                .andExpect(status().isOk());
        //Todo: assertions

    }
    private ProductDto getProductRequest() {
        return ProductDto.builder()
                .name("iphone 15")
                .description("iphone 15")
                .price(BigDecimal.valueOf(1500)).build();
    }
}
