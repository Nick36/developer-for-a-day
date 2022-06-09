package com.nttdata.weathermap.control;

import com.nttdata.errorhandling.entity.WeatherMapException;
import com.nttdata.integration.weatherstation.boundary.WeatherStationApi;
import com.nttdata.integration.weatherstation.entity.TemperatureUnit;
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

  private static final double CELSIUS_TO_FAHRENHEIT_MULTIPLICAND = 1.8;
  private static final int CELSIUS_TO_FAHRENHEIT_ADDEND = 32;

  public WeatherMap collectDataFromStation(TemperatureUnit temperatureUnit) {
    try {
      WeatherMap map = new WeatherMap();
      for (String station : weatherStationApi.getStations()) {
        WeatherData weatherData = weatherStationApi.getWeatherData(station);

        if (temperatureUnit.equals(TemperatureUnit.CELSIUS) && weatherData.getTemperatureUnit().equals(TemperatureUnit.FAHRENHEIT)) {
          int celsiusTemperature = convertFahrenheitToCelsius(weatherData.getTemperature());
          weatherData.withTemperature(celsiusTemperature).withTemperatureUnit(TemperatureUnit.CELSIUS);
        }
        if (temperatureUnit.equals(TemperatureUnit.FAHRENHEIT) && weatherData.getTemperatureUnit().equals(TemperatureUnit.CELSIUS)) {
          int fahrenheitTemperature = convertCelsiusToFahrenheit(weatherData.getTemperature());
          weatherData.withTemperature(fahrenheitTemperature).withTemperatureUnit(TemperatureUnit.FAHRENHEIT);
        }

        map.getWeatherStations().add(weatherData);
      }

      return map;
    } catch (Exception e) {
      throw new WeatherMapException(WEATHER_STATION_EXTERNAL_ERROR, "error calling the weather station api", e);
    }
  }

  private int convertFahrenheitToCelsius(int celsiusTemperature) {
    return (int) Math.round((celsiusTemperature - CELSIUS_TO_FAHRENHEIT_ADDEND) / CELSIUS_TO_FAHRENHEIT_MULTIPLICAND);
  }

  private int convertCelsiusToFahrenheit(int fahrenheitTemperature) {
    return (int) Math.round(CELSIUS_TO_FAHRENHEIT_MULTIPLICAND * fahrenheitTemperature) + CELSIUS_TO_FAHRENHEIT_ADDEND;
  }

}
