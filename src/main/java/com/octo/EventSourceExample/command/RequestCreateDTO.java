package com.octo.EventSourceExample.command;

public class RequestCreateDTO {
  private String createdBy;
  private String category;

  public String getCreatedBy() {
    return createdBy;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

}
