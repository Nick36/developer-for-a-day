package com.nttdata.weatherstation.entity;

public class WeatherData {

  private String stationName;
  private int temperature;
  private TemperatureUnit temperatureUnit;
  private Clouds clouds;

  public String getStationName() {
    return stationName;
  }

  public WeatherData withStationName(String stationName) {
    this.stationName = stationName;
    return this;
  }

  public int getTemperature() {
    return temperature;
  }

  public WeatherData withTemperature(int temperature) {
    this.temperature = temperature;
    return this;
  }

  public TemperatureUnit getTemperatureUnit() {
    return temperatureUnit;
  }

  public WeatherData withTemperatureUnit(TemperatureUnit temperatureUnit) {
    this.temperatureUnit = temperatureUnit;
    return this;
  }

  public Clouds getClouds() {
    return clouds;
  }

  public WeatherData withClouds(Clouds clouds) {
    this.clouds = clouds;
    return this;
  }

}
