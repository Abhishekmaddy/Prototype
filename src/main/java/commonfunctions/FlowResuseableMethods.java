package main.java.commonfunctions;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class FlowResuseableMethods {

    ApiCommonFunctions apiCommonFunctions = new ApiCommonFunctions();
    String content;
    JSONObject payloadObject;

    public FlowResuseableMethods() throws IOException {
        File file = new File("./src/test/resources/payloads/request_payloads.json");
        content = FileUtils.readFileToString(file, "utf-8");
        payloadObject = new JSONObject(content);
    }
}
