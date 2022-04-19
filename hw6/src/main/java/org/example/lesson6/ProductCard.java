package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends BasePage{

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "group_1")
    public WebElement fieldSize;

    @FindBy(xpath = "//option[@value='2']")
    public WebElement size;

    @FindBy(id = "color_7")
    public WebElement color;

    @FindBy(id = "wishlist_button")
    public WebElement wishlistButton;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement activeAccountButton;

    public MyAccountPage addWishlist(){
        fieldSize.click();
        size.click();
        color.click();
        wishlistButton.click();
        activeAccountButton.click();
        return new MyAccountPage(driver);
    }
}
