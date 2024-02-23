package com.plal.trainapp.model;

public class UserJourney {
  private User user;
  private String from;
  private String to;

  public UserJourney(User user, String from, String to) {
    this.user = user;
    this.from = from;
    this.to = to;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }
}
