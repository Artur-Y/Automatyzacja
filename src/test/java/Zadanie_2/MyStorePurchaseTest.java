package zadanie_2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/features/MyStorePurchase/MyStorePurchase.feature",
        plugin = {"pretty", "html:out"})
public class MyStorePurchaseTest {
}
