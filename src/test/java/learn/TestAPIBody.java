package learn;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class TestAPIBody {

    // @Test
    void demo_API_BodyValidationTest() {

        // check only one value
//        given().get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200)
//                .body("data.first_name[2]",equalTo("Tobias"));

        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.first_name", hasItems("George", "Michael", "Rachel"))
                //this is to get all the response like headers status and all the response.
                .log().all();

    }


    // Create a function which will save first name and last name from the api response and save it into the map

    @Test
    public void getNamesFromAPI() {

        Response response = get("https://reqres.in/api/users?page=2");

        // Convert response body to JSONPath
        JsonPath jsonPath = response.jsonPath();

        // Extract user details list
        List<Map<String, Object>> users = jsonPath.getList("data");

        // Create a map to store first name and last name
        Map<String, String> nameMap = new HashMap<String, String>();
        String firstName, lastName;

        for (Map<String, Object> user : users) {
            firstName = (String) user.get("first_name");
            lastName = (String) user.get("last_name");
            nameMap.put(firstName, lastName);
        }

        System.out.println(nameMap);
    }

}
