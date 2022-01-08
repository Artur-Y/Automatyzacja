package zadanie_2.pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckDiscount {
    private WebDriver driver;

    public CheckDiscount(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckDiscountPercentageOnTheInformationText() throws IOException {
        try {
            WebElement discountPercentageInformationText = driver.findElement(By
                    .xpath("//*[@class='discount discount-percentage']"));
            Assertions.assertTrue(discountPercentageInformationText.getText().contains("20%"));

        } catch (AssertionError e) {
            System.out.println("Percentage discount information is not equals 20%"
                    + "\n" + "AssertionError message is" + e.getMessage());
        }

    }

    public void CheckValueOfDiscountPercentage() throws IOException {
        try {

            WebElement regularPriceElement = driver.findElement(By
                    .xpath("//*[@class='regular-price']"));

            String regularPrice = regularPriceElement.getText();
            regularPrice = regularPrice.replace("€", "");

            double regularPriceNum = Double.parseDouble(regularPrice); //convert to double
            BigDecimal bd = new BigDecimal(regularPriceNum).setScale(2, RoundingMode.HALF_UP); //round to 2 decimal
            double regularPriceNumRounded = bd.doubleValue();

            WebElement currentPriceElement = driver.findElement(By
                    .xpath("//*[@class='current-price']/span[@itemprop='price']"));

            String currentPrice = currentPriceElement.getText();
            currentPrice = currentPrice.replace("€", "");

            double currentPriceNum = Double.parseDouble(currentPrice);
            BigDecimal bd2 = new BigDecimal(currentPriceNum).setScale(2, RoundingMode.HALF_UP);
            double currentPriceNumRounded = bd2.doubleValue();

            double percentOfDiscount = 100 - (currentPriceNumRounded / regularPriceNumRounded) * 100;
            Assertions.assertTrue(Double.toString(percentOfDiscount).contains("20"));

        } catch (AssertionError e) {
            System.out.println("Percentage value of discount is not equals 20%"
                    + "\n" + "AssertionError message is" + e.getMessage());
        }
    }
}
