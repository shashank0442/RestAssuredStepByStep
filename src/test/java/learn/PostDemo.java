package learn;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostDemo {

    // post api https://reqres.in/api/users
    @Test
    void post_Demo() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","Shashank");
//        map.put("job","SDET");
//        System.out.println(map);

        // JSON Object is converting map into the jSON format
        JSONObject req = new JSONObject();
        req.put("name", "Shashank");
        req.put("job", "SDET");
        System.out.println(req);

        given()
                .body(req.toJSONString())
                .when()
                .post(" https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

}
