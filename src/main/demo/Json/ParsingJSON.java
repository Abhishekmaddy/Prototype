package main.demo.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsingJSON {

    public static void main(String[] args) {
        String jsonString = "{ \"fname\":\"abc\", \"lname\":\"xyz\", \"Country\":[ { \"CountryDetails\":[ { \"countryName\":\"India\", \"Address\":\"xyz\", \"latitude\":0.34342, \"longitude\":9.93939 } ] }, { \"CountryDetails\":[ { \"countryName\":\"UK\", \"Address\":\"address2\", \"latitude\":0.34341, \"longitude\":9.93839 } ] }, { \"CountryDetails\":[ { \"countryName\":\"USA\", \"Address\":\"address3\", \"latitude\":0.34300, \"longitude\":9.93111 } ] } ] }";

        try {
//            JSONObject jsonObject = new JSONObject(jsonString);
//            JSONArray countryArray = jsonObject.getJSONArray("Country");
//
//            for (int i = 0; i < countryArray.length(); i++) {
//                JSONObject country = countryArray.getJSONObject(i);
//                JSONArray countryDetailsArray = country.getJSONArray("CountryDetails");
//
//                for (int j = 0; j < countryDetailsArray.length(); j++) {
//                    JSONObject countryDetails = countryDetailsArray.getJSONObject(j);
//                    String countryName = countryDetails.getString("countryName");
//
//                    if (countryName.equals("India")) {
//                        String address = countryDetails.getString("Address");
//                        double latitude = countryDetails.getDouble("latitude");
//                        double longitude = countryDetails.getDouble("longitude");
//                        System.out.println("Country name: " + countryName);
//                        System.out.println("Address: " + address);
//                        System.out.println("Latitude: " + latitude);
//                        System.out.println("Longitude: " + longitude);
//                    }
//                }


        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray countryArray = jsonObject.getJSONArray("Country");
        for (Object countryObj : countryArray) {
            JSONObject country = (JSONObject) countryObj;
            JSONArray countryDetailsArray = country.getJSONArray("CountryDetails");
            for (Object countryDetailsObj : countryDetailsArray) {
                JSONObject countryDetails = (JSONObject) countryDetailsObj;

                if (countryDetails.getString("countryName").equals("India")) {
                    System.out.println("Address: " + countryDetails.getString("Address"));
                    System.out.println("Latitude: " + countryDetails.getDouble("latitude"));
                    System.out.println("Longitude: " + countryDetails.getDouble("longitude"));
                }
            }
        }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
