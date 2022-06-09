package com.nttdata.weathermap.boundary;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.nttdata.integration.weatherstation.entity.TemperatureUnit;
import com.nttdata.weathermap.control.WeatherCollector;
import com.nttdata.weathermap.entity.WeatherMap;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/api")
public class WeatherMapResource {

  @Inject
  WeatherCollector collector;

  @GET
  @Path("map")
  @Produces("application/json")
  @Operation(summary = "Get weather data in a specific temperature unit")
  @APIResponseSchema(
      value = WeatherMap.class,
      responseDescription = "Weather data in the requested temperature unit",
      responseCode = "200")
  @APIResponses(value = {
      @APIResponse(description = "Invalid parameter", responseCode = "400", content = @Content(
          schema = @Schema(
              type = SchemaType.OBJECT,
              implementation = com.nttdata.errorhandling.entity.Error.class))),
      @APIResponse(description = "Internal server error", responseCode = "500", content = @Content(
          schema = @Schema(
              type = SchemaType.OBJECT,
              implementation = com.nttdata.errorhandling.entity.Error.class)))
  })
  public WeatherMap getWeatherData (@QueryParam("temperatureUnit") @NotNull(message = "temperatureUnit may not be null") @NotEmpty(message = "temperatureUnit may not be empty") String temperatureUnit) {
    return collector.collectDataFromStation(TemperatureUnit.valueOfName(temperatureUnit));
  }

}
