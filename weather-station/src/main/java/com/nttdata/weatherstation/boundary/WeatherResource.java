package com.nttdata.weatherstation.boundary;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.nttdata.weatherstation.control.WeatherCalculator;
import com.nttdata.weatherstation.entity.WeatherData;

@Path("/api/weather")
@ApplicationScoped
public class WeatherResource {

  @Inject
  WeatherCalculator calculator;

  @GET
  @Path("{stationName}")
  public WeatherData getWeatherData(@PathParam("stationName") String stationName) {
    return calculator.calculateWeather(stationName);
  }

}
