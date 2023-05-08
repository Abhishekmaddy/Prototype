package main.demo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DomTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage() .timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://selectorshub.com/shadow-dom-in-iframe/");;

        driver.switchTo().frame("pact");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement element=(WebElement) jse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");

        //String js = "arguments[0].setAttribute('value', 'Green Masala')";
        String js = "arguments[0].setAttribute('value', '5 PM')";
        jse.executeScript(js,element);

    }
}
