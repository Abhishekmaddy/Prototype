package test.java.book;

import main.java.commonfunctions.ApiCommonFunctions;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateBookTest {

    String content;
    JSONObject payloadObject;
    public CreateBookTest() throws JSONException {
        File file = new File("src/test/resources/payloads/request_payloads.json");
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        payloadObject = new JSONObject(content);
    }

    @Test
    public void verifyBookCreation() throws IOException {

        ApiCommonFunctions apiCommonFunctions = new ApiCommonFunctions();
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        HashMap<String, String> payloadParam = new HashMap<>();
        apiCommonFunctions.createBookPost(payloadParam, requestHeaders);
    }

}
