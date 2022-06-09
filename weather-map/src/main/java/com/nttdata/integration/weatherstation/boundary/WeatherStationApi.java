package com.nttdata.integration.weatherstation.boundary;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.nttdata.integration.weatherstation.control.WeatherStationApiExceptionMapper;
import com.nttdata.integration.weatherstation.entity.WeatherData;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api")
@ApplicationScoped
@RegisterRestClient(configKey = "weather-station.client-api")
@RegisterProvider(WeatherStationApiExceptionMapper.class)
@Produces("application/json")
public interface WeatherStationApi {
  @GET
  @Path("weather/{stationName}")
  WeatherData getWeatherData(@PathParam("stationName") String stationName);

  @GET
  @Path("station")
  List<String> getStations();
}
