package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']")
    public WebElement imgProduct;

    @Step("Вход в аккаунт")
    public LoginPage signIn(){
        signInButton.click();
        return new LoginPage(driver);
    }

    @Step("Переход на страницу товара")
    public ProductCard enterProductCard(){
        imgProduct.click();
        return  new ProductCard(driver);
    }
}
