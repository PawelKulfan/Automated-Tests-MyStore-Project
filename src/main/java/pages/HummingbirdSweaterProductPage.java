package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HummingbirdSweaterProductPage {
    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement availableSizesList;
    @FindBy(className = "bootstrap-touchspin-up")
    private WebElement increaseProductQuantityButton;
    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckOutButton;
    @FindBy(className = "discount-percentage")
    private WebElement discountAmount;
    private WebDriver webDriver;

    public HummingbirdSweaterProductPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void selectDesiredProductSize (String size) {
        availableSizesList.click();
        String desiredProductSizeXpath = String.format("//option[@title='%1$s']", size);
        this.webDriver.findElement(By.xpath(desiredProductSizeXpath)).click();
    }
    public void selectDesiredProductQuantity (String quantity) throws InterruptedException {
        int quantityInt = Integer.parseInt(quantity) - 1;
        for (int i = 1; i <= quantityInt; i++) {
            increaseProductQuantityButton.click();
        }
    }
    public void addProductToCart () throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(3000);
    }
    public void proceddToCheckOut () throws InterruptedException {
        Thread.sleep(2000);
        proceedToCheckOutButton.click();
    }
    public String getDiscountAmount () {
        String discountValue = discountAmount.getText();
        return discountValue;
    }
}
