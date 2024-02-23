package com.plal.trainapp.service;

import org.springframework.stereotype.Service;

import com.plal.trainapp.model.UserTrainBookingDetail;
import com.plal.trainapp.repository.BookingData;

@Service
public class TicketService {

  private final int min = 1000;
  private final int max = Integer.MAX_VALUE;
  public int getTicketNo() {
    return min + (int)(Math.random() * ((max - min) + 1));
  }

  public UserTrainBookingDetail showTicket(int ticketNo) {
    return BookingData.getBooking(ticketNo);
  }

  public boolean deleteTkt(int ticketNo) {
    return BookingData.deleteTicket(ticketNo);
  }
}
