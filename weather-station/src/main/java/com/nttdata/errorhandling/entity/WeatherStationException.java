package com.nttdata.errorhandling.entity;

public class WeatherStationException extends RuntimeException {

  private final ErrorCode errorCode;

  public WeatherStationException(ErrorCode errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public WeatherStationException(ErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}
