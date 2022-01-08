package zadanie_2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import zadanie_2.pageObject.*;

import java.io.IOException;
import java.time.Duration;

public class MyStorePurchaseStep {
    private WebDriver driver;
    private LoginToUserAccount loginToUserAccount;
    private OrderTheItem orderTheItem;
    private CheckOrder checkOrder;

    @Given("^Opened page (.*) in browser1$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get(url);
    }

    @And("Button Sign In on the homepage clicked1")
    public void SignInBtnOnHomepageClick() {
        loginToUserAccount = new LoginToUserAccount(driver);
        loginToUserAccount.SignInBtnOnHomepageClicked();

    }

    @And("^Filled existing user's email and password1$")
    public void FilledUserEmailAndPassword() {
        loginToUserAccount.FilledUserEmailAndPassword();
    }


    @And("Button Sign In on the authorization page clicked1")
    public void SignInBtnOnAuthorizationPageClicked() {
        loginToUserAccount.SignInBtnOnAuthorizationPageClicked();
    }

    @And("^Clicked on the logo 'my store'1$")
    public void MyStoreLogoClick() {
        orderTheItem = new OrderTheItem(driver);
        orderTheItem.MyStoreLogoClick();
    }

    @When("Clicked on the item 'Hummingbird Printed Sweater'")
    public void ClickOnTheItem() {
        orderTheItem.ClickOnTheItem();
    }

    @And("^Check discount 20%$")
    public void CheckDiscount() throws IOException {
        CheckDiscount checkDiscount = new CheckDiscount(driver);
        checkDiscount.CheckDiscountPercentageOnTheInformationText();
        checkDiscount.CheckValueOfDiscountPercentage();

    }

    @And("^Size (.*) select$")
    public void SizeSelect(String size) {
        orderTheItem.SizeSelect(size);

    }

    @And("^Quantity (.*) selected$")
    public void QuantitySelect(int quantity) {
        orderTheItem.QuantitySelect(quantity);

    }

    @And("Clicked button Add to card")
    public void ButtonAddToCardClick() {
        orderTheItem.ButtonAddToCardClick();
    }

    @And("Clicked button Proceed to checkout on pop-up window")
    public void ButtonProceedToCheckoutOnPupupWindowClick() {
        orderTheItem.ButtonProceedToCheckoutOnPupupWindowClick();

    }

    @And("Clicked button Proceed to checkout on page Shopping cart")
    public void ButtonProceedToCheckoutOnPageShoppingCartClick() {
        orderTheItem.ButtonProceedToCheckoutOnPageShoppingCartClick();
    }

    @And("Confirmed address by clicking on button Continue")
    public void ConfirmAddress() {
        orderTheItem.ConfirmAddress();
    }

    @And("^Chosen shipping method PrestaShop \"pick up in store\"$")
    public void ChoseShippingMethod() {
        orderTheItem.ChoseShippingMethod();
    }

    @And("Confirmed shipping method by clicking on button Continue")
    public void ConfirmShippingMethod() {
        orderTheItem.ConfirmShippingMethod();
    }

    @And("Chosen payment method Pay by Check")
    public void ChosePaymentMethod() {
        orderTheItem.ChosePaymentMethod();
    }

    @And("^Checked checkbox \"I agree to the terms service\"$")
    public void CheckAgreeToTheTerms() {
        orderTheItem.CheckAgreeToTheTerms();

    }

    @And("Clicked button \"Order with an obligation to pay\"")
    public void ClickBtnOrder() {
        orderTheItem.ClickBtnOrder();

    }

    @Then("Create screenshot of confirmed order page")
    public void TakeScreenshot() throws IOException {
        TakeScreenshotOfOrder takeScreenshotOfOrder = new TakeScreenshotOfOrder(driver);
        takeScreenshotOfOrder.TakeScreenshot();
    }


    @And("Click customer account button")
    public void ClickCustomerAccountBtn() {
        checkOrder = new CheckOrder(driver);
        checkOrder.ClickCustomerAccountBtn();

    }

    @And("^Click \"ORDER HISTORY AND DETAILS\" button$")
    public void ClickOrderHistoryAndDetailsBtn() {
        checkOrder.ClickOrderHistoryAndDetailsBtn();

    }

    @And("^Check \"Invoice\" status \"Awaiting check payment\" of order$")
    public void CheckInvoiceStatus() {
        checkOrder.CheckInvoiceStatus();


    }

    @And("Check \"Total Price\" value of order$")
    public void CheckTotalPrice() {
        checkOrder.CheckTotalPrice();

    }
}
