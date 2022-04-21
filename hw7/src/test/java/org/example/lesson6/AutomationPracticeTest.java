package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson7.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class AutomationPracticeTest {
        WebDriver driver;
        WebDriverWait webDriverWait;
        ChromeOptions chromeOptions;

        @BeforeAll
        static void registerDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setupDriver() {
            driver = new EventFiringDecorator(new Logger()).decorate(new ChromeDriver());
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications" +
                    "        --disable-popup-blocking" +
                    "        user-agent=Googlebot/2.1(+http://www.google.com/bot.html)");

        }

        @Test
        void addWishlistAutomationPractice(){
            driver.get("http://automationpractice.com/index.php");

            new MainPage(driver)
                    .signIn()
                    .login("kixayi5723@royins.com","123456789");

            new MyAccountPage(driver)
                    .enterHome()
                    .enterProductCard();

            new ProductCard(driver)
                    .addWishlist()
                    .enterMyWishlist();

            assertThat(driver.findElement(By.xpath("//*[@src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']"))
                    ,isDisplayed());

        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

}
