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
//2- Try to Login using a valid username and by leaving the password field blank
//3- Verify that alert message displayed
//4- Verify that alert message is "Please enter your password"
@Listeners(ExtentReportListener.class)
public class TM_LP_03 extends Hooks {

	@Test
	public void testWithoutPassword() {
		try {
			// 1- Click on the Target Market link on the Inar Academy home page
			ExtentReportListener.getTest().info("1- Click on the Target Market link on the Inar Academy home page");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();

			// 2- Try to Login using a valid username and by leaving the password field
			// blank
			ExtentReportListener.getTest()
				.info("2- Try to Login using a valid username and by leaving the password field blank");
			pages.getTargetMarketLoginPage().login("standard_user", "");

			// 3- Verify that alert showed
			ExtentReportListener.getTest().info("3- Verify that alert showed");
			assertTrue(pages.getTargetMarketLoginPage().isPasswordErrorMessageDisplayed(),
					"Error message is not displayed");

			// 4- Verify that alert message is "Please enter your password"
			ExtentReportListener.getTest().info("4- Verify that alert message is \"Please enter your password\"");
			String errorMessage = "Please enter your password";
			assertEquals(errorMessage, pages.getTargetMarketLoginPage().getPasswordErrorMessageText(),
					"Error message is not" + errorMessage);

			ExtentReportListener.getTest().pass("Test passed");
		}
		catch (Exception e) {
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
