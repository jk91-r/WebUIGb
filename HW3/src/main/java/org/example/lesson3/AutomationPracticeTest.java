package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AutomationPracticeTest {
    public static void main(String[] args) throws InterruptedException {
        //отображение товара в разделе "My wishlist" при нажатии кнопки "Add my wishlist" карточке товара

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("user-agent=Googlebot/2.1(+http://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);
            driver.get("http://automationpractice.com/index.php");


        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.id("email")).sendKeys("kixayi5723@royins.com");
        driver.findElement(By.id("passwd")).sendKeys("123456789");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[@class='icon-home']")).click();
        driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']")).click();
        driver.findElement(By.id("group_1")).click();
        driver.findElement(By.xpath("//option[@value='2']")).click();
        driver.findElement(By.id("color_7")).click();
        driver.findElement(By.id("wishlist_button")).click();

        driver.switchTo().activeElement();
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='account']")).click();
        driver.findElement(By.xpath("//li[@class='lnk_wishlist']")).click();
        driver.findElement(By.xpath("//td[1]/a")).click();

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(562.500,430.487)");

        Thread.sleep(5000);

        driver.quit();
    }
}
