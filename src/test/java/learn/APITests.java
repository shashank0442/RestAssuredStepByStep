package learn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {
    // Below are the two ways to write rest assured tests.
    @Test
    void Test1() {

        // get request example
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response : " + response.asString());
        System.out.println("StatusCode: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());

        System.out.println("Header: " + response.header("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Test Failed: Status Code not correct");


    }

    @Test
    void BDDStyleTest() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }


}
