package com.plal.trainapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.plal.trainapp.model.UserTrainBookingDetail;

public class BookingData {
  private static List<UserTrainBookingDetail> userTrainBookingDetailList = new ArrayList<>();

  //<trainNo,UserDetail>
  private static Map<Integer, List<UserTrainBookingDetail>> trainBookingMap = new HashMap<>();

  public static void book(UserTrainBookingDetail userTrainBookingObj) {
    userTrainBookingDetailList.add(userTrainBookingObj);
    updateMap(userTrainBookingObj);
  }

  private static void updateMap(UserTrainBookingDetail userTrainBookingObj) {
    List<UserTrainBookingDetail> list = null;
    if(trainBookingMap.get(userTrainBookingObj.getTrainNo()) == null) {
      list = new ArrayList<>();
      list.add(userTrainBookingObj);
      trainBookingMap.put(userTrainBookingObj.getTrainNo(), list);
    } else {
      list = trainBookingMap.get(userTrainBookingObj.getTrainNo());
      list.add(userTrainBookingObj);
      trainBookingMap.put(userTrainBookingObj.getTrainNo(), list);
    }
  }

  public static UserTrainBookingDetail getBooking(int ticketNo) {
    return userTrainBookingDetailList.stream()
        .filter( obj -> obj.getTicketNo() == ticketNo).findFirst().get();
  }

  public static List<UserTrainBookingDetail> getAllBookingForTrain(int trainNo) {
    return trainBookingMap.get(trainNo);
  }

  public static boolean deleteTicket(int ticketNo) {
    UserTrainBookingDetail userDetail = getBooking(ticketNo);
    List<UserTrainBookingDetail> list = trainBookingMap.get(userDetail.getTrainNo());
    list.removeIf(obj -> obj.getTicketNo() == ticketNo);
    return userTrainBookingDetailList.remove(userDetail);
  }

  public static void updateTicket(int ticketNo, UserTrainBookingDetail newUserDetail) {
    UserTrainBookingDetail userDetail = getBooking(ticketNo);

    List<UserTrainBookingDetail> list = trainBookingMap.get(userDetail.getTrainNo());
    for(UserTrainBookingDetail tmpUserDetail : list) {
      if(tmpUserDetail.getTicketNo() == ticketNo) {
        list.remove(tmpUserDetail);
        list.add(newUserDetail);
      }
    }

    for(UserTrainBookingDetail tmpUserDetail : userTrainBookingDetailList) {
      if(tmpUserDetail.getTicketNo() == ticketNo) {
        list.remove(tmpUserDetail);
        list.add(newUserDetail);
      }
    }
  }
}
