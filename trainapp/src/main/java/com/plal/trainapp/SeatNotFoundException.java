package com.plal.trainapp;

public class SeatNotFoundException extends RuntimeException{

  public SeatNotFoundException(String msg) {
    super(msg);
  }
}
