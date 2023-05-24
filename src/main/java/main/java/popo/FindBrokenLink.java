package main.java.popo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class FindBrokenLink {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate to the website you want to check for broken links
        driver.get("https://www.amazon.in/");

        // get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // loop through each link and check if it's broken
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println(url + " is a broken link (" + responseCode + ")");
                    }
                } catch (Exception e) {
                    System.out.println(url + " is a broken link (" + e.getMessage() + ")");
                }
            }
        }
        // close the browser
        driver.quit();
    }
}