package com.nttdata.weathermap.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.nttdata.weathermap.control.WeatherCollector;
import com.nttdata.weathermap.entity.WeatherMap;

@Path("/api")
public class WeatherMapResource {

  @Inject
  WeatherCollector collector;

  @GET
  @Path("map")
  @Produces("application/json")
  public WeatherMap getWeatherData () {
    return collector.collectDataFromStation();
  }

}
