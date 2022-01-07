package zadanie_1;

import zadanie_1.pageObject.CreateNewAddress;
import zadanie_1.pageObject.DeleteNewAddressCorrectly;
import zadanie_1.pageObject.NewAddressCheck;
import zadanie_2.LoginToUserAccount;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MyStoreAddNewAddressStep {
    private WebDriver driver;
    private LoginToUserAccount loginToUserAccount;
    private CreateNewAddress createNewAddress;
    private DeleteNewAddressCorrectly deleteNewAddressCorrectly;

    @Before
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Given("^Open page (.*) in browser$")
    public void openPage(String url) {
        driver.get(url);
    }

    @And("Button Sign In on the homepage click")
    public void SignInBtnOnHomepageClick() {
        loginToUserAccount = new LoginToUserAccount(driver);
        loginToUserAccount.SignInBtnOnHomepageClicked();

    }

    @And("^Fill existing user's email and password$")
    public void FillUserEmailAndPassword() {
        loginToUserAccount.FilledUserEmailAndPassword();
    }


    @And("Button Sign In on the authorization page click")
    public void SignInBtnOnAuthorizationPageClick() {
        loginToUserAccount.SignInBtnOnAuthorizationPageClicked();
    }

    @When("Button Addresses click")
    public void BtnAddressesClick() {
        createNewAddress = new CreateNewAddress(driver);
        createNewAddress.BtnAddressesClick();
    }

    @And("^Url of opened page is (.*)$")
    public void AssertionPage(String urlOfOpenedPage) {
        createNewAddress.AssertionPage(urlOfOpenedPage);
    }

    @And("Button Create new address click")
    public void BtnCreateNewAddressClick() {
        createNewAddress.BtnCreateNewAddressClick();
    }

    @And("^Form fill by (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void FillForm(String Alias, String Address, String City,
                         String Zip_Postal_Code, String Country, String Phone) {

        createNewAddress.FillForm(Alias, Address, City, Zip_Postal_Code, Country, Phone);

    }

    @And("Button Save click")
    public void BtnSaveClick() {
        createNewAddress.BtnSaveClick();
    }

    @Then("^New address created correctly (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void NewAddressCreatedCorrectly(String Alias, String Address, String City,
                                           String Zip_Postal_Code, String Country, String Phone) {

        NewAddressCheck newAddressCheck = new NewAddressCheck(driver);
        newAddressCheck.NewAddressCreatedCorrectly(Alias, Address, City, Zip_Postal_Code, Country, Phone);

    }

    @And("Delete new address")
    public void NewAddressDelete() {
        deleteNewAddressCorrectly = new DeleteNewAddressCorrectly(driver);
        deleteNewAddressCorrectly.NewAddressDelete();
    }

    @And("Deleted address not present")
    public void AssertDeletedAddressNotPresent() {
        deleteNewAddressCorrectly.AssertDeletedAddressNotPresent();
    }


}