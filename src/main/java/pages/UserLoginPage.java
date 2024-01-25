package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement logInButton;
    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement loginUserEmailField;
    @FindBy(xpath = "//input[@id='field-password']")
    private WebElement loginUserPasswordField;

    private WebDriver webDriver;
    public UserLoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void logIn (String email, String password) {
        loginUserEmailField.sendKeys(email);
        loginUserPasswordField.sendKeys(password);
        logInButton.click();
    }
}
