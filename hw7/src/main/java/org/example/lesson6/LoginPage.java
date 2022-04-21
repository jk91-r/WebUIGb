package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement fieldEmail;

    @FindBy(id = "passwd")
    public WebElement fieldPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement submitButton;

    @Step("Логин")
    public MyAccountPage login(String email, String passwd) {
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(passwd);
        submitButton.click();
        return new MyAccountPage(driver);
    }
}
