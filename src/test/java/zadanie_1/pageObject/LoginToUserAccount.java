package zadanie_1.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToUserAccount {
    private WebDriver driver;

    public LoginToUserAccount(WebDriver driver) {
        this.driver = driver;
    }


    public void SignInBtnOnHomepageClicked() {
        WebElement signInBtnHomepage = driver.findElement(By.xpath("//*[@class='hidden-sm-down'][contains(text(), 'Sign')]"));
        signInBtnHomepage.click();

    }

    public void FilledUserEmailAndPassword() {
        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.clear();
        emailInputField.sendKeys("todas97710@rezunz.com");

        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.clear();
        passwordInputField.sendKeys("qweasdzxc");
    }


    public void SignInBtnOnAuthorizationPageClicked() {
        WebElement signInBtn = driver.findElement(By.id("submit-login"));
        signInBtn.click();

    }

}
