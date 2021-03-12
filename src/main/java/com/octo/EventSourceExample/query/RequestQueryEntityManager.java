package com.octo.EventSourceExample.query;

import com.octo.EventSourceExample.aggregate.RequestAggregate;
import com.octo.EventSourceExample.event.BaseEvent;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestQueryEntityManager {

  @Autowired
  private RequestRepository requestRepository;

  @Autowired
  private EventSourcingRepository<RequestAggregate> requestAggregateEventSourcingRepository;

  @EventSourcingHandler
  void on(BaseEvent event) {
    persistRequest(buildQueryRequest(getRequestFromEvent(event)));
  }

  private RequestAggregate getRequestFromEvent(BaseEvent event) {
    return requestAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
  }

  private RequestQueryEntity findExistingOrCreateQueryRequest(String id) {
    return requestRepository.findById(id).isPresent() ? requestRepository.findById(id).get() : new RequestQueryEntity();
  }

  private RequestQueryEntity buildQueryRequest(RequestAggregate requestAggregate) {
    RequestQueryEntity requestQueryEntity = findExistingOrCreateQueryRequest(requestAggregate.getId());

    requestQueryEntity.setId(requestAggregate.getId());
    requestQueryEntity.setCreatedDate(requestAggregate.getCreatedDate());
    requestQueryEntity.setStatus(requestAggregate.getStatus());
    requestQueryEntity.setCategory(requestAggregate.getCategory());
    requestQueryEntity.setCreatedBy(requestAggregate.getCreatedBy());
    requestQueryEntity.setDeleted(requestAggregate.isDeleted());

    return requestQueryEntity;
  }

  private void persistRequest(RequestQueryEntity requestQueryEntity) {
    requestRepository.save(requestQueryEntity);
  }

}
