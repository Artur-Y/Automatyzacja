package zadanie_1.pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewAddress {
    private WebDriver driver;

    public CreateNewAddress(WebDriver driver) {
        this.driver = driver;
    }

    public void BtnAddressesClick() {
        WebElement btnAddresses = driver.findElement(By.xpath("(//*[@class='link-item'])[2]"));
        btnAddresses.click();

    }

    public void AssertionPage(String urlOfOpenedPage) {
        Assertions.assertEquals(urlOfOpenedPage, driver.getCurrentUrl());
    }


    public void BtnCreateNewAddressClick() {
        WebElement btnCreateNewAddress = driver.findElement(By.cssSelector("[data-link-action='add-address']"));
        btnCreateNewAddress.click();
    }

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


    public void BtnSaveClick() {
        WebElement btnSave = driver.findElement(By.xpath("(//*[@type='submit'])[2]"));
        btnSave.click();

    }

}
