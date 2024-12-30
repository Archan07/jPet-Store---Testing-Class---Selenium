package testingClass;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObjectBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By signIn = By.linkText("Sign In");

    By signup = By.linkText("Sign Up");


    public void clickSignIn() {
        driver.findElement(signIn).click();
    }

    public void clickSignUp() {
        driver.findElement(signup).click();
    }

}
