package com.exampletdc.facade;

import com.exampletdc.mapper.ClientMapper;
import com.exampletdc.model.ClientResponse;
import com.exampletdc.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ClientFacade {
    private ClientService clientService;
    public Mono<ClientResponse> getClientById(String clientId) {
        return clientService.getClientById(clientId).map(ClientMapper::toClientResponse);
    }
}
