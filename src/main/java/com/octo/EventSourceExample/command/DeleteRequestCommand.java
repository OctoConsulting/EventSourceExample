package com.octo.EventSourceExample.command;

public class DeleteRequestCommand extends BaseCommand<String> {

  public DeleteRequestCommand(String id) {
    super(id);
  }

}
