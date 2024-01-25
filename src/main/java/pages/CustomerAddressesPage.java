package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CustomerAddressesPage {

    private String regex = "<br>";
    private String[] addressArray;
    @FindBy(className = "address")
    private WebElement currentAddressId;
    @FindBy(xpath = "//a[@data-link-action='delete-address']")
    private WebElement deleteAddressButton;
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement successfulAddressDeletionMessage;

    private WebDriver webDriver;

    public CustomerAddressesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String getAddedAddress() {
        String addressId = currentAddressId.getAttribute("id");
        String currentXpath = String.format("//*[@id=\"%1$s\"]/div[1]/address", addressId);
        String addressCheck = this.webDriver.findElement(By.xpath(currentXpath)).getAttribute("innerHTML");
        addressArray = addressCheck.split(regex, 0);
        System.out.println(("Address array from customer address page:" + Arrays.toString(addressArray)));
        return addressArray[1];
    }
    public String getAddedCity() {
        return addressArray[2];
    }
    public String getAddedZip() {
        return addressArray[3];
    }
    public String getAddedPhone() {
        return addressArray[5];
    }
    public void deleteAddress () {
        deleteAddressButton.click();
    }
//    public boolean successfulAddressDeletion() throws NoSuchElementException {
//        return successfulAddressDeletionMessage.isDisplayed();
//    }
    public String getSuccesfullAddressDeletionMessage () throws NoSuchElementException {
        return successfulAddressDeletionMessage.getText();
    }
}
