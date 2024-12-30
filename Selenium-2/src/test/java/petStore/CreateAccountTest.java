package petStore;

import baseTest.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import util.extentReport.ExtentTestManager;
import util.logs.Log;

import java.lang.reflect.Method;

public class CreateAccountTest extends BaseTest {
    private WebDriver driver;

    final String GlobalV = "This is global test. I can modify here";

    @BeforeMethod
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1, description = "create account")
//    @Parameters("userName")
//    public void createAccount(String userName) {      This line for Parameterization
    public void createAccount(Method method) {
        try {
            LoginPage loginPO = new LoginPage(driver);

            ExtentTestManager.startTest(method.getName(), "Create account sample extent");
            System.out.println(GlobalV);
            Assert.assertTrue(loginPO.verifyPageTitle());
            ExtentTestManager.getTest().log(Status.INFO, "Page title is verified");
            Log.info("title: " + loginPO.verifyPageTitle());
            Assert.assertTrue(loginPO.enterTheStoreLinkIsDisplayed());
            loginPO.selectStoreLink();
            loginPO.selectSignInLick();
            Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
            ExtentTestManager.endTest();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test(priority = 0,description = "Account creation")
    public void accountCreation(Method method) {
        LoginPage loginPO = new LoginPage(driver);
        CreateAccountPage createAccountPO = new CreateAccountPage(driver);

        ExtentTestManager.startTest(method.getName(), "Create account sample extent");
        System.out.println(GlobalV);
        Assert.assertTrue(loginPO.enterTheStoreLinkIsDisplayed());
        ExtentTestManager.getTest().log(Status.INFO,"Store link:"+loginPO.enterTheStoreLinkIsDisplayed());
        loginPO.selectStoreLink();
        loginPO.selectSignInLick();
        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
        loginPO.selectRegisterLink();
        createAccountPO.setUserName();
        createAccountPO.selectLanguage();
        createAccountPO.setUserName();
        Assert.assertEquals(createAccountPO.getSelectedLanguageText(), "japanese");
        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
        ExtentTestManager.endTest();
    }

}
