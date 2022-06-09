package com.nttdata.weatherstation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Table(name = "t_station")
@Entity
public class Station extends PanacheEntity {

  private String name;

  public String getName() {
    return name;
  }

  public Station withName(String name) {
    this.name = name;
    return this;
  }
}
