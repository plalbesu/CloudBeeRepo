package com.plal.trainapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plal.trainapp.model.Journey;
import com.plal.trainapp.model.Receipt;
import com.plal.trainapp.model.Train;
import com.plal.trainapp.model.UserTrainBookingDetail;
import com.plal.trainapp.repository.BookingData;

@Service
public class TrainBookingService {

  private TrainService trainService;
  private TicketService ticketService;

  public TrainBookingService(TrainService trainService,
      TicketService ticketService) {
    this.trainService = trainService;
    this.ticketService = ticketService;
  }
  public Receipt bookTicket(UserTrainBookingDetail userTrainBookingObj) {
   Optional<Train> tmptrain = trainService.getTrainList().stream()
       .filter(train1 -> train1.getNo() == userTrainBookingObj.getTrainNo()).findFirst();
   Train train = tmptrain.get();
   int seatNo = train.blockAvailableSeat(userTrainBookingObj.getSection());
    userTrainBookingObj.setSeat(seatNo);
    userTrainBookingObj.setTicketNo(ticketService.getTicketNo());
    BookingData.book(userTrainBookingObj);

    return getReceipt(userTrainBookingObj, train);
  }

  private Receipt getReceipt(UserTrainBookingDetail userTrainBookingObj, Train train) {
    Journey journey = trainService.getJourneyList().stream()
        .filter(j -> j.getTrain().getNo() == train.getNo()).findFirst().get();

    Receipt receipt = new Receipt();
    receipt.setTicketNo(userTrainBookingObj.getTicketNo());
    receipt.setFrom(journey.getRoute().getFrom());
    receipt.setTo(journey.getRoute().getTo());
    receipt.setFairPaid(userTrainBookingObj.getFair());
    receipt.setUser(userTrainBookingObj.getUser());

    return receipt;
  }

  public List<UserTrainBookingDetail> getAllBookingForTrain(int trainNo) {
    return BookingData.getAllBookingForTrain(trainNo);
  }

  public int updateTicket(int ticketNo) {
    UserTrainBookingDetail userDetail = BookingData.getBooking(ticketNo);
    Train train = trainService.getTrain(userDetail.getTrainNo());
    train.unBlockSeat(userDetail.getSection(), userDetail.getSeat());
    int seatNo = train.blockAvailableSeat(userDetail.getSection());
    userDetail.setSeat(seatNo);

    BookingData.updateTicket(ticketNo, userDetail);

    return seatNo;
  }
}
