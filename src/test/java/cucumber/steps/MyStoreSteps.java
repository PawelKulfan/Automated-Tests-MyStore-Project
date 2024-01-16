package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import mystore.AddNewAdressPage;
import mystore.MainPageMyStore;
import mystore.MyAccountPage;
import mystore.UserRegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStoreSteps {
    private WebDriver webDriver;

            @Given("An open browser with user registration page")
            public void openBrowserOnRegistrationPage () {
                this.webDriver = new ChromeDriver();
            }
            @When("User account is being created {word} times")
            public void puttingUserDataIntoForm (String phrase) throws InterruptedException {
                int numberOfUsersToCreate = Integer.valueOf(phrase);
                for (int i = 1; i <= numberOfUsersToCreate; i++) {
                    this.webDriver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
                    UserRegistrationPage userRegistrationPage = new UserRegistrationPage(this.webDriver);
                    userRegistrationPage.userRegistration();
                    this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    MainPageMyStore mainPageMyStore = new MainPageMyStore(this.webDriver);
                    assertEquals(UserRegistrationPage.fullName, mainPageMyStore.getCustomerNameMainPage());//Assertions gets customer full name from main page header after creating account and compares to generated user full name
                    this.webDriver.get("https://mystore-testlab.coderslab.pl/index.php?controller=address");
                    AddNewAdressPage addNewAdressPage = new AddNewAdressPage(this.webDriver);
                    addNewAdressPage.addingAdress();
                    this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    MyAccountPage myAccountPage = new MyAccountPage(this.webDriver);
                    myAccountPage.signOut();
                }
            }
            @Then("Quit browser")
            public void quitBrowser () {
                this.webDriver.quit();
            }
    }