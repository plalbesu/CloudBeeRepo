package com.plal.trainapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Journey {
  private Train train;
  private Route route;
  private LocalDate journeyDate;
  private LocalTime startJourneyTime;
  private LocalTime endJourneyTime;

  private Journey(Builder builder) {
    this.train = builder.train;
    this.route = builder.route;
    this.journeyDate = builder.journeyDate;
    this.startJourneyTime = builder.startJourneyTime;
    this.endJourneyTime = builder.endJourneyTime;
  }

  public Train getTrain() {
    return train;
  }

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public LocalDate getJourneyDate() {
    return journeyDate;
  }

  public LocalTime getStartJourneyTime() {
    return startJourneyTime;
  }

  public LocalTime getEndJourneyTime() {
    return endJourneyTime;
  }

  public void setJourneyDate(LocalDate journeyDate) {
    this.journeyDate = journeyDate;
  }

  public void setStartJourneyTime(LocalTime startJourneyTime) {
    this.startJourneyTime = startJourneyTime;
  }

  public void setEndJourneyTime(LocalTime endJourneyTime) {
    this.endJourneyTime = endJourneyTime;
  }

  @Override
  public String toString() {
    String details = """
        --------------------------------------------------------------------------------------------------------------------------
        Train : %d - %s     Arrival : %s    Departure : %s
        """;
    return String.format(details, train.getNo(), train.getName(), String.valueOf(startJourneyTime), String.valueOf(endJourneyTime));
  }

  public static class Builder {
    private Train train;
    private Route route;
    private LocalDate journeyDate;
    private LocalTime startJourneyTime;
    private LocalTime endJourneyTime;

    public static Builder newIntance() {
      return new Builder();
    }
    private Builder() {}

    public Builder setTrain(Train train) {
      this.train = train;
      return this;
    }

    public Builder setRoute(Route route) {
      this.route = route;
      return this;
    }

    public Builder setJourneyDate(LocalDate date) {
      journeyDate = date;
      return this;
    }

    public Builder setStartJourneyTime(LocalTime startTime) {
      startJourneyTime = startTime;
      return this;
    }

    public Builder setEndJourneyTime(LocalTime endTime) {
      endJourneyTime = endTime;
      return this;
    }

    public Journey build() {
      return new Journey(this);
    }
  }
}
