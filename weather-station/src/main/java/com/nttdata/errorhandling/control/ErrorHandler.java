package com.nttdata.errorhandling.control;

import com.nttdata.errorhandling.entity.ErrorCode;
import com.nttdata.errorhandling.entity.Error;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class ErrorHandler {

  private static final Logger LOGGER = Logger.getLogger(ErrorHandler.class);

  public Response handle(final ErrorCode errorCode, final String errorMessage, final Throwable cause) {

    Error error = new Error(errorCode.name(), errorMessage);
    LOGGER.error(errorMessage, cause);

    return Response.status(errorCode.getHttpStatusCode())
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .entity(error)
        .build();
  }
}
