package learn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsExamples {

    @Test
    public void test1() {
        Response response = RestAssured.get("https://requres.in/api/users?page=2");
        System.out.println("Response = " + response.getStatusCode());
        System.out.println("Time = " + response.getTime());
        System.out.println("sessionID = " + response.getSessionId());
        System.out.println("Body = " + response.getBody().toString());

        Assert.assertEquals(response.getStatusCode(), 400);
    }
}