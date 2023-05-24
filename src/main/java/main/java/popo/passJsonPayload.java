package main.java.popo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import main.files.payload;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class passJsonPayload {
     static String content;
     static JSONObject payloadObject;
     String response;

    @Test
    public void PostMethod() throws IOException {
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
                .body(payloadObject.getJSONObject("location_payload").toString())
                .when().post("maps/api/place/add/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();
        //System.out.println(response);
        JSONObject jsonObject = new JSONObject(response);
        //System.out.println(jsonObject);
        //JsonPath js = new JsonPath(response); //parsing json
        String placeId = jsonObject.getString("status");
        //Assert.assertTrue(placeId.contains("OK"));
        Assert.assertEquals("OK",placeId);
        //System.out.println(placeId);


        //Update Place




        //Get Method

//        String newAddress= "70 Summer walk, USA";
//        String getPlaceResponse = given().log().all().queryParam("key","qaclick123")
//                .queryParam("place_id",placeId)
//                .when().get("maps/api/place/get/json")
//                .then().assertThat().log().all().statusCode(200).extract().asString();
//        JSONObject getPlaceResponseJsonObject  = new JSONObject(getPlaceResponse);
//        String actualAddress = getPlaceResponseJsonObject.getString("address");


    }
}

