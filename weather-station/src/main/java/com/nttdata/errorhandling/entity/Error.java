package com.nttdata.errorhandling.entity;

import java.util.Objects;

public class Error {

  private final String errorCode;
  private final String errorMessage;

  public Error(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  @Override
  public String toString() {
    return "Error{" +
        "errorCode='" + errorCode + '\'' +
        ", errorMessage='" + errorMessage + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Error error = (Error) o;
    return Objects.equals(errorCode, error.errorCode) && Objects.equals(errorMessage, error.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, errorMessage);
  }
}
