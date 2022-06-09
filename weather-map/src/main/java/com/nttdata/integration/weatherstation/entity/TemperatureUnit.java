package com.nttdata.integration.weatherstation.entity;

public enum TemperatureUnit {
    CELSIUS,
    FAHRENHEIT;

  public static TemperatureUnit valueOfName(String name) {
    try {
      return valueOf(name.toUpperCase());
    } catch (IllegalArgumentException e) {
      return CELSIUS;
    }
  }
}
