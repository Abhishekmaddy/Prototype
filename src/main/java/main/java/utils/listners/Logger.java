package main.java.utils.listners;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;

public class Logger implements ITestListener {

    @Attachment(value = "{0}", type = "text/plain")
    public static String log(String message) {
        System.out.println(message);
        return message;
    }

}
