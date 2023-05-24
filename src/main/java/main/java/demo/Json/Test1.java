package demo.Json;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import main.files.payload;

public class Test1 {
    public static void main(String[] args) {

        //given : input all the details
        //when : submit the Api, resource, Http method
        //then : validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.AddPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat()
                                    .statusCode(200)
                                    .body("scope", equalTo("APP"))
                                    .header("server", "Apache/2.4.41 (Ubuntu)")
                                    .extract().response().asString();
        System.out.println(response);

        JsonPath jp = new JsonPath(response);
        String place_id = jp.getString("place_id");
        System.out.println(place_id);
    }
}
