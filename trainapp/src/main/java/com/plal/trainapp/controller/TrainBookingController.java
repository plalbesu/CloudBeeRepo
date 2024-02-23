package com.plal.trainapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plal.trainapp.model.Receipt;
import com.plal.trainapp.model.UserTrainBookingDetail;
import com.plal.trainapp.service.TicketService;
import com.plal.trainapp.service.TrainBookingService;

@RestController
@RequestMapping("/trainapp")
public class TrainBookingController {

  @Autowired
  private TrainBookingService trainBookingService;
  @Autowired
  private TicketService ticketService;

  @PostMapping("book-ticket")
  public ResponseEntity<?> bookTicket(@RequestBody UserTrainBookingDetail userTrainBookingDetail) {
    try {
      Receipt receipt = trainBookingService.bookTicket(userTrainBookingDetail);
      return new ResponseEntity<>(receipt, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Seat Not Available !!");
    }

  }

  @GetMapping("/ticket/{ticketNo}")
  public ResponseEntity<UserTrainBookingDetail> showBookedTicket(@PathVariable int ticketNo) {
    try {
      UserTrainBookingDetail userDetails = ticketService.showTicket(ticketNo);
      return new ResponseEntity<>(userDetails, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

  }

  @GetMapping("/train/{trainNo}/all-booking")
  public ResponseEntity<List<UserTrainBookingDetail>> showAllTicket(@PathVariable int trainNo) {
    return new ResponseEntity<>(trainBookingService.getAllBookingForTrain(trainNo), HttpStatus.OK);
  }

  @DeleteMapping("/ticket/{ticketNo}")
  public ResponseEntity<Boolean> CancelTicket(@PathVariable int ticketNo) {
    try {
      boolean done = ticketService.deleteTkt(ticketNo);
      return new ResponseEntity<>(done, HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
    }
  }

  @PutMapping("/ticket/{ticketNo}")
  public ResponseEntity<String> modifyTicket(@PathVariable int ticketNo) {
    try {
      int seat = trainBookingService.updateTicket(ticketNo);
      return new ResponseEntity<>("New Seat = "+seat, HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity<>("Seat Not Found", HttpStatus.NO_CONTENT);
    }
  }

}
