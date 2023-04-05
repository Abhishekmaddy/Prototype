package test.book;

import main.java.commonfunctions.ApiCommonFunctions;
import main.java.commonfunctions.CommonFunctions;
import main.java.utils.JsonAssertUtility;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateBookTest {

    @Test
    public void verifyBookCreation() throws IOException {

        ApiCommonFunctions apiCommonFunctions = new ApiCommonFunctions();
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        HashMap<String, String> payloadParam = new HashMap<>();
        apiCommonFunctions.createBookPost(payloadParam, requestHeaders);
    }

}
