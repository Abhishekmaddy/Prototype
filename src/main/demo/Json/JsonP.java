package main.demo.Json;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import main.files.payload;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.*;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonP {
    String content;
    JSONObject payloadObject;

    public void JsonP() throws IOException {
        File file = new File("src/test/resources/payloads/json_parse.json");
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        payloadObject = new JSONObject(content);
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
        System.out.println(js+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        String placeId = js.getString("place_id");
        System.out.println(placeId);






//        JSONObject jsonObject = new JSONObject(content);
//        JSONArray countryArray = jsonObject.getJSONArray("Country");
//        for (Object countryObj : countryArray) {
//            JSONObject country = (JSONObject) countryObj;
//            JSONArray countryDetailsArray = country.getJSONArray("CountryDetails");
//            for (Object countryDetailsObj : countryDetailsArray) {
//                JSONObject countryDetails = (JSONObject) countryDetailsObj;
//
//                if (countryDetails.getString("countryName").equals("India")) {
//                    System.out.println("Address: " + countryDetails.getString("Address"));
//                    System.out.println("Latitude: " + countryDetails.getDouble("latitude"));
//                    System.out.println("Longitude: " + countryDetails.getDouble("longitude"));
//                }
//            }
//        }
//
//        String content = "{\n" +
//                "\n" +
//                "  \"fname\": \"abc\",\n" +
//                "  \"lname\": \"xyz\",\n" +
//                "  \"Country\": [\n" +
//                "\n" +
//                "    {\n" +
//                "\n" +
//                "      \"CountryDetails\": [\n" +
//                "\n" +
//                "        {\n" +
//                "\n" +
//                "          \"countryName\": \"India\",\n" +
//                "          \"Address\": \"address1\",\n" +
//                "          \"latitude\": 0.34342,\n" +
//                "          \"longitude\": 9.93939\n" +
//                "        }\n" +
//                "      ]\n" +
//                "    },\n" +
//                "    {\n" +
//                "\n" +
//                "      \"CountryDetails\": [\n" +
//                "\n" +
//                "        {\n" +
//                "\n" +
//                "          \"countryName\": \"UK\",\n" +
//                "          \"Address\": \"address2\",\n" +
//                "          \"latitude\": 0.34341,\n" +
//                "          \"longitude\": 9.93839\n" +
//                "        }\n" +
//                "      ]\n" +
//                "    },\n" +
//                "    {\n" +
//                "\n" +
//                "      \"CountryDetails\": [\n" +
//                "\n" +
//                "        {\n" +
//                "\n" +
//                "          \"countryName\": \"USA\",\n" +
//                "          \"Address\": \"address3\",\n" +
//                "          \"latitude\": 0.34300,\n" +
//                "          \"longitude\": 9.93111\n" +
//                "        }\n" +
//                "      ]\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";


//             JSONObject jsonObject = new JSONObject(content);
//             JSONArray countryArray=jsonObject.getJSONArray("Country");
//
//             for (Object countryDetails : countryArray){


//            for (int i = 0; i < countryArray.length(); i++) {
//                JSONArray countryDetailsArray = countryArray.getJSONObject(i).getJSONArray("CountryDetails");
//
//                for (int j = 0; j < countryDetailsArray.length(); j++) {
//                    JSONObject countryDetails = countryDetailsArray.getJSONObject(j);
//                    String countryName = countryDetails.getString("countryName");
//
//                    if (countryDetails.get("countryName").equals("India")) {
//                        System.out.println("Country name: " + countryDetails.getString("countryName"));
//                        System.out.println("Address: " + countryDetails.getString("Address"));
//                        System.out.println("Latitude: " + countryDetails.getDouble("latitude"));
//                        System.out.println("Longitude: " + countryDetails.getDouble("longitude"));
//                    }
//                }
//            }
    }
}

