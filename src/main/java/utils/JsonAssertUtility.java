package main.java.utils;

import org.json.JSONObject;

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

    public void assertKeyValuePairInEntireJson(JSONObject actualJson, Object key, String expectedValue) {
        boolean exists = actualJson.has(key.toString());
        Iterator<?> keys;
        String nextKey;



    }

}
