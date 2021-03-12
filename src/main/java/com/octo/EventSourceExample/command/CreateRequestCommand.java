package com.octo.EventSourceExample.command;

public class CreateRequestCommand extends BaseCommand<String> {
  public final String createdBy;
  public final String category;

  public CreateRequestCommand(String id, String createdBy, String category) {
    super(id);
    this.createdBy = createdBy;
    this.category = category;
  }
}
