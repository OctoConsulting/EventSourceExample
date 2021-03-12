package com.octo.EventSourceExample.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

@Service
public class RequestQueryServiceImpl implements RequestQueryService {

  private final EventStore eventStore;
  private final RequestRepository requestRepository;

  public RequestQueryServiceImpl(EventStore eventStore, RequestRepository requestRepository) {
    this.eventStore = eventStore;
    this.requestRepository = requestRepository;
  }

  @Override
  public List<Object> listEventsForRequest(String requestId) {
    return eventStore.readEvents(requestId).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
  }

  @Override
  public RequestQueryEntity getRequest(String requestId) {
    return requestRepository.findById(requestId).get();
  }

  @Override
  public List<RequestQueryEntity> getAllRequests() {
    List<RequestQueryEntity> result = new ArrayList<RequestQueryEntity>();
    requestRepository.findAll().forEach(r -> {
      if (!r.isDeleted())
        result.add(r);
    });
    return result;
  }

}
