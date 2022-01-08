package zadanie_2.pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOrder {
    private WebDriver driver;

    public CheckOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickCustomerAccountBtn() {
        WebElement customerAccountBtn = driver.findElement(By.xpath("//*[@class='account']"));
        customerAccountBtn.click();

    }

    public void ClickOrderHistoryAndDetailsBtn() {
        WebElement orderHistoryAndDetailsBtn = driver.findElement(By.id("history-link"));
        orderHistoryAndDetailsBtn.click();

    }

    public void CheckInvoiceStatus() {
        driver.navigate().back();
        driver.navigate().back();

        WebElement orderIdElement = driver.findElement(By.xpath("//*/li[contains(text(),'Order reference')]"));
        String orderId = orderIdElement.getText().replace("Order reference: ", "");

        driver.navigate().forward();
        driver.navigate().forward();

        WebElement invoiceStatus = driver.findElement(By
                .xpath("//tbody/tr/th[@scope='row'][text()='" + orderId + "']" +
                        "//following::span[@class='label label-pill bright']"));

        Assertions.assertTrue(invoiceStatus.getText().contains("Awaiting check payment"));


    }


    public void CheckTotalPrice() {
        driver.navigate().back();
        driver.navigate().back();

        WebElement orderIdElement = driver.findElement(By.xpath("//*/li[contains(text(),'Order reference')]"));
        String orderId = orderIdElement.getText().replace("Order reference: ", "");

        WebElement totalPriceOnOrderConfirmedPageElement = driver.findElement(By
                .xpath("(//*[@class='font-weight-bold']/*)[2]"));
        String totalPriceOnOrderConfirmedPage = totalPriceOnOrderConfirmedPageElement.getText();

        driver.navigate().forward();
        driver.navigate().forward();

        WebElement totalPrice = driver.findElement(By
                .xpath("//tbody/tr/th[@scope='row'][text()='" + orderId + "']" +
                        "//following::td[@class='text-xs-right']"));

        Assertions.assertTrue(totalPrice.getText().contains(totalPriceOnOrderConfirmedPage));

    }
}
