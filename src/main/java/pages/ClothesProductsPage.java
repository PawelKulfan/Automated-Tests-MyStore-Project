package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesProductsPage {
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[1]/a")
    private WebElement hummingbirdSweater;

    private WebDriver webDriver;

    public ClothesProductsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void goToHummingbirdSweaterProductPage() throws InterruptedException {
        Thread.sleep(1500);
        hummingbirdSweater.click();
    }
}
