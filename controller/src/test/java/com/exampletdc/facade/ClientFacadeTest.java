package com.exampletdc.facade;

import com.exampletdc.model.ClientModel;
import com.exampletdc.model.ClientResponse;
import com.exampletdc.service.ClientService;
import com.exampletdc.util.GenderEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class ClientFacadeTest {
    @Mock
    ClientService clientService;

    @InjectMocks
    ClientFacade clientFacade;


    @Test
    void shouldReturnClientByIdWhenClientExists() {
        //given
        String clientId = "123";
        var expected = new ClientResponse("Hello World " + clientId,  LocalDate.of(1995,8, 27), GenderEnum.MALE);
        var returnService = new ClientModel("Hello World " + clientId, LocalDate.of(1995,8, 27), GenderEnum.MALE);

        Mockito.when(clientService.getClientById(clientId)).thenReturn(Mono.just(returnService));

        //when
        var result = clientFacade.getClientById(clientId);

        //then
        assertNotNull(result);
        StepVerifier.create(clientFacade.getClientById(clientId))
                .assertNext(response -> Assertions.assertEquals(expected, response))
                .verifyComplete();
    }
}