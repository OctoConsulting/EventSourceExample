package com.octo.EventSourceExample.query;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestQueryEntity {

  @Id
  private String id;

  private int createdDate;
  private String status;
  private String createdBy;
  private String category;
  private boolean deleted;

  public void setId(String id) {
    this.id = id;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public int getCreatedDate() {
    return createdDate;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setCreatedDate(int createdDate) {
    this.createdDate = createdDate;
  }

}
