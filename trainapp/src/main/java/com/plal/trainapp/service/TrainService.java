package com.plal.trainapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plal.trainapp.constant.Destinations;
import com.plal.trainapp.model.Journey;
import com.plal.trainapp.model.Route;
import com.plal.trainapp.model.Section;
import com.plal.trainapp.model.Train;
import com.plal.trainapp.repository.JourneyData;

@Service
public class TrainService {
  public List<Journey> getJourneyList() {
    return JourneyData.journeyList;
  }

  public List<Train> getTrainList() {
    return JourneyData.trainList;
  }

  public Train getTrain(int trainNo) {
    return JourneyData.trainList.stream()
        .filter(obj -> obj.getNo() == trainNo).findFirst().get();
  }
}
