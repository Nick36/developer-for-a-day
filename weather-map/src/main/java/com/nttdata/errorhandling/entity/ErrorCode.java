package com.nttdata.errorhandling.entity;

public enum ErrorCode {

  INVALID_PARAMETER(400),
  BAD_REQUEST(400),
  INTERNAL_SERVER_ERROR(500),
  WEATHER_STATION_EXTERNAL_ERROR(500);

  private final int httpStatusCode;

  ErrorCode(int httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public int getHttpStatusCode() {
    return httpStatusCode;
  }

  @Override
  public String toString() {
    return "ErrorCode{" + "errorMessage='" + name() + '\'' + ", httpStatusCode=" + httpStatusCode + '}';
  }

}
