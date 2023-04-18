package com.example.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class HelloResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
        .when().get("/hello")
        .then()
        .statusCode(200)
        .body(is("Hello from RESTEasy Reactive"));
  }

  @Test
  public void testPoliteHelloEndpoint() {
    given()
        .when().get("hello/polite/hello/{name}", "G")
        .then()
        .statusCode(200)
        .body(is("Hello Mr/Mrs G"));
  }

  @Test
  public void testPoliteGreetingEndpoint() {
    given()
        .pathParam("name", "G")
        .when().get("/hello/polite/greeting/{name}")
        .then()
        .statusCode(200)
        .body(is("Good morning G"));
  }

}