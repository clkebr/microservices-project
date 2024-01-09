package com.micro.orderservice.service.serviceImpl;

import com.micro.orderservice.dto.InventoryClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.*;

@Service
@RequiredArgsConstructor
public class CommunicationServiceImp {

    private final WebClient webClient;

    public List<InventoryClientDto.InventoryResponseDto> getInventoryData(List<String> skuCodes) {
        String skuCodesParam = String.join(",", skuCodes);

        InventoryClientDto clientDto = webClient.get()
                .uri("http://localhost:8082/api/inventory?skuCode={skuCodes}", skuCodesParam)
                .retrieve()
                .bodyToMono(InventoryClientDto.class)
                .block();

        assert clientDto != null;
        return clientDto.getData();
    }


}
