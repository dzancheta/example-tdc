package com.exampletdc.mapper;

import com.exampletdc.model.ClientModel;
import com.exampletdc.model.ClientResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static List<ClientResponse> toClientResponseList(List<ClientModel> clientModelList) {
        return clientModelList.stream().map(ClientMapper::toClientResponse).collect(Collectors.toList());
    }
    public static ClientResponse toClientResponse(ClientModel clientModel) {
        return new ClientResponse(clientModel.name(), clientModel.birthDate(), clientModel.gender());
    }
}
