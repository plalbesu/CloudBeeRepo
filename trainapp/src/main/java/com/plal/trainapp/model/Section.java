package com.plal.trainapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.plal.trainapp.SeatNotFoundException;

public class Section {
  private String sectionName;
  private double extraPricePerKM;
  private List<Seat> seats;
  private final int DEFAULT_SEAT_NO;
  private int availableSeat;

  public Section(String sectionName) {
    this.sectionName = sectionName;
    this.DEFAULT_SEAT_NO = 10;
    initSeat();
  }

  public Section(String sectionName, double extraPricePerKM, final int seatNo) {
    this.sectionName = sectionName;
    this.extraPricePerKM = extraPricePerKM;
    this.DEFAULT_SEAT_NO = seatNo;
    initSeat();
  }

  private void initSeat() {
    availableSeat = DEFAULT_SEAT_NO;
    seats = new ArrayList<>(DEFAULT_SEAT_NO);
    for(int i=0; i<DEFAULT_SEAT_NO; i++) {
      seats.add(new Seat(i+1, true));
    }
  }

  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  public double getExtraPricePerKM() {
    return extraPricePerKM;
  }

  public void setExtraPricePerKM(double extraPricePerKM) {
    this.extraPricePerKM = extraPricePerKM;
  }

  public Seat getSeat(int seatNo) {
    if(seatNo > 0 && seatNo <= DEFAULT_SEAT_NO)
      return seats.get(seatNo);
    else {
      throw new SeatNotFoundException("Wrong seat no : "+seatNo);
    }
  }

  public int blockSeat() {
    if(availableSeat> 0 && availableSeat <= DEFAULT_SEAT_NO) {
      Optional<Seat> tmpSeat = seats.stream().filter(seat_ -> seat_.isAvailable()).findFirst();
      Seat seat = tmpSeat.get();
      seat.setAvailable(false);
      return seat.getSeatNo();
    }
    availableSeat--;
    return -1;
  }

  public void unBlockSeat(int seatNo) {
    seats.get(seatNo).setAvailable(true);
  }
}
