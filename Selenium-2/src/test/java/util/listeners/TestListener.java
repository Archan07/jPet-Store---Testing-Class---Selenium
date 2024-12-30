package util.listeners;

import baseTest.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.extentReport.ExtentManager;
import util.logs.Log;

import java.util.Objects;

import static util.extentReport.ExtentTestManager.getTest;

public class TestListener extends BaseTest implements ITestListener {
    private WebDriver driver;
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + "- test is starting.");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + "- test is succeed.");
        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + "- test is failed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        //ExtentReports log and screenshot operations for failed tests.
        getTest().log(Status.FAIL, "Test Failed",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
//        getTest().log(Status.FAIL, "Test Failed");
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    //The below one other type of implementation
//    @Override
//    public void onTestStart(ITestResult Result) {
//        System.out.println(Result.getName()+" test case started");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult Result) {
//        System.out.println(Result.getName() + " - testcase passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult Result) {
//        System.out.println("The name of the testcase failed is :"+Result.getName());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult Result) {
//        System.out.println("The name of the testcase Skipped is :"+Result.getName());
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//
//    }
//
//    @Override
//    public void onStart(ITestContext Result) {
//
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//
//    }
}
