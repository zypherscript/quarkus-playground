package com.example.demo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer extends PanacheEntity {

  @NotBlank(message = "Name may not be blank")
  public String name;
}
