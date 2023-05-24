package main.java.popo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Selenium {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebElement textfield =driver.findElement(By.id("twotabsearchtextbox"));
        textfield.sendKeys("harry potter book");
        textfield.sendKeys(Keys.ENTER);

         //WebElement book1=driver.findElement(By.xpath("//span[contains(text(),'The Unofficial Harry Potter Spellbook: The Wand Chooses the Wizard')]"));
         //WebElement book1=driver.findElement(By.xpath("(//div[@class='sg-col-inner']//ancestor::div[@class='a-section']//descendant::span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
         //WebElement book2=driver.findElement(By.xpath("(//div[@class='sg-col-inner']//ancestor::div[@class='a-section']//descendant::span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
         List<WebElement> list= (List<WebElement>) driver.findElement(By.xpath("//div[@class='sg-col-inner']//ancestor::div[@class='a-section']//descendant::span[@class='a-size-medium a-color-base a-text-normal']"));

         for (int i=0; i< list.size()-1; i++){
             System.out.println(list.get(i).getText());
         }

//         String s =book1.getText();
//         System.out.println(s);
//         //WebElement book2 =driver.findElement(By.xpath("//span[contains(text(),'Harry Potter Box Set: The Complete Collection (Children’s Paperback)')]"));
//         String s2=book2.getText();
//         System.out.println(s2);
////         if (book1.equals(book2)){
////             System.out.println("Book Matched");
////         }
////         else {
////             System.out.println("Not matched");
////         }
//
//        Assert.assertEquals(s,s2);
    }
}
