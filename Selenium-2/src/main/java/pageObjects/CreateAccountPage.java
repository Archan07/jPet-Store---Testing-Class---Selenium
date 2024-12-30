package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CreateAccountPage extends PageObjectBase {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    By userNameTextBox = By.name("username");
    By langugae = By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select/option");
    By selectedLanguage = By.name("account.languagePreference");
    By tableRows = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr");
    By tableFirstRow = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]");

    public void setUserName() {
        driver.findElement(userNameTextBox).sendKeys(generateRandomString(6));
        //The below line shows how can we use Key board keys
//        driver.findElement(userNameTextBox).sendKeys(Keys.BACK_SPACE);
    }

//    public void setUserNameWithPara(String userName) {
//        driver.findElement(userNameTextBox).sendKeys(userName);
//    }

    public void selectLanguage() {
        selectOptionFromSortLit(langugae, "japanese");
    }

    public String getSelectedLanguageText() {
        return getSelectedOptionText(selectedLanguage);
    }

    public void verifyProductsList(){
        List<WebElement> allOptions = driver.findElements(tableRows);
        if(allOptions.size() > 1){
            driver.findElement(tableFirstRow).isDisplayed();
        } else {
            System.out.println("List not existed");
        }
    }

}
