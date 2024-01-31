package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAccountPage {
    @FindBy(className = "logout")
    private WebElement logOutButton;
    @FindBy(xpath = "//*[@id=\"address-link\"]")
    private WebElement addFirstAddressButton;
    @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a")
    private WebElement goToMainPageLogoButton;
    @FindBy(xpath = "//a[@id='history-link']")
    private WebElement orderHistoryButton;
    private WebDriver webDriver;
    public CustomerAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void signOut () throws InterruptedException {
        logOutButton.click();
        Thread.sleep(1000);
    }
    public void addFirstAddressButton() throws InterruptedException {
        addFirstAddressButton.click();
        Thread.sleep(2000);
    }
    public void goToMainPage () throws InterruptedException {
        goToMainPageLogoButton.click();
        Thread.sleep(1500);
    }
    public void goToOrderHistoryPage () throws InterruptedException {
        Thread.sleep(2000);
        orderHistoryButton.click();
    }
}
