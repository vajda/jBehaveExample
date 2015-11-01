package com.vajda.jbehaveexample.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

/**
 * @author Vladimir Vajda
 */
public class ExampleSteps {
    
    String name;
    Response response;

    @Given("name is $name")
    public void givenNameIsX(@Named("name") String name) {
        this.name = name;
    }
 
    @When("I access greeting path with name")
    public void IAccessGreetingPathWithName() throws MalformedURLException {
        response = RestAssured.get(new URL("http://localhost:8080/greeting/" + name));
    }
 
    @Then("response body should be $body")
    public void thenResponseBodyShouldBeX(@Named("body") String body) {
        response.body().asString().equals(body);
    }
}
