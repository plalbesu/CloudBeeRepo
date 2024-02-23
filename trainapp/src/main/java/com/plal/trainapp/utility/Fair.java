package com.plal.trainapp.utility;

import com.plal.trainapp.constant.TrainType;

public class Fair {
    private static double getBaseFair(TrainType type) {
      double fair = 0;
      switch(type) {
        case GENERAL -> fair = 0.1;
        case ECONOMY -> fair = 0.15;
        case SUPERFAST -> fair = 0.2;
      }
      return  fair;
    }

    public static double getFair(TrainType type, int distance) {
      return  getBaseFair(type) * distance;
    }

  public static double getFair(TrainType type, double distance, double extraFairPerKm) {
    return  getBaseFair(type) * distance + distance * extraFairPerKm;
  }
}
