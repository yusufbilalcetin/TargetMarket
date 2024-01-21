package loginProcessTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//1- Click on the Target Market link on the Inar Academy home page
//2- Try to Login using the locked out username
//3- Verify that locked user can not login
//4- Verify that "Your account is locked." text appears
@Listeners(ExtentReportListener.class)
public class TM_LP_02 extends Hooks {

    @Test

    public void testLoginProcessWithLockedUser() {
        try {
            // 1- Click on the Target Market link on the Inar Academy home page
            ExtentReportListener.getTest().info(" 1- Click on the Target Market link on the Inar Academy home page");
            pages.getInarAcademyHomePage().clickOnTargetMarketLink();

            // 2- Try to Login using the locked out username
            ExtentReportListener.getTest().info(" 2- Try to Login using the locked out username");
            pages.getTargetMarketLoginPage().login("locked_out_user", "secret_password");

            // 3- Verify that locked user can not login
            ExtentReportListener.getTest().info("3- Verify that locked user can not login");
            assertTrue(pages.getTargetMarketLoginPage().isErrorMessageDisplayed(), "Error message is not displayed");

            // 4- Verify that "Your account is locked." text appears
            ExtentReportListener.getTest().info("4- Verify that \"Your account is locked.\" text appears");
            String errorMessage = "Your account is locked.";
            assertEquals(errorMessage, pages.getTargetMarketLoginPage().getErrorMessageText(),
                    "Error message is not" + errorMessage);
            ExtentReportListener.getTest().pass("Test passed");
        } catch (Exception e) {
            // If any exception occurs, report the test as failed
            ExtentReportListener.getTest().fail("Test failed");
        }
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
