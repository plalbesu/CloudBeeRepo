package com.plal.trainapp.model;

public class Seat {
  private int seatNo;
  private boolean isAvailable;

  public int getSeatNo() {
    return seatNo;
  }

  public Seat() {}

  public Seat(int seatNo, boolean isAvailable) {
    this.seatNo = seatNo;
    this.isAvailable = isAvailable;
  }

  public void setSeatNo(int seatNo) {
    this.seatNo = seatNo;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  @Override
  public String toString() {
    return "Seat{" + "seatNo=" + seatNo + ", isAvailable=" + isAvailable + '}';
  }
}
