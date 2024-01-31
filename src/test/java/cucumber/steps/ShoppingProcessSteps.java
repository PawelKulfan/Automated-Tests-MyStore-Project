package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ShoppingProcessSteps {
    private WebDriver webDriver;

    @Given("An open browser with logged user")
    public void openBrowserLoginUser() throws InterruptedException {
        this.webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        this.webDriver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        UserLoginPage userLoginPage = new UserLoginPage(this.webDriver);
        userLoginPage.logIn("16629@mejl.com", "16629");
    }
    @When("User adds parametrized product with size: {word} and quantity: {word} to cart and checkout")
    public void purchaseAndCheckout (String size, String quantity) throws InterruptedException {
        CustomerAccountPage myAccountPage = new CustomerAccountPage(this.webDriver);
        myAccountPage.goToMainPage();
        MainPageMyStore mainPageMyStore = new MainPageMyStore(this.webDriver);
        mainPageMyStore.goToClothesPage();
        ClothesProductsPage clothesProductsPage = new ClothesProductsPage(this.webDriver);
        clothesProductsPage.goToHummingbirdSweaterProductPage();
        HummingbirdSweaterProductPage hummingbirdSweaterProductPage = new HummingbirdSweaterProductPage(this.webDriver);
        assertEquals("SAVE 20%", hummingbirdSweaterProductPage.getDiscountAmount());
        hummingbirdSweaterProductPage.selectDesiredProductSize(size);
        hummingbirdSweaterProductPage.selectDesiredProductQuantity(quantity);
        hummingbirdSweaterProductPage.addProductToCart();
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        hummingbirdSweaterProductPage.proceddToCheckOut();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(this.webDriver);
        shoppingCartPage.proceedToCheckOutCart();
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(this.webDriver);
        orderSummaryPage.confirmAddress();
        orderSummaryPage.confirmShippingMethod();
        orderSummaryPage.selectPaymentMethodAndSetAmount();
        orderSummaryPage.termsAndConditionConfirmation();
        orderSummaryPage.placeOrder();

    }
    @Then("Shipping address confirmed, shipping and payment method chosen, order confirmed, prt scr of order confirmation done")
    public void prtscrOrderConfirmation() throws IOException {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./prtscrExerciseTwo.png"));
    }
    @And("Order is marked as awaiting check payment and payment value is same as in order summary")
    public void confirmPaymentAmountAndOrderStatus () throws InterruptedException {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(this.webDriver);
        orderConfirmationPage.goToCustomerAccountPage();
        CustomerAccountPage customerAccountPage = new CustomerAccountPage(this.webDriver);
        customerAccountPage.goToOrderHistoryPage();
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(this.webDriver);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(this.webDriver);
        if (Objects.equals(orderHistoryPage.getOrderNumberFromOrderHistory(), orderConfirmationPage.getOrderNumberFromOrderConfirmationField())) {
            assertEquals(orderSummaryPage.getPaymentAmountFromOrderSummary(), orderHistoryPage.getPaymentAmountFromOrderHistory());
            assertEquals("Awaiting check payment", orderHistoryPage.getOrderStatus());
        } else {
            System.out.println("Order is not in the Order History Page!");
        }
    }
}
