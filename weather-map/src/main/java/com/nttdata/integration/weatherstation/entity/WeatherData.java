package com.nttdata.integration.weatherstation.entity;

public class WeatherData {

  private String stationName;
  private int temperature;
  private TemperatureUnit temperatureUnit;
  private Clouds clouds;

  public String getStationName() {
    return stationName;
  }

  public int getTemperature() {
    return temperature;
  }

  public TemperatureUnit getTemperatureUnit() {
    return temperatureUnit;
  }

  public Clouds getClouds() {
    return clouds;
  }

}
