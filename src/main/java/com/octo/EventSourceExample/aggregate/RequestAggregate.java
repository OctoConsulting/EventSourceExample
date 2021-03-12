package com.octo.EventSourceExample.aggregate;

import java.util.List;

import com.octo.EventSourceExample.command.CreateRequestCommand;
import com.octo.EventSourceExample.command.DeleteRequestCommand;
import com.octo.EventSourceExample.event.RequestCreatedEvent;
import com.octo.EventSourceExample.event.RequestDeletedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import static org.axonframework.modelling.command.AggregateLifecycle.markDeleted;

@Aggregate
public class RequestAggregate {
  @AggregateIdentifier
  private String id;

  private int createdDate;
  private String createdBy;
  private String comments;
  private String category;
  private String status;
  private boolean deleted;
  private List<Receipt> receipts;

  public RequestAggregate() {
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public String getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public int getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(int createdDate) {
    this.createdDate = createdDate;
  }

  @CommandHandler
  public RequestAggregate(CreateRequestCommand createRequestCommand) {
    AggregateLifecycle.apply(new RequestCreatedEvent(createRequestCommand.id, createRequestCommand.createdBy,
        createRequestCommand.category));
  }

  @CommandHandler
  public void DeleteAggregate(DeleteRequestCommand deleteRequestCommand) {
    AggregateLifecycle.apply(new RequestDeletedEvent(deleteRequestCommand.id));
  }

  @EventSourcingHandler
  protected void on(RequestCreatedEvent requestCreatedEvent) {
    this.id = requestCreatedEvent.id;
    this.setCreatedDate(requestCreatedEvent.createdDate);
    this.setCreatedBy(requestCreatedEvent.createdBy);
    this.setCategory(requestCreatedEvent.category);
    this.setStatus(requestCreatedEvent.status);
    this.setDeleted(false);
  }

  @EventSourcingHandler
  protected void on(RequestDeletedEvent requestDeletedEvent) {
    this.setDeleted(true);
    markDeleted();
  }

}