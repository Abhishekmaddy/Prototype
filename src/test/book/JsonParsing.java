package test.book;

import main.java.commonfunctions.ApiCommonFunctions;
import main.java.commonfunctions.CommonFunctions;
import main.java.commonfunctions.FlowResuseableMethods;
import main.java.utils.JsonAssertUtility;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class JsonParsing {

    public JsonParsing() throws IOException {
        ApiCommonFunctions apiCommonFunctions = new ApiCommonFunctions();
        CommonFunctions commonFunctions = new CommonFunctions();
        JsonAssertUtility jsonAssertUtility = new JsonAssertUtility();
        FlowResuseableMethods flowResuseableMethods = new FlowResuseableMethods();
        JSONObject jo = new JSONObject();



    }
}
