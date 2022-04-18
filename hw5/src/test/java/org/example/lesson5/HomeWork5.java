package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork5 {
    WebDriver driver;
    WebDriverWait webDriverWait;
    ChromeOptions  chromeOptions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications" +
                "        --disable-popup-blocking" +
                "        user-agent=Googlebot/2.1(+http://www.google.com/bot.html)");

    }

    @Test
    void readingBookOnlineLitres() {
        driver.get("https://www.litres.ru/pages/login/");

        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("kixayi5723@royins.com");
        driver.findElement(By.id("open_pwd_main")).sendKeys("607$396");
        driver.findElement(By.id("login_btn")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='books_box']")));

        driver.findElement(By.xpath("//*[@id=\"litres_header\"]//input")).sendKeys("стивен кинг лори");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@class='biblio_book www']")));

        driver.findElement(By.xpath("//a[@class='action_read bb_newbutton_caption']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content-box']")));

        driver.switchTo().activeElement();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@class='bottom-right']")).isDisplayed(), true);
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@class='icon-burger top-button']")).
                isDisplayed(), false);
    }


    @Test
     void addWishlistAutomationPractice(){
         driver.get("http://automationpractice.com/index.php");

         driver.findElement(By.xpath("//a[@class='login']")).click();
         driver.findElement(By.id("email")).sendKeys("kixayi5723@royins.com");
         driver.findElement(By.id("passwd")).sendKeys("123456789");
         driver.findElement(By.id("SubmitLogin")).click();


         driver.findElement(By.xpath("//i[@class='icon-home']")).click();
         driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']")).click();
         driver.findElement(By.id("group_1")).click();
         driver.findElement(By.xpath("//option[@value='2']")).click();
         driver.findElement(By.id("color_7")).click();
         driver.findElement(By.id("wishlist_button")).click();

         driver.switchTo().activeElement();
         driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");


         driver.findElement(By.xpath("//a[@class='account']")).click();
         driver.findElement(By.xpath("//li[@class='lnk_wishlist']")).click();
         driver.findElement(By.xpath("//td[1]/a")).click();

         ((JavascriptExecutor)driver).executeScript("window.scrollBy(562.500,430.487)");

         webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wishlistLinkTop']")));

         Assertions.assertEquals(driver.findElement
                 (By.xpath("//*[@src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']"))
                 .isDisplayed(), true);
     }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
