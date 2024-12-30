package testingClass;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountForm extends PageObjectBase {

    public NewAccountForm(WebDriver driver) {
        super(driver);
    }

    By userID = By.name("User ID");
    By newPassword = By.name("New Password");
    By confirmPassword = By.name("Confirm Password");
    By firstName = By.name("First Name");
    By lastName = By.name("Last Name");
    By email = By.name("Email");
    By phone = By.name("Phone");
    By address1 = By.name("Address 1");
    By address2 = By.name("Address 2");
    By city = By.name("City");
    By state = By.name("State");
    By zip = By.name("Zip");
    By country = By.name("Country");
    By saveAccountInformation = By.linkText("Save Account Information");

    public void userID() {
        driver.findElement(userID).sendKeys();
    }

    public void setNewPassword() {
        driver.findElement(newPassword).sendKeys();
    }

    public void setConfirmPassword() {
        driver.findElement(confirmPassword).sendKeys();
    }

    public void setFirstName() {
        driver.findElement(firstName).sendKeys();
    }

    public void setLastName() {
        driver.findElement(lastName).sendKeys();
    }

    public void setEmail() {
        driver.findElement(email).sendKeys();
    }

    public void setPhone() {
        driver.findElement(phone).sendKeys();
    }

    public void setAddress1() {
        driver.findElement(address1).sendKeys();
    }

    public void setAddress2() {
        driver.findElement(address2).sendKeys();
    }

    public void setCity() {
        driver.findElement(city).sendKeys();
    }

    public void setState() {
        driver.findElement(state).sendKeys();
    }

    public void setZip() {
        driver.findElement(zip).sendKeys();
    }

    public void setCountry() {
        driver.findElement(country).sendKeys();
    }

    public void setSaveAccountInformation() {
        driver.findElement(saveAccountInformation).click();
    }
}
