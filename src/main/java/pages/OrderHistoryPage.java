package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    @FindBy(className = "label-pill")
    private WebElement orderStatus;
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/th")
    private WebElement orderNumber;
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")
    private WebElement paymentAmountOrderHistory;
    private WebDriver webDriver;
    public OrderHistoryPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public String getOrderNumberFromOrderHistory() {
        return "Order reference: " + orderNumber.getText();
    }
    public String getPaymentAmountFromOrderHistory () {
        return paymentAmountOrderHistory.getText();
    }
    public String getOrderStatus () {
        return orderStatus.getText();
    }
}
