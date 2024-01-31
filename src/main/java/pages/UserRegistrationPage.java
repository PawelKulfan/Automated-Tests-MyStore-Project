package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class UserRegistrationPage {
    @FindBy(xpath = "//input[@id='field-id_gender-1']")
    private WebElement genderField;
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerPrivacyCheckBox;
    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement termsAcceptanceCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitFormField;

    private WebDriver webDriver;
    static String firstName;
    static String lastName;
    public static String email;
    public static String password;
    public static String getFirstName () {
        firstName = UserDataGenerator.getFirstName();
        return firstName;
    }
    public static String getLastName () {
        lastName = UserDataGenerator.getLastName();
        return lastName;
    }
    public static String getEmail () {
        email = UserDataGenerator.getEmail();
        return email;
    }
    public static String getPassword () {
        password = UserDataGenerator.getPassword();
        return password;
    }
    public static String fullName;

    public UserRegistrationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void userRegistration () throws InterruptedException {
        genderField.click();
        firstName = getFirstName();
        firstNameField.sendKeys(firstName);
        lastName = getLastName();
        lastNameField.sendKeys(lastName);
        email = getEmail();
        emailField.sendKeys(email);//test email for testing repeated email error
        password = getPassword();
        passwordField.sendKeys(password);
        customerPrivacyCheckBox.click();
        termsAcceptanceCheckBox.click();
        Thread.sleep(3000);//zatrzymuje działanie programu na określoną ilość czasu
        submitFormField.click();
        Thread.sleep(1500);
        try {//finding error message with exception handling
            WebElement emailDanger = webDriver.findElement(By.className("alert-danger"));
            if (emailDanger.isDisplayed()) {//error message displayed checker
                Random backupGenerator = new Random();//if message is displayed, create a new generator object
                int backupRandomNumber = backupGenerator.nextInt(20000) + 10001;//using new generator to create new ranodm index value
                String backupEmail = backupRandomNumber + "@mejl.com";//creating new email
                emailField.clear();//clearing field from previous email
                emailField.sendKeys(backupEmail);
                passwordField.sendKeys(String.valueOf(backupRandomNumber));
                Thread.sleep(3000);//zatrzymuje działanie programu na określonąilość czasu
                submitFormField.click();
                email = backupEmail;
            }
        } catch (NoSuchElementException e) {//printed in case error message couldn't be found
            System.out.println("Email didn't repeat");
        }
        String customerInfo = String.format("Customer Name: %1$s %2$s, email: %3$s Password: %4$s", firstName, lastName, email, password);
        System.out.println(customerInfo);
        fullName = firstName + " " + lastName;
    }
    }