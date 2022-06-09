package com.nttdata.errorhandling.boundary;

import com.nttdata.errorhandling.control.ErrorHandler;
import com.nttdata.errorhandling.entity.ErrorCode;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

  @Inject
  ErrorHandler errorHandler;

  @Override
  public Response toResponse(final WebApplicationException ex) {
    if (ex.getResponse().getStatus() < 500) {
      return errorHandler.handle(ErrorCode.BAD_REQUEST, "Code: " + ex.getResponse().getStatus() + ", Message: " + ex.getMessage(), ex);
    }
    return errorHandler.handle(ErrorCode.INTERNAL_SERVER_ERROR, "Code: " + ex.getResponse().getStatus() + ", Message: " + ex.getMessage(),
        ex);
  }
}
