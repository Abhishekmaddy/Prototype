package test.book;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;

//public class restAssuredMethod {
//
//    String  content;
//    JSONObject payload;
//
//    @Test
//    public void PostMethod () throws IOException {
//        File file = new File("/src/test/resources/body.json");
//
//        try{
//            content = FileUtils.readFileToString(file, "utf-8");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        payload = new JSONObject(content);
//
//        String response = given().log().all()
//                .queryParam("--", "--")
//                .headers("Content-Type", "application/json")
//			    .body(content)
//
//                .when().post("application/customer/v1")
//
//                .then().log().all()
//                .assertThat()
//                .statusCode(200)
//                .body("scope",  equalTo("adfg"))
//                .headers("","")
//                .extract().response().asString();
//
//        JSONObject jsonResponse = new JSONObject(response);
//        String status = jsonResponse.getString("status");
//        System.out.println(status);
//
//
//    }
//}

import java.io.File;
import java.io.IOException;

public class ParseKeyValue {
    String content;
    JSONObject payloadObject;


    public ParseKeyValue() throws IOException{
        File file = new File("src/test/resources/payloads/request_payloads.json");
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        payloadObject = new JSONObject(content);
    }

}
