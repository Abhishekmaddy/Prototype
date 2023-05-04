package test.book;

import io.qameta.allure.Description;
import main.demo.Json.JsonP;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class JsonParsonNewMethod {
    String content;
    JSONObject payloadObject;

    public JsonParsonNewMethod() throws JSONException {
        File file = new File("src/test/resources/payloads/json_parse.json");
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        payloadObject = new JSONObject(content);
    }

    @Test
    @Description("HH")
    public static void verifyObject() throws Exception {
        JsonP p = new JsonP();
        p.JsonP();


    }
}
