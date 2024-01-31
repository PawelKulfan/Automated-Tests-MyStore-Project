package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckOutButtonCart;

    private WebDriver webDriver;

    public ShoppingCartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void proceedToCheckOutCart () throws InterruptedException {
        Thread.sleep(2000);
        proceedToCheckOutButtonCart.click();
    }
}
