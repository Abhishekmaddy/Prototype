package main.java.commonfunctions;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CommonFunctions {



    String content;
    JSONObject payloadObject;
    static WebDriver driver;

    public JSONObject getPayloadObjectContracts() {
        File file = new File("./src/test/resources/payloads/request_payloads.json");
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payloadObject = new JSONObject(content);
    }

    public static WebDriver getDriver(){
        if(driver == null){
            return null;
        }
        return driver;
    }

}
