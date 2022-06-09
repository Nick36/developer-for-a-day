package com.nttdata.weathermap.entity;

import com.nttdata.integration.weatherstation.entity.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class WeatherMap {
  private List<WeatherData> weatherStations = new ArrayList<>();

  public List<WeatherData> getWeatherStations() {
    return weatherStations;
  }
}
