package zadanie_1.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DeleteNewAddressCorrectly {
    private WebDriver driver;

    public DeleteNewAddressCorrectly(WebDriver driver) {
        this.driver = driver;
    }

    public void NewAddressDelete() {
        WebElement deleteAddressBtn = driver.findElement(By.xpath("(//*[@data-link-action='delete-address'])[2]"));
        deleteAddressBtn.click();

    }

    public void AssertDeletedAddressNotPresent() {
        try {
            driver.findElement(By.xpath("(//*[@class='address-body'])[2]"));
        } catch (Exception e) {
            System.out.println(driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText());

        }


    }

}
