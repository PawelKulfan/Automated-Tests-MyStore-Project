package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AddNewAdressPage {
    @FindBy(xpath = "//input[@id='field-address1']")
    private WebElement adressField;
    @FindBy(xpath = "//input[@id='field-city']")
    private WebElement cityField;
    @FindBy(xpath = "//input[@id='field-postcode']")
    private WebElement postCodeField;
    @FindBy(className = "form-control-submit")
    private WebElement saveNewAdressButton;

    private WebDriver webDriver;
    public AddNewAdressPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void addingAdress () throws InterruptedException {
        String address = UserDataGenerator.getAdress();
        adressField.sendKeys(address);
        String city = UserDataGenerator.getCity();
        cityField.sendKeys(city);
        String postCode = UserDataGenerator.getPostCode();
        postCodeField.sendKeys(postCode);
        Thread.sleep(2000);//zatrzymuje działanie programu na określonąilość czasu
        saveNewAdressButton.click();
        String addressInfo = String.format("Adress: %1$s, City: %2$s, PostCode: %3$s", address, city, postCode);
        System.out.println(addressInfo);

    }

}
