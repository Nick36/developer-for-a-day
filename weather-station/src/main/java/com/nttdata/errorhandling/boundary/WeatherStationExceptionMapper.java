package com.nttdata.errorhandling.boundary;

import com.nttdata.errorhandling.control.ErrorHandler;
import com.nttdata.errorhandling.entity.WeatherStationException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WeatherStationExceptionMapper implements ExceptionMapper<WeatherStationException> {

  @Inject
  ErrorHandler errorHandler;

  @Override
  public Response toResponse(final WeatherStationException ex) {
    return errorHandler.handle(ex.getErrorCode(), ex.getMessage(), ex);
  }
}
