package com.octo.EventSourceExample.query;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/request")
@Api(value = "Request Queries", description = "Request Query Events Endpoint", tags = "Request Queries")
public class RequestQueryController {

  private final RequestQueryService requestQueryService;

  public RequestQueryController(RequestQueryService requestQueryService) {
    this.requestQueryService = requestQueryService;
  }

  @GetMapping("/{requestId}")
  public RequestQueryEntity getReqeust(@PathVariable(value = "requestId") String requestId) {
    return requestQueryService.getRequest(requestId);
  }

  @GetMapping("/{requestId}/events")
  public List<Object> listEventsForRequest(@PathVariable(value = "requestId") String requestId) {
    return requestQueryService.listEventsForRequest(requestId);
  }

  @GetMapping("/all")
  public List<RequestQueryEntity> getAllRequests() {
    return requestQueryService.getAllRequests();
  }
}
