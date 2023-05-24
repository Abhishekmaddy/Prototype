package main.java.commonfunctions;

import main.java.books.actions.BooksActions;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiCommonFunctions {
    static String content;
    static JSONObject payloadObject;


    public ApiCommonFunctions(){
        File file = new File("src/test/resources/payloads/request_payloads.json");
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Creates request payload by assigning values sent from the test class


    //CreateBook
    public void createBookPost(HashMap<String, String> hm, Map<String, String> requestHeaders) throws IOException {
        JSONObject createBookRequestPayload=payloadObject.getJSONObject("createBookPayload");
        setPayloadValue(hm, createBookRequestPayload);
        JSONObject createBookResponseJSON = new JSONObject
                (BooksActions.createBook(createBookRequestPayload.toString(),requestHeaders));
        Assert.assertEquals(createBookResponseJSON.getInt("statusCode"), "200", "Status code is other than 200");
    }

    public synchronized JSONObject setPayloadValue(HashMap<String, String> hm, JSONObject requestPayload) {
        for (String key : hm.keySet()) {
            requestPayload.put(key, hm.get(key));
        }
        return requestPayload;
    }

}
