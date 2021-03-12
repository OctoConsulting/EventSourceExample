package com.octo.EventSourceExample.event;

public class RequestDeletedEvent {
  public final String id;

  public RequestDeletedEvent(String id) {
    this.id = id;
  }

}
