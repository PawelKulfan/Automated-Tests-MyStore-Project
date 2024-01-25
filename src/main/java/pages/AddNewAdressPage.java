package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAdressPage {
    @FindBy(xpath = "//input[@id='field-alias']")
    private WebElement aliasField;
    @FindBy(xpath = "//input[@id='field-address1']")
    private WebElement addressField;
    @FindBy(xpath = "//input[@id='field-city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='field-postcode']")
    private WebElement postCodeField;
    @FindBy(xpath = "//input[@id='field-phone']")
    private WebElement phoneField;

    @FindBy(className = "form-control-submit")
    private WebElement saveNewAdressButton;
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement unsuccesfullAddressDeletionMessage;

    private WebDriver webDriver;
    public AddNewAdressPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void addingAdressFromRandomGenerator() throws InterruptedException {
        String address = UserDataGenerator.getAdress();
        addressField.sendKeys(address);
        String city = UserDataGenerator.getCity();
        cityField.sendKeys(city);
        String postCode = UserDataGenerator.getPostCode();
        postCodeField.sendKeys(postCode);
        Thread.sleep(2000);//zatrzymuje działanie programu na określonąilość czasu
        saveNewAdressButton.click();
        String addressInfo = String.format("Adress: %1$s, City: %2$s, PostCode: %3$s", address, city, postCode);
        System.out.println(addressInfo);
    }
    public void addingAddressFromScenario (String alias, String address, String city, String zip, String phone) throws InterruptedException {
        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        postCodeField.sendKeys(zip);
        phoneField.sendKeys(phone);
        Thread.sleep(3000);//zatrzymuje działanie programu na określonąilość czasu
        saveNewAdressButton.click();
        String addressInfo = String.format("Adress '%1$s': %2$s, City: %2$s, PostCode: %4$s, Phone: %5$s", alias, address, city, zip, phone);
        System.out.println(addressInfo);
    }
    public String getUnsuccesfullAddressDeletionMessage () throws NoSuchElementException {
        return unsuccesfullAddressDeletionMessage.getText();
    }

}
