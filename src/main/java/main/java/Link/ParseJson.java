package main.java.Link;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.Iterator;

public class ParseJson {

    public static void parseObject(JSONObject json, String key) {
        //System.out.println(json.has(key));
        System.out.println(json.get(key));

    }

    public static void getKey(JSONObject json, String key) {


        boolean exist = json.has(key);
        Iterator<?> keys;
        String nextKey;


        if (!exist) {
            keys = json.keys();
            while (keys.hasNext()) {
                nextKey = (String) keys.next();
                try {
                    if (json.get(nextKey) instanceof JSONObject) {

                        if (exist == false) {
                            getKey(json.getJSONObject(nextKey), key);
                        }

                    } else if (json.get(nextKey) instanceof JSONArray) {
                        JSONArray jsonArray = json.getJSONArray(nextKey);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            String jsonArrayString = jsonArray.get(i).toString();
                            JSONObject innerJson = new JSONObject(jsonArrayString);
                            if (exist == false) {
                                getKey(innerJson, key);
                            }

                        }
                    }
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            }
        } else
            parseObject(json, key);


    }

    public static void main(String[] args) {
        String content = "{\n" +
                "\n" +
                "  \"fname\": \"abc\",\n" +
                "  \"lname\": \"xyz\",\n" +
                "  \"Country\": [\n" +
                "\n" +
                "    {\n" +
                "\n" +
                "      \"CountryDetails\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "          \"countryName\": \"India\",\n" +
                "          \"Address\": \"address1\",\n" +
                "          \"latitude\": 0.34342,\n" +
                "          \"longitude\": 9.93939\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "\n" +
                "      \"CountryDetails\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "          \"countryName\": \"UK\",\n" +
                "          \"Address\": \"address2\",\n" +
                "          \"latitude\": 0.34341,\n" +
                "          \"longitude\": 9.93839\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "\n" +
                "      \"CountryDetails\": [\n" +
                "\n" +
                "        {\n" +
                "\n" +
                "          \"countryName\": \"USA\",\n" +
                "          \"Address\": \"address3\",\n" +
                "          \"latitude\": 0.34300,\n" +
                "          \"longitude\": 9.93111\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject jsonObject = new JSONObject(content);

        getKey(jsonObject, "countryName");
    }
}
