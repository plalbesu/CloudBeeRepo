package com.plal.trainapp.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.plal.trainapp.constant.Destinations;
import com.plal.trainapp.model.Journey;
import com.plal.trainapp.model.Route;
import com.plal.trainapp.model.Section;
import com.plal.trainapp.model.Train;

public class JourneyData {

  public static Map<String[], List<Journey>> journeyMap = new HashMap<>();
  public static List<Train> trainList = new ArrayList<>();
  public static List<Journey> journeyList = new ArrayList<>();
  static{
    Route route = new Route("UK route", Destinations.LONDON.name(), Destinations.FRANCE.name());
    Train train = new Train("Train 1", 12345);

    trainList.add(train);
    Journey journey = Journey.Builder.newIntance()
        .setTrain(train)
        .setRoute(route)
        .setJourneyDate(LocalDate.of(2024, Month.FEBRUARY, 29))
        .setStartJourneyTime(LocalTime.of(8, 30))
        .setEndJourneyTime(LocalTime.of(22, 15))
        .build();

    journeyList.add(journey);
    String[] fromToArray = {Destinations.LONDON.name(), Destinations.FRANCE.name()};
    journeyMap.put(fromToArray, List.of(journey));
  }
}
