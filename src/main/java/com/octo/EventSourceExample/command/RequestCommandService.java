package com.octo.EventSourceExample.command;

import java.util.concurrent.CompletableFuture;

public interface RequestCommandService {
  public CompletableFuture<String> createRequest(RequestCreateDTO requestCreateDTO);

  public CompletableFuture<String> deleteRequest(RequestDeleteDTO requestDeleteDTO);
}
