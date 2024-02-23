package com.plal.trainapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserTrainBookingDetail {
  private User user;
  private int trainNo;
  private String trainName;
  private String section;
  @JsonIgnore
  private int seat;
  @JsonIgnore
  private LocalDate JourneyDate;
  @JsonIgnore
  private LocalTime arrival;
  private double fair;
  private int ticketNo;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getTrainNo() {
    return trainNo;
  }

  public void setTrainNo(int trainNo) {
    this.trainNo = trainNo;
  }

  public String getTrainName() {
    return trainName;
  }

  public void setTrainName(String trainName) {
    this.trainName = trainName;
  }

  public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public int getSeat() {
    return seat;
  }

  public void setSeat(int seat) {
    this.seat = seat;
  }

  public LocalDate getJourneyDate() {
    return JourneyDate;
  }

  public void setJourneyDate(LocalDate journeyDate) {
    JourneyDate = journeyDate;
  }

  public LocalTime getArrival() {
    return arrival;
  }

  public void setArrival(LocalTime arrival) {
    this.arrival = arrival;
  }

  public double getFair() {
    return fair;
  }
  public void setFair(double fair) {
    this.fair = fair;
  }

  public int getTicketNo() {
    return ticketNo;
  }

  public void setTicketNo(int ticketNo) {
    this.ticketNo = ticketNo;
  }

  @Override
  public String toString() {
    String ticket = """
        ------------------
        Ticket No : %d
        Train : %d - %s
        Seat : %s - %d
        ------------------
        """;

    return String.format(ticket, ticketNo, trainNo, trainName, section, seat);
  }
}
