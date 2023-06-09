package com.example.demo;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

  @Inject
  HelloService helloService;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello from RESTEasy Reactive";
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/polite/hello/{name}")
  public String hello(@PathParam("name") String name) {
    return helloService.politeHello(name);
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/polite/greeting/{name}")
  public String greeting(@PathParam("name") String name) {
    return helloService.politeGreeting(name);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/customers")
  public List<Customer> getCustomers() {
    return Customer.listAll();
  }
}