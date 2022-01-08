package zadanie_2.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderTheItem {
    private WebDriver driver;

    public OrderTheItem(WebDriver driver) {
        this.driver = driver;
    }

    public void MyStoreLogoClick() {
        WebElement MyStoreLogo = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
        MyStoreLogo.click();
    }

    public void ClickOnTheItem() {
        WebElement HummingbirdPrintedSweater = driver.findElement(By
                .xpath("//*[@class='h3 product-title']/a[text()='Hummingbird printed sweater']"));
        HummingbirdPrintedSweater.click();
    }

    public void SizeSelect(String size) {
        WebElement sizeList = driver.findElement(By.id("group_1"));
        sizeList.sendKeys(size);

    }

    public void QuantitySelect(int quantity) {
        WebElement quantityInputField = driver.findElement(By.id("quantity_wanted"));
        quantityInputField.clear();
        quantityInputField.sendKeys(String.valueOf(quantity));

    }

    public void ButtonAddToCardClick() {
        WebElement buttonAddToCard = driver.findElement(By.xpath("//*[@class='btn btn-primary add-to-cart']"));
        buttonAddToCard.click();
    }

    public void ButtonProceedToCheckoutOnPupupWindowClick() {
        WebElement buttonProceedToCheckoutOnPupupWindow = driver.findElement(By
                .xpath("//*[@class='btn btn-primary'][text()='Proceed to checkout']"));
        buttonProceedToCheckoutOnPupupWindow.click();

    }

    public void ButtonProceedToCheckoutOnPageShoppingCartClick() {
        WebElement buttonProceedToCheckoutOnPageShoppingCart = driver.findElement(By
                .xpath("//*[@class='btn btn-primary'][text()='Proceed to checkout']"));
        buttonProceedToCheckoutOnPageShoppingCart.click();
    }

    public void ConfirmAddress() {
        WebElement buttonContinue = driver.findElement(By.name("confirm-addresses"));
        buttonContinue.click();
    }

    public void ChoseShippingMethod() {
        WebElement ShoppingMethodCheckbox = driver.findElement(By
                .xpath("//*[@class='h6 carrier-name'][text()='PrestaShop']"));
        ShoppingMethodCheckbox.click();
    }

    public void ConfirmShippingMethod() {
        WebElement buttonContinue = driver.findElement(By.name("confirmDeliveryOption"));
        buttonContinue.click();
    }

    public void ChosePaymentMethod() {
        WebElement checkboxPayByCheck = driver.findElement(By.id("payment-option-1"));
        checkboxPayByCheck.click();
    }

    public void CheckAgreeToTheTerms() {
        WebElement checkboxAgreeToTheTerms = driver.findElement(By
                .id("conditions_to_approve[terms-and-conditions]"));
        checkboxAgreeToTheTerms.click();

    }

    public void ClickBtnOrder() {
        WebElement orderButton = driver.findElement(By.xpath("//*[@class='btn btn-primary center-block']"));
        orderButton.click();

    }


}
