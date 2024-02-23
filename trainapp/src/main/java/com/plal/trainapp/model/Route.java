package com.plal.trainapp.model;

public class Route {
  private String routeName;
  private String from;
  private String to;
  private String[] stops;

  public Route(String routeName, String from, String to) {
    this.routeName = routeName;
    this.from = from;
    this.to = to;
  }

  public Route(String routeName, String from, String to, String[] stops) {
    this.routeName = routeName;
    this.from = from;
    this.to = to;
    this.stops = new String[stops.length];
    System.arraycopy(stops, 0, this.stops, 0, stops.length);
  }

  public String getRouteName() {
    return routeName;
  }

  public void setRouteName(String routeName) {
    this.routeName = routeName;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

}
