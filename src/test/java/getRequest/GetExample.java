package getRequest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetExample {
    RestAssured restAssured = new RestAssured();

    @Test
    public void test1() {
        RestAssured.get("");
    }
}
