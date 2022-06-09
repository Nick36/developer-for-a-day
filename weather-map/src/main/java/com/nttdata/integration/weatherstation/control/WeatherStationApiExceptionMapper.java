package com.nttdata.integration.weatherstation.control;

import com.nttdata.errorhandling.entity.WeatherMapException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import static com.nttdata.errorhandling.entity.ErrorCode.WEATHER_STATION_EXTERNAL_ERROR;

public class WeatherStationApiExceptionMapper implements ResponseExceptionMapper<Exception> {

  @Override
  public Exception toThrowable(Response response) {
    if (response.getStatus() < 500) {
      String responseContent = response.readEntity(String.class);
      return new WeatherMapException(WEATHER_STATION_EXTERNAL_ERROR, responseContent);
    }
    return new WeatherMapException(WEATHER_STATION_EXTERNAL_ERROR, "weather station returned http code " + response.getStatus());
  }

  @Override
  public boolean handles(int status, MultivaluedMap<String, Object> headers) {
    return status >= 400;
  }
}
