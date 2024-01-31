package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement customerAccountPage;
    @FindBy(xpath = "//li[@id='order-reference-value']")
    private WebElement orderNumberFromOrderConfirmationField;
    private WebDriver webDriver;
    String orderNumberFromOrderConfirmation;
    public OrderConfirmationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void goToCustomerAccountPage () throws InterruptedException {
        orderNumberFromOrderConfirmation = orderNumberFromOrderConfirmationField.getText();
        Thread.sleep(2000);
        customerAccountPage.click();
    }
    public String getOrderNumberFromOrderConfirmationField() {
        return orderNumberFromOrderConfirmation;
    }

}
