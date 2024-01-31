package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    @FindBy(xpath = "//button[@name='confirm-addresses']")
    private WebElement confirmAddressButton;
    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement confirmShippingMethodButton;
    @FindBy(xpath = "//input[@id='payment-option-1']")
    private WebElement paymentMethodPayByCheckSelector;
    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    private WebElement termsAndConditionsConfirmationButton;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//*[@id=\"js-checkout-summary\"]/div[2]/div[2]/span[2]")
    private WebElement totalPaymentAmountFromOrderSummary;
    private WebDriver webDriver;
    static String paymentAmount;

    public OrderSummaryPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void confirmAddress () throws InterruptedException {
        Thread.sleep(2000);
        confirmAddressButton.click();
    }
    public void confirmShippingMethod () throws InterruptedException {
        Thread.sleep(2000);
        confirmShippingMethodButton.click();
    }
    public void selectPaymentMethodAndSetAmount () throws InterruptedException {
        Thread.sleep(2000);
        paymentMethodPayByCheckSelector.click();
        paymentAmount = totalPaymentAmountFromOrderSummary.getText();
    }
    public void termsAndConditionConfirmation () throws InterruptedException {
        Thread.sleep(2000);
        termsAndConditionsConfirmationButton.click();
    }
    public void placeOrder () throws InterruptedException {
        Thread.sleep(2000);
        placeOrderButton.click();
    }
    public String getPaymentAmountFromOrderSummary () {
        return paymentAmount;
    }
}
