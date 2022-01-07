package Zadanie_2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class MyStorePurchaseStep {
    private WebDriver driver;

    @Given("^Opened page (.*) in browser1$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(url);
    }

    @And("Button Sign In on the homepage clicked1")
    public void SignInBtnOnHomepageClicked() {
        WebElement signInBtnHomepage = driver.findElement(By.xpath("//*[@class='hidden-sm-down'][contains(text(), 'Sign')]"));
        signInBtnHomepage.click();

    }

    @And("^Filled existing user's email and password1$")
    public void FilledUserEmailAndPassword() {
        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.clear();
        emailInputField.sendKeys("todas97710@rezunz.com");

        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.clear();
        passwordInputField.sendKeys("qweasdzxc");
    }


    @And("Button Sign In on the authorization page clicked1")
    public void SignInBtnOnAuthorizationPageClicked() {
        WebElement signInBtn = driver.findElement(By.id("submit-login"));
        signInBtn.click();
    }

    @And("^Clicked on the logo 'my store'1$")
    public void MyStoreLogoClick() {
        WebElement MyStoreLogo = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
        MyStoreLogo.click();
    }

    @When("Clicked on the item 'Hummingbird Printed Sweater'")
    public void ClickOnTheItem() {
        WebElement HummingbirdPrintedSweater = driver.findElement(By.xpath("//*[@class='h3 product-title']" +
                "/a[text()='Hummingbird printed sweater']"));
        HummingbirdPrintedSweater.click();
    }

    @And("Size M selected")
    public void SizeSelect() {
        WebElement sizeList = driver.findElement(By.id("group_1"));
        sizeList.sendKeys("M");

    }

    @And("^Quantity (.*) selected$")
    public void QuantitySelect(int quantity) {
        WebElement quantityInputField = driver.findElement(By.id("quantity_wanted"));
        quantityInputField.clear();
        quantityInputField.sendKeys(String.valueOf(quantity));

    }

    @And("Clicked button Add to card")
    public void ButtonAddToCardClick() {
        WebElement buttonAddToCard = driver.findElement(By.xpath("//*[@class='btn btn-primary add-to-cart']"));
        buttonAddToCard.click();
    }

    @And("Clicked button Proceed to checkout on pop-up window")
    public void ButtonProceedToCheckoutOnPupupWindowClick() {
        WebElement buttonProceedToCheckoutOnPupupWindow = driver.findElement(By.xpath("//*" +
                "[@class='btn btn-primary'][text()='Proceed to checkout']"));
        buttonProceedToCheckoutOnPupupWindow.click();

    }

    @And("Clicked button Proceed to checkout on page Shopping cart")
    public void ButtonProceedToCheckoutOnPageShoppingCartClick() {
        WebElement buttonProceedToCheckoutOnPageShoppingCart = driver.findElement(By.xpath("//*" +
                "[@class='btn btn-primary'][text()='Proceed to checkout']"));
        buttonProceedToCheckoutOnPageShoppingCart.click();
    }

    @And("Confirmed address by clicking on button Continue")
    public void ConfirmAddress() {
        WebElement buttonContinue = driver.findElement(By.name("confirm-addresses"));
        buttonContinue.click();
    }

    @And("^Chosen shipping method PrestaShop \"pick up in store\"$")
    public void ChoseShippingMethod() {
        WebElement ShoppingMethodCheckbox = driver.findElement(By.xpath("//*" +
                "[@class='h6 carrier-name'][text()='PrestaShop']"));
        ShoppingMethodCheckbox.click();
    }

    @And("Confirmed shipping method by clicking on button Continue")
    public void ConfirmShippingMethod() {
        WebElement buttonContinue = driver.findElement(By.name("confirmDeliveryOption"));
        buttonContinue.click();
    }

    @And("Chosen payment method Pay by Check")
    public void ChosePaymentMethod() {
        WebElement checkboxPayByCheck = driver.findElement(By.id("payment-option-1"));
        checkboxPayByCheck.click();
    }

    @And("^Checked checkbox \"I agree to the terms service\"$")
    public void CheckAgreeToTheTerms() {
        WebElement checkboxAgreeToTheTerms = driver.findElement(By.id
                ("conditions_to_approve[terms-and-conditions]"));
        checkboxAgreeToTheTerms.click();

    }

    @And("Clicked button \"Order with an obligation to pay\"")
    public void ClickBtnOrder() {
        WebElement orderButton = driver.findElement(By.xpath(
                "//*[@class='btn btn-primary center-block']"));
        orderButton.click();

    }

    @Then("Create screenshot of confirmed order page")
    public void TakeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "Coders", "Screenshots", "screen" + currentDateTime + ".png"));
    }
//    And Close browser
}
