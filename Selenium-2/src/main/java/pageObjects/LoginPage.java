package pageObjects;

import frameWork.PageObjectBase;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObjectBase {
//    private WebDriver driver;

    // Constructor
    // Gets called when object of this page is created in MainClass.java
    public LoginPage(WebDriver driverFromConstructor) {
        super(driverFromConstructor);
        // "this" keyword is used here to distinguish global and local variable "driver"
        //gets driver as parameter from MainClass.java and assigns to the driver instance in this class
//        this.driver = driverFromConstructor;
    }

    //Locators
    By enterStoreLink = By.linkText("Enter the Store");
    By signIn = By.linkText("Sign In");
    By registerLink = By.linkText("Register Now!");

    //Method to click link
    public void selectStoreLink() {

        driver.findElement(enterStoreLink).click();
    }

    public void selectSignInLick() {
        driver.findElement(signIn).click();
    }

    public void selectRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public String getEnterTheStoreText() {
        return driver.findElement(enterStoreLink).getText();
    }

    public String getRegisterLinkText() {
        return driver.findElement(registerLink).getText();
    }

    public boolean enterTheStoreLinkIsDisplayed() {

        return driver.findElement(enterStoreLink).isDisplayed();
    }

    public boolean verifyPageTitle() {
        String pageTitle = "JPetStore Demo";
        String title = driver.getTitle();
        return title.contains(pageTitle);
    }

//    public LoginPage goToWebsite() {
//        driver.get("https://petstore.octoperf.com/");
//        return this;
//    }

}
