package com.nttdata.weatherstation.boundary;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.nttdata.weatherstation.entity.Station;

@Path("/api")
@ApplicationScoped
public class StationResource {

  @GET
  @Path("station")
  @Produces("application/json")
  public List<String> findAll() {
    return Station.findAll().list().stream().map(s -> ((Station) s).getName()).collect(Collectors.toList());
  }

}
