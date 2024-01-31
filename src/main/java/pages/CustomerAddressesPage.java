package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomerAddressesPage {

    private String regex = "<br>";
    private String[] addressArray;
    @FindBy(className = "address")
    private WebElement currentAddressId;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]")
    private WebElement deleteAddressButton;
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement successfulAddressDeletionMessage;
    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement addAddressButton;

    private WebDriver webDriver;
    public static List<WebElement> addeddAddressesIdList;

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
    public void deleteAddress () throws InterruptedException {
        Thread.sleep(2000);
        deleteAddressButton.click();
        Thread.sleep(2000);
    }

    public String getSuccesfullAddressDeletionMessage () throws NoSuchElementException {
        return successfulAddressDeletionMessage.getText();
    }
    public void addAnotherAddress () throws InterruptedException {
        addAddressButton.click();
        Thread.sleep(2000);
    }
//    public List<WebElement> getAddedAddressesId() {
//       this.webDriver.findElements(By.className("address")).getAttribute("");
//       return addeddAddressesIdList;
//    }addeddAddressesIdList =
}
