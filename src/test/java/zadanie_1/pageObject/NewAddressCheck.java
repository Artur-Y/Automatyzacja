package zadanie_1.pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAddressCheck {
    private WebDriver driver;

    public NewAddressCheck(WebDriver driver) {
        this.driver = driver;
    }

    public void NewAddressCreatedCorrectly(String Alias, String Address, String City,
                                           String Zip_Postal_Code, String Country, String Phone) {

        WebElement createdAddress = driver.findElement(By.xpath("(//*[@class='address-body'])[2]"));
        String correctAddress = Alias + "\n" + "Piotr " + "Kowalski" + "\n" +
                Address + "\n" + City + "\n" + Zip_Postal_Code + "\n" + Country + "\n" + Phone;
        Assertions.assertEquals(correctAddress, createdAddress.getAttribute("outerText"));

    }

}
