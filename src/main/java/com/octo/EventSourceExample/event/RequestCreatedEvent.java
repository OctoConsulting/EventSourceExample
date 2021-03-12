package com.octo.EventSourceExample.event;

public class RequestCreatedEvent extends BaseEvent<String> {
  public final int createdDate;
  public final String status;
  public final String createdBy;
  public final String category;

  public RequestCreatedEvent(String id, String createdBy, String category) {
    super(id);
    this.createdDate = 111;
    this.status = "OPEN";
    this.createdBy = createdBy;
    this.category = category;
  }
}
