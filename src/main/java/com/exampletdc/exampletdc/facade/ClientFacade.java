package com.exampletdc.exampletdc.facade;


import com.exampletdc.exampletdc.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ClientFacade {
    private ClientService clientService;
    public Mono<String> getClientById(String clientId) {
        return clientService.getClientById(clientId);
    }
}
