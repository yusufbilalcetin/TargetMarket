package homePageTest;

import baseTest.Hooks;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on the cart image.
// 3-) Verify that a message, is displayed, telling that the cart is empty
public class TM_OP_02 extends Hooks {

	@Test
	public void testCartFunctionalityWhenItsEmpty() {
		SoftAssert softAssert = new SoftAssert();
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(3);
		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();
		// 2-) Click on the cart image.
		homePage.clickOnCartButton();
		wait(3);
		// 3-) Verify that a message, is displayed, telling that the cart is empty
		softAssert.assertEquals(homePage.getCartEmptyMessage(), "Your cart is empty.");
		softAssert.assertAll("Homepage test fails");

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
