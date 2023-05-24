package main.files;

public class payload {

    public static String AddPlace(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";

    }

    public static String UpdatePlace(){

        return "{\n" +
                "\"place_id\":\"788968f65a99aa0c45d3308e4b6dc76e\",\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";


    }
}
