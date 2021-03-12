package com.octo.EventSourceExample.command;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/request")
@Api(value = "Request Commands", description = "Request Commands Related Endpoints", tags = "Request Commands")
public class RequestCommandController {
  private final RequestCommandService requestCommandService;

  public RequestCommandController(RequestCommandService requestCommandService) {
    this.requestCommandService = requestCommandService;
  }

  @PostMapping
  public CompletableFuture<String> createRequest(@RequestBody RequestCreateDTO requestCreateDTO) {
    return requestCommandService.createRequest(requestCreateDTO);
  }

  @PostMapping("/delete")
  public CompletableFuture<String> deleteRequest(@RequestBody RequestDeleteDTO requestDeleteDTO) {
    return requestCommandService.deleteRequest(requestDeleteDTO);
  }
}
