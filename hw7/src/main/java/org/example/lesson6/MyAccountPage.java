package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyAccountPage extends BasePage{


    public MyAccountPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//i[@class='icon-home']")
    public WebElement linkHome;

    @FindBy(xpath = "//li[@class='lnk_wishlist']")
    public WebElement linkWishlist;

    @FindBy(xpath = "//td[1]/a")
    public WebElement viewWishlist;

    @Step("Переход на главную страницу сайта")
    public MainPage enterHome(){
        linkHome.click();
        return new MainPage(driver);
    }

    @Step("Просмотр товаров в Wishlist")
    public void enterMyWishlist(){
        linkWishlist.click();
        viewWishlist.click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(562.500,430.487)");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wishlistLinkTop']")));



    }


}
