package test.book;

import main.java.utils.JsonAssertUtility;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

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
