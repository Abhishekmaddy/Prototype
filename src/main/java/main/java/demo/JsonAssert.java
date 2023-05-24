package demo;


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

public class JsonAssert {


    private static int count= 0;
    Map jsonElementsInHashMap = new HashMap<>();
    //int count = 0;
    String content;
    JSONObject payloadObject;
    UUID uuid;
    public JsonAssert() throws IOException {
        File file = new File("./src/test/resources/clm/responsecontracts/response_contracts.json");
        content = FileUtils.readFileToString(file, "utf-8");
        payloadObject = new JSONObject(content);
        uuid = UUID.randomUUID();
    }

    public static void verifyKeyPresentInJson(JSONObject json, Object key) {
        System.out.println(json.get(key.toString()));
    }

    public static void assertKeyValue(JSONObject actualJson, Object key, String expectedValue) {
        if (actualJson.get(key.toString()) != "null") {
            String str = "" + actualJson.get(key.toString());
            boolean has = actualJson.has(key.toString());
            if (has) {
                Assert.assertEquals(str, expectedValue, "JSON Values are not matched");
            }
        }
    }

    public static void searchKeyInEntireJson(JSONObject actualJson, Object key) {
        boolean exists = actualJson.has(key.toString());
        Iterator<?> keys;
        String nextKeys;

        if (!exists) {
            keys = actualJson.keys();
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {//if the object is json object
                    if (actualJson.get(nextKeys) instanceof org.json.JSONObject) {
                        //Recursive call
                        searchKeyInEntireJson(actualJson.getJSONObject(nextKeys), key);
                    } //if object is json array
                    else if (actualJson.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = actualJson.getJSONArray(nextKeys);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            String jsonArrayString = jsonarray.get(i).toString();
                            try {
                                //if the JSON Array has inner JSON Object
                                if (new org.json.JSONObject(jsonArrayString) instanceof org.json.JSONObject) {
                                    org.json.JSONObject innerJSOn = new JSONObject(jsonArrayString);
                                    //Recursive call
                                    searchKeyInEntireJson(innerJSOn, key);
                                }
                            } catch (JSONException jx) {
                                // Do nothing - if the JSONArray String is not json will get JSON EXCEPTION
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.log("Something went wrong");
                }
            }
        } else {
            verifyKeyPresentInJson(actualJson, key);
        }



    }

    public static void main (String[]args) throws IOException {

        String input = "{\n" +
                "\t\"problems\": [{\n" +
                "\t\t\"Diabetes\": [{\n" +
                "\t\t\t\"medications\": [{\n" +
                "\t\t\t\t\"medicationsClasses\": [{\n" +
                "\t\t\t\t\t\"className\": [{\n" +
                "\t\t\t\t\t\t\"associatedDrug\": [{\n" +
                "\t\t\t\t\t\t\t\"name\": \"asprin\",\n" +
                "\t\t\t\t\t\t\t\"dose\": \"\",\n" +
                "\t\t\t\t\t\t\t\"strength\": \"500 mg\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"associatedDrug#2\": [{\n" +
                "\t\t\t\t\t\t\t\"name\": \"somethingElse\",\n" +
                "\t\t\t\t\t\t\t\"dose\": \"\",\n" +
                "\t\t\t\t\t\t\t\"strength\": \"500 mg\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\"className2\": [{\n" +
                "\t\t\t\t\t\t\"associatedDrug\": [{\n" +
                "\t\t\t\t\t\t\t\"name\": \"asprin\",\n" +
                "\t\t\t\t\t\t\t\"dose\": \"\",\n" +
                "\t\t\t\t\t\t\t\"strength\": \"500 mg\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"associatedDrug#2\": [{\n" +
                "\t\t\t\t\t\t\t\"name\": \"somethingElse\",\n" +
                "\t\t\t\t\t\t\t\"dose\": \"\",\n" +
                "\t\t\t\t\t\t\t\"strength\": \"500 mg\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t}]\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"labs\": [{\n" +
                "\t\t\t\t\"missing_field\": \"missing_value\"\n" +
                "\t\t\t}]\n" +
                "\t\t}],\n" +
                "\t\t\"Asthma\": [{}]\n" +
                "\t}]\n" +
                "}";


        JSONObject inputJsonObject = new JSONObject(input);
        JsonAssert jsonAssertUtility = new JsonAssert();
        jsonAssertUtility.verifyKeyPresentInJson(inputJsonObject,"className");

    }
}
