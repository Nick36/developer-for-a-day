package com.nttdata.weathermap.control;

import com.nttdata.weathermap.entity.WeatherMap;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WeatherCollector {

  public WeatherMap collectDataFromStation () {
    return new WeatherMap();
  }

}
