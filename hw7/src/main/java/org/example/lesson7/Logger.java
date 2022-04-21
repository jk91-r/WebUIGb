package org.example.lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.OutputType.BYTES;

public class Logger implements WebDriverListener {
    public void beforeFindElement(WebDriver driver, By locator){
        Allure.step("Поиск элемента по локатору"+ locator.toString());
    }
    public void beforeQuit(WebDriver driver){
    Allure.addAttachment("Cкриншот страницы перед завершением теста" ,
            new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(BYTES)));
    }
}
