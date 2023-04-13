package com.example.demo;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class HelloService {

  @ConfigProperty(name = "greeting")
  private String greeting;

  public String politeHello(String name) {
    return "Hello Mr/Mrs " + name;
  }

  public String politeGreeting(String name) {
    return greeting + " " + name;
  }
}
