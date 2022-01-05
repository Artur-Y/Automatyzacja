package Zadanie_1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MyStoreAddNewAddressStep {
    private WebDriver driver;

    @Given("^Opened page (.*) in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(url);
    }

    @And("Button Sign In on the homepage clicked")
    public void SignInBtnOnHomepageClicked() {
        WebElement signInBtnHomepage = driver.findElement(By.xpath("//*[@class='hidden-sm-down'][contains(text(), 'Sign')]"));
        signInBtnHomepage.click();

    }

    @And("^Filled existing user's email and password$")
    public void FilledUserEmailAndPassword() {
        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.clear();
        emailInputField.sendKeys("todas97710@rezunz.com");

        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.clear();
        passwordInputField.sendKeys("qweasdzxc");
    }


    @And("Button Sign In on the authorization page clicked")
    public void SignInBtnOnAuthorizationPageClicked() {
        WebElement signInBtn = driver.findElement(By.id("submit-login"));
        signInBtn.click();
    }

    @When("Button Addresses clicked")
    public void BtnAddressesClicked() {
        WebElement btnAddresses = driver.findElement(By.xpath("(//*[@class='link-item'])[2]"));
        btnAddresses.click();

        Assertions.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=addresses"
                , driver.getCurrentUrl());

    }


    @And("Button Create new address clicked")
    public void BtnCreateNewAddressClicked() {
        WebElement btnCreateNewAddress = driver.findElement(By.cssSelector("[data-link-action='add-address']"));
        btnCreateNewAddress.click();
    }

    @And("^Form filled by (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void FillForm(String Alias, String Address, String City,
                         String Zip_Postal_Code, String Country, String Phone) {

        WebElement aliasInputField = driver.findElement(By.name("alias"));
        aliasInputField.sendKeys(Alias);

        WebElement addressInputField = driver.findElement(By.name("address1"));
        addressInputField.sendKeys(Address);

        WebElement cityInputField = driver.findElement(By.name("city"));
        cityInputField.sendKeys(City);

        WebElement zip_Postal_CodeInputField = driver.findElement(By.name("postcode"));
        zip_Postal_CodeInputField.sendKeys(Zip_Postal_Code);

        WebElement countryInputField = driver.findElement(By.name("id_country"));
        countryInputField.sendKeys(Country);

        WebElement phoneInputField = driver.findElement(By.name("phone"));
        phoneInputField.sendKeys(Phone);
    }


    @And("Button Save clicked")
    public void BtnSaveClick() {
        WebElement btnSave = driver.findElement(By.xpath("(//*[@type='submit'])[2]"));
        btnSave.click();

    }

    @Then("^New address created correctly (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void NewAddressCreatedCorrectly(String Alias, String Address, String City,
                                           String Zip_Postal_Code, String Country, String Phone) {
        WebElement createdAddress = driver.findElement(By.xpath("(//*[@class='address-body'])[2]"));
        String correctAddress = Alias + "\n" + "Piotr " + "Kowalski" + "\n" +
                Address + "\n" + City + "\n" + Zip_Postal_Code + "\n" + Country + "\n" + Phone;
        Assertions.assertEquals(correctAddress, createdAddress.getAttribute("outerText"));


    }

    @And("Delete new address")
    public void NewAddressDelete() {
        WebElement deleteAddressBtn = driver.findElement(By.xpath("(//*[@data-link-action='delete-address'])[2]"));
        deleteAddressBtn.click();

    }

    @And("Deleted address not present")
    public void AssertDeletedAddressNotPresent() {
        try {
            driver.findElement(By.xpath("(//*[@class='address-body'])[2]"));
        } catch (Exception e) {
            System.out.println("Address has been deleted correctly");

        }

    }


}