package com.exampletdc.service;

import com.exampletdc.model.ClientModel;
import com.exampletdc.util.GenderEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ClientService {
    public Mono<ClientModel> getClientById(String clientId) {
        return Mono.just(new ClientModel("Hello World " + clientId, LocalDate.of(1995,8, 27), GenderEnum.MALE));
    }

    public Flux<ClientModel> getAllClients() {
        return Flux.just(
                new ClientModel("John", LocalDate.of(1995,8, 27), GenderEnum.MALE),
                new ClientModel("Doe", LocalDate.of(1995,8, 27), GenderEnum.MALE)
        );
    }
}
