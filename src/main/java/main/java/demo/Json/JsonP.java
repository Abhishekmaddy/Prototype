package main.java.demo.Json;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import main.files.payload;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonP {
    String content;
    JSONObject payloadObject;
    String response;
    public void JsonP() throws IOException {
        File file = new File("src/test/resources/payloads/request_payloads.json");
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        payloadObject = new JSONObject(content);
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(content)
                .when().post("maps/api/place/add/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response); //parsing json
        String placeId = js.getString("place_id");
        System.out.println(placeId);

    }
}

