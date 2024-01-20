package loginProcessTests;

import baseTest.Hooks;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

// 1-)Open the URL.
// 2-) Enter "InvalidUserName" as username and "anything" as password.
// 3-) Verify that "Invalid username" and "Invalid password" message is displayed.

public class TM_LP_04 extends Hooks {

	@Test
	public void testLoginProcessWithInvalidCredentials() {
		// 1-)Open the URL.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// 2-) Enter "InvalidUserName" as username and "anything" as password.
		pages.getTargetMarketLoginPage().login("Invalid username", "anything");

		// 3-) Verify that "Invalid username" and "Invalid password" message is displayed.
		assertEquals("Invalid username", pages.getTargetMarketLoginPage().getErrorMessageText());
		assertEquals("Invalid password", pages.getTargetMarketLoginPage().getPasswordErrorMessageText());

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
