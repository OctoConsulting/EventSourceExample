package com.octo.EventSourceExample.query;

import java.util.List;

public interface RequestQueryService {
  public List<Object> listEventsForRequest(String requestId);

  public RequestQueryEntity getRequest(String requestId);

  public List<RequestQueryEntity> getAllRequests();

}
