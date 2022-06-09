package com.nttdata.errorhandling.entity;

public class WeatherMapException extends RuntimeException {

  private final ErrorCode errorCode;

  public WeatherMapException(ErrorCode errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public WeatherMapException(ErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}
