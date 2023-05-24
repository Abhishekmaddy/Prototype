package main.java.popo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Amazon {






    public static void main(String[] args) throws InterruptedException, Exception {
//        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement textfield = driver.findElement(By.id("twotabsearchtextbox"));
        textfield.sendKeys("harry potter book");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement bookprice = driver.findElement(By.xpath("//span[text()='The Unofficial Harry Potter Spellbook: The Wand Chooses the Wizard']//ancestor::div[@class='rush-component s-featured-result-item s-expand-height']//descendant::span[@class='a-price-whole']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sg-col-inner']//ancestor::div[@class='a-section']//descendant::span[@class='a-size-medium a-color-base a-text-normal']")));
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='sg-col-inner']//ancestor::div[@class='a-section']//descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println("Size - " + list.size());
        for (int i = 0; i < list.size() - 1; i++) {
//            System.out.println(list.get(i).getAttribute("innerText"));
//            System.out.println(list.get(i).getAttribute("innerHTML"));
            if (list.get(i).getText().equals(list.get(1).getText())){
                System.out.println("True");
            }
            else {
                System.out.println("false");
            }
        }
        System.out.println("Done");
        driver.close();
    }

}
