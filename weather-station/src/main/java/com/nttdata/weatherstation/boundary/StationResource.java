package com.nttdata.weatherstation.boundary;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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

  @GET
  @Path("/station/{stationId}")
  @Produces("application/json")
  public Response get(@PathParam("stationId") long stationId) {
    Station station = Station.findById(stationId);
    if (station != null) {
      return Response.ok(station).build();
    }
    return Response.status(Response.Status.NOT_FOUND).build();
  }

  @POST
  @Path("/station/{stationName}")
  @Produces("application/json")
  @Transactional
  public Response create(@PathParam("stationName") String stationName) {
    Station station = new Station().withName(stationName);
    station.persist();
    return Response.created(URI.create("/station/" + station.id)).entity(station).build();
  }

  @DELETE
  @Path("/station/{stationName}")
  @Transactional
  public Response delete(@PathParam("stationName") String stationName) {
    Station station = Station.findByName(stationName);
    if (station != null && station.isPersistent()) {
      station.delete();
      return Response.noContent().build();
    }
    return Response.status(Response.Status.NOT_FOUND).build();
  }

  @DELETE
  @Path("/station")
  @Transactional
  public void deleteAll() {
    Station.deleteAll();
  }

}
