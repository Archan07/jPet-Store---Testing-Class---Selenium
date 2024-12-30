package testingClass;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOnForm extends PageObjectBase {

    public SignOnForm(WebDriver driver) {
        super(driver);
    }

    By username = By.name("Username");
    By password = By.name("Password");
    By login = By.linkText("Login");
    By register = By.linkText("Register Now!");

    public void provideUsername() {
        driver.findElement(username).sendKeys();
    }

    public void providePassword() {
        driver.findElement(password).sendKeys();
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }

    public void clickRegisterNow() {
        driver.findElement(register).click();
    }

}
