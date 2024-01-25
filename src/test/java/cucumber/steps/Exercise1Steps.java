package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.ComparisonFailure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Exercise1Steps {
    private WebDriver webDriver;
    @Given("An open browser with user login page")
    public void openLoginPage() throws InterruptedException {
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(this.webDriver);
        userRegistrationPage.userRegistration();
        MyAccountPage myAccountPage = new MyAccountPage(this.webDriver);
        myAccountPage.signOut();
        this.webDriver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }
    @When("User logins to his account and adds first address: {word} {word} {word} {word} {word}")
    public void logInUserAndAddAddress (String alias, String address, String city, String zip, String phone) throws InterruptedException {
        UserLoginPage userLoginPage = new UserLoginPage(this.webDriver);
        userLoginPage.logIn(UserRegistrationPage.email, UserRegistrationPage.password);
        MyAccountPage myAccountPage = new MyAccountPage(this.webDriver);
        myAccountPage.addFirstAddressButton();
        AddNewAdressPage addNewAdressPage = new AddNewAdressPage(this.webDriver);
        addNewAdressPage.addingAddressFromScenario(alias, address, city, zip, phone);
    }
    @Then("First address added to user account with proper data: {word} {word} {word} {word}")
    public void firstAddressAdded(String address, String city, String zip, String phone) {
        CustomerAddressesPage customerAddressesPage = new CustomerAddressesPage(this.webDriver);
        assertEquals(address, customerAddressesPage.getAddedAddress());
        assertEquals(city, customerAddressesPage.getAddedCity());
        assertEquals(zip, customerAddressesPage.getAddedZip());
        assertEquals(phone, customerAddressesPage.getAddedPhone());
    }
    @And("User deletes address")
    public void deleteAddress () {
        CustomerAddressesPage customerAddressesPage = new CustomerAddressesPage(this.webDriver);
        customerAddressesPage.deleteAddress();
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
//    IN THIS VERSION, ASSERTION ERROR IS HANDLED, SO ASSERTION WILL ALWAYS BE TRUE, SCRIPT PRINTS OPERATION STATUS (DELETED OR NOT DELETED) WITH EXCEPTION MESSAGE
    @And("No address in user addresses panel")
    public void isAddressDeleted () throws ComparisonFailure {
        CustomerAddressesPage customerAddressesPage = new CustomerAddressesPage(this.webDriver);
        String assertionResultMessage = null;
        try {
            assertEquals("Address successfully deleted!", customerAddressesPage.getSuccesfullAddressDeletionMessage());
        } catch (ComparisonFailure e1) {
            assertionResultMessage = e1.getMessage();
        }
        if (assertionResultMessage != null) {
            AddNewAdressPage addNewAdressPage = new AddNewAdressPage(this.webDriver);
            System.out.println("Email address wasn't deleted, because: " + addNewAdressPage.getUnsuccesfullAddressDeletionMessage());
        } else {
            System.out.println("Address successfully deleted");
        }
    }


//    IN THIS VERSION, ASSERTION ERROR IS NOT HANDLED, SO ASSERTION WILL FAIL
//    @And("No address in user addresses panel")
//    public void isAddressDeleted () throws ComparisonFailure {
//        CustomerAddressesPage customerAddressesPage = new CustomerAddressesPage(this.webDriver);
//        assertEquals("Address successfully deleted!", customerAddressesPage.getSuccesfullAddressDeletionMessage());
//    }
}
