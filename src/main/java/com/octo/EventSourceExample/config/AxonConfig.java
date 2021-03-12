package com.octo.EventSourceExample.config;

import com.octo.EventSourceExample.aggregate.RequestAggregate;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

  @Bean
  EventSourcingRepository<RequestAggregate> accountAggregateEventSourcingRepository(EventStore eventStore) {
    EventSourcingRepository<RequestAggregate> repository = EventSourcingRepository.builder(RequestAggregate.class)
        .eventStore(eventStore).build();
    return repository;
  }
}
