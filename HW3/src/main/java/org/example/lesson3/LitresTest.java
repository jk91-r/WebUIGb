package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LitresTest {
    public static void main(String[] args) throws InterruptedException {
        //Чтение книги в онлайн-режиме для авторизованного пользователя

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(chromeOptions);
                 driver.get("https://www.litres.ru/pages/login/");



        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("kixayi5723@royins.com");
        driver.findElement(By.id("open_pwd_main")).sendKeys("607$396");
        driver.findElement(By.id("login_btn")).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("стивен кинг лори");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='Search-module__button']")).click();


        driver.findElement(By.xpath("//a[@class='action_read bb_newbutton_caption']")).click();


        Thread.sleep(5000);

        driver.quit();

    }

}
