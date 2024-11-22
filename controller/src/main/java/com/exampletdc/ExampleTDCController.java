package com.exampletdc;


import com.exampletdc.facade.ClientFacade;
import com.exampletdc.model.ClientResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("v1/client")
@Tag(name = "Client Rest Controller V1", description = "Client Rest Controller V1")
public class ExampleTDCController {
    private ClientFacade clientFacade;

    @GetMapping(path = "/{clientId}")
    @Operation(
            method = "GET",
            description = "Get [V1] client by id",
            summary = "Return [V1] to the client by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "[V1] Get client by id",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ClientResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal error",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class))
                    )
            }
    )
    public Mono<ClientResponse> getClientById(@PathVariable("clientId") String clientId) {
        return clientFacade.getClientById(clientId);
    }
}
