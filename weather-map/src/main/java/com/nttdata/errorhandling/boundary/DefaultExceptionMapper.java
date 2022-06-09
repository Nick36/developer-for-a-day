package com.nttdata.errorhandling.boundary;

import com.nttdata.errorhandling.control.ErrorHandler;
import com.nttdata.errorhandling.entity.ErrorCode;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

  @Inject
  ErrorHandler errorHandler;

  @Override
  public Response toResponse(final Exception ex) {
    return errorHandler.handle(ErrorCode.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
  }
}
