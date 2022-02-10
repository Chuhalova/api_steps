package io.cucumber.skeleton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import resources.TestDataBuild;
import resources.Utils;

import java.io.*;

import static io.restassured.RestAssured.given;

public class StepDefinitions {
    RequestSpecification requestSpecification_1;

    ResponseSpecification responseSpecBuilder;

    Response response;


    @When("user calls {string} with post http request")
    public void userCallsWithPostHttpRequest(String arg0) {
        response =
            requestSpecification_1.when().post("maps/api/place/add/json").then().spec(responseSpecBuilder).extract()
                                  .response();
    }

    @Then("the API call is success with status code {int}")
    public void theAPICallIsSuccessWithStatusCode(int expactedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expactedStatusCode);
    }

    @And("{string} in response is {string}")
    public void inResponseIs(String field, String expectedValue) {
        String res = response.asString();
        JsonPath jsonPath = new JsonPath(res);
        String result = jsonPath.getString(field);
        Assert.assertEquals(result, expectedValue);
    }

    @Given("Add place payload {string} {string} <{string}>")
    public void addPlacePayload(String name, String location, String address) throws IOException {
        RequestSpecification requestSpecification = Utils.getRequestSpecification();

        responseSpecBuilder =
            new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        requestSpecification_1 =
            given().spec(requestSpecification).body(TestDataBuild.addPlacePayload(name, location, address));
    }
}
