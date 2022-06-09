package com.nttdata.weatherstation.control;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import com.nttdata.weatherstation.entity.Clouds;
import com.nttdata.weatherstation.entity.TemperatureUnit;
import com.nttdata.weatherstation.entity.WeatherData;

@ApplicationScoped
public class WeatherCalculator {

  Random rnd = new Random(System.currentTimeMillis());

  public WeatherData calculateWeather(String stationName) {
    return new WeatherData().withTemperature(calculateTemperature())
        .withClouds(calculateClouds())
        .withTemperatureUnit(rnd.nextInt(2) > 0 ? TemperatureUnit.CELSIUS : TemperatureUnit.FAHRENHEIT)
        .withStationName(stationName);
  }

  private Clouds calculateClouds() {
    Clouds[] clouds = Clouds.values();
    int index = rnd.nextInt(clouds.length);
    return clouds[index];
  }

  int calculateTemperature() {
    return (int) (20.0 + 20.0 * rnd.nextInt(100) / 100.0);
  }
}
