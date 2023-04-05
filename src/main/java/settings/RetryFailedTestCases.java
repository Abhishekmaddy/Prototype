package main.java.settings;

import main.java.utils.listners.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
    private int retryCount = 0;
    //You could mentioned maxRetryCnt (Maximum Retry Count) as per your requirement. Here I took 2, If any failed testcases then it runs two times
    private int maxRetryCnt = 0;

    //This method will be called everytime a test fails. It will return TRUE if a test fails and need to be retried, else it returns FALSE
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCnt) {
            Logger.log("Retrying " + result.getName() + " again and the count is " + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }
}
