package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageMyStore {
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]")
    private WebElement signOutButton;
    @FindBy(partialLinkText = "mylogout")
    private WebElement signOutText;
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement customerNameMainPage;
    @FindBy(xpath = "//*[@id=\"category-3\"]/a")
    private WebElement clothesButton;
    private WebDriver webDriver;
    public MainPageMyStore(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public String getCustomerNameMainPage() {
        return customerNameMainPage.getText();
    }
    public void goToClothesPage () throws InterruptedException {
        Thread.sleep(1500);
        clothesButton.click();

    }
}
