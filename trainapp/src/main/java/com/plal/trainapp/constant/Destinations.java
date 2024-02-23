package com.plal.trainapp.constant;

public enum Destinations {

  LONDON("London", "LND", 0),
  PARIS("Paris", "PRS", 60),
  FRANCE("France", "FRN", 100);


  private String name;
  private String sysmbol;
  private double distanceFromLondon;

  Destinations(String name, String sysmbol, double distanceFromLondon) {
    this.name = name;
    this.sysmbol = sysmbol;
    this.distanceFromLondon = distanceFromLondon;
  }
}
