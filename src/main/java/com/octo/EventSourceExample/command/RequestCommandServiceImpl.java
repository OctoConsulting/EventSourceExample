package com.octo.EventSourceExample.command;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class RequestCommandServiceImpl implements RequestCommandService {

  private final CommandGateway commandGateway;

  public RequestCommandServiceImpl(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @Override
  public CompletableFuture<String> createRequest(RequestCreateDTO requestCreateDTO) {
    return commandGateway.send(new CreateRequestCommand(UUID.randomUUID().toString(), requestCreateDTO.getCreatedBy(),
        requestCreateDTO.getCategory()));
  }

  @Override
  public CompletableFuture<String> deleteRequest(RequestDeleteDTO requestDeleteDTO) {
    return commandGateway.send(new DeleteRequestCommand(requestDeleteDTO.getId()));
  }
}
