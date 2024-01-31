package cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/features/addingAddress.feature",
        plugin = {"pretty", "html:report2.html"})
public class AddingAddressTest {
}
