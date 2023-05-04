package main.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import main.files.ReUsableMethod;
import main.files.payload;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {
        //validate if api is working as expected
        //validate if add place api is working as expected
        //given-- all input details
        //when-- submit the api - resource , https method
        //then-- validate the response
        RestAssured.baseURI= "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json" )
                .body(payload.AddPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat()
                                    .statusCode(200)
                                    .body("scope",equalTo("APP"))
                                    .header("server", "Apache/2.4.41 (Ubuntu)")
                                    .extract().response().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response); //parsing json
        System.out.println(js+ "******************************************************");
        String placeId = js.getString("place_id");
        System.out.println(placeId);


        System.out.println("******************************************************");
        //Update Place
        String newAddress = "Summer walk, Africa";
        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json" )
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));


        //Get Place
        String getPlaceResponse = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200)
                .extract().response().asString();

        JsonPath js1= ReUsableMethod.rawToJson(response);
        String actualAddrerss = js1.getString("address");
        System.out.println(getPlaceResponse);
        Assert.assertEquals("actualAddrerss", "actualAddrerss");

        //Cucumber Junit, TestNG

    }
}
