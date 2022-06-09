package com.nttdata.weathermap.control;

import com.nttdata.errorhandling.entity.WeatherMapException;
import com.nttdata.integration.weatherstation.boundary.WeatherStationApi;
import com.nttdata.integration.weatherstation.entity.WeatherData;
import com.nttdata.weathermap.entity.WeatherMap;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static com.nttdata.errorhandling.entity.ErrorCode.WEATHER_STATION_EXTERNAL_ERROR;

@ApplicationScoped
public class WeatherCollector {

  @Inject
  @RestClient
  WeatherStationApi weatherStationApi;

  public WeatherMap collectDataFromStation () {
    try {
      WeatherMap map = new WeatherMap();
      for (String station : weatherStationApi.getStations()) {
        WeatherData weatherData = weatherStationApi.getWeatherData(station);
        map.getWeatherStations().add(weatherData);
      }
      return map;
    } catch (Exception e) {
      throw new WeatherMapException(WEATHER_STATION_EXTERNAL_ERROR, "error calling the weather station api", e);
    }
  }

}
