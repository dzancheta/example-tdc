package com.exampletdc.exampletdc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ClientService {
    public Mono<String> getClientById(String clientId) {
        return Mono.just("Hello TDC".concat(clientId));
    }
}
