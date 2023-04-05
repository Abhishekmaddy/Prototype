package main.java.listeners;

import io.qameta.allure.Attachment;
import main.java.commonfunctions.CommonFunctions;

import main.java.utils.listners.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onFinish(ITestContext Result) {

    }

    @Override
    public void onStart(ITestContext Result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = CommonFunctions.getDriver();
        Logger.log("The name of the testcase failed is :" + iTestResult.getName());
        // Allure ScreenShot and SaveTestLog
        if (driver instanceof WebDriver) {
            //Logger.log("taking screenshot");
            //saveFailureScreenShot(driver);
        }
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result) {
        Logger.log("The name of the testcase Skipped is :" + Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result) {
        Logger.log("The name of the testcase started is :" + Result.getName());
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result) {
        Logger.log("The name of the testcase passed is :" + Result.getName());
    }

}
