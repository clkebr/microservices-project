package com.micro.orderservice.service.serviceImpl;

import com.micro.orderservice.dto.InventoryClientDto;
import com.micro.orderservice.service.CommunicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.*;

@Service
@RequiredArgsConstructor
public class CommunicationServiceImp implements CommunicationService {

    private final WebClient webClient;


    @Override
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
