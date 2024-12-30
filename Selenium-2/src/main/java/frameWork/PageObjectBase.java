package frameWork;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageObjectBase {
    protected WebDriver driver;
    public WebDriverWait wait;

    public PageObjectBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String generateRandomString(int numb){
        return RandomStringUtils.randomAlphabetic(numb);
    }

    //Selecting elements from dropdown. Pass element variable and String text
    public void selectOptionFromSortLit(By options, String text) {
        List<WebElement> allOptions = driver.findElements(options);
        String option;
        for(int i=1; i<allOptions.size(); i++){
            option = allOptions.get(i).getText();
            if(option.equals(text)){
                allOptions.get(i).click();
                break;
            }
        }
//        //Other way to select dropdown
//        WebElement dropDown = driver.findElement(sortOption);
//        Select dropDownOption = new Select(dropDown);
//        dropDownOption.selectByValue("price:desc");
    }

    public void waitForElementVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementPresent(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public String getSelectedOptionText(By elm) {
        Select sel = new Select(driver.findElement(elm));
        WebElement strCurrentValue = sel.getFirstSelectedOption();
        return strCurrentValue.getText();
    }
}
