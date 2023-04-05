package main.java.utils;

import main.java.utils.listners.Logger;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class JsonAssertUtility {

    Map jsonElementsInHashMap = new HashMap<>();
    int count = 0;
    String content;
    JSONObject payloadObject;
    UUID uuid;

    public JsonAssertUtility() throws IOException {
        File file = new File("./src/test/resources/clm/responsecontracts/response_contracts.json");
        content = FileUtils.readFileToString(file, "utf-8");
        payloadObject = new JSONObject(content);
        uuid = UUID.randomUUID();
    }

    public void verifyKeyPresentInJson(JSONObject json, Object key) {
        boolean has = json.has(key.toString());
        if (has) {
            Logger.log(key + ": Present");
            count++;
        }
    }

    public void assertKeyValue(JSONObject actualJson, Object key, String expectedValue) {
        if (actualJson.get(key.toString()) != "null") {
            String str = "" + actualJson.get(key.toString());
            boolean has = actualJson.has(key.toString());
            if (has) {
                Assert.assertEquals(str, expectedValue, "JSON Values are not matched");
            }
        }
    }

    public void assertKeyValuePairInEntireJson(JSONObject actualJson, Object key, String expectedValue) {
        boolean exists = actualJson.has(key.toString());
        Iterator<?> keys;
        String nextKeys;

        if (!exists) {
            keys = actualJson.keys();
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {// if the object is json object
                    if (actualJson.get(nextKeys) instanceof JSONObject) {
                        // Recursive call
                        assertKeyValuePairInEntireJson(actualJson.getJSONObject(nextKeys), key, expectedValue);
                        // if the object is json array
                    } else if (actualJson.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = actualJson.getJSONArray(nextKeys);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            String jsonArrayString = jsonarray.get(i).toString();
                            try {// if the object is json array
                                if (new JSONObject(jsonArrayString) instanceof JSONObject) {
                                    JSONObject innerJSOn = new JSONObject(jsonArrayString);
                                    // Recursive call
                                    assertKeyValuePairInEntireJson(innerJSOn, key, expectedValue);
                                }
                            } catch (JSONException jx) {
                                // Do nothing - if the JSONArray String is not json will get JSON EXCEPTION
                            }
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.log("Something went wrong while parsing the JSON");
                }

            }

        } else {
            assertKeyValue(actualJson, key, expectedValue);
        }

    }

    public void searchKeyInEntireJson(JSONObject actualJson, Object key){
        boolean exists=actualJson.has(key.toString());
        Iterator<?> keys;
        String nextKeys;

        if (!exists){
            keys = actualJson.keys();
            while (keys.hasNext()){
                nextKeys =(String)keys.next();
                try {//if the object is json object
                    if (actualJson.get(nextKeys) instanceof JSONObject) {
                        //Recursive call
                        searchKeyInEntireJson(actualJson.getJSONObject(nextKeys), key);
                    } //if object is json array
                    else if (actualJson.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = actualJson.getJSONArray(nextKeys);
                        for (int i = 0; i<jsonarray.length(); i++){
                            String jsonArrayString = jsonarray.get(i).toString();
                            try {
                                //if the JSON Array has inner JSON Object
                                if (new JSONObject(jsonArrayString) instanceof JSONObject) {
                                    JSONObject innerJSOn = new JSONObject(jsonArrayString);
                                    //Recursive call
                                    searchKeyInEntireJson(innerJSOn, key);
                                }
                            }catch (JSONException jx){
                                // Do nothing - if the JSONArray String is not json will get JSON EXCEPTION
                            }
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    Logger.log("Something went wrong");
                }
            }
        } else {
            verifyKeyPresentInJson(actualJson, key);
        }
    }
}


