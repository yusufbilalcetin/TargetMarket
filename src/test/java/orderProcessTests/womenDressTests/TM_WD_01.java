package orderProcessTests.womenDressTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Woman Dresses.
// 3-) Add Ladies Multicolored Dresses.
// 4-) Verify that button in Ladies Multicolored Dresses card is turned to "Added to Cart".
@Listeners(ExtentReportListener.class)
public class TM_WD_01 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testWomenDresses() {
		try {
			// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1-) Navigate to ordering page.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
			pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
			wait(5);

			TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

			// 2-) Click on Woman Dresses category.
			ExtentReportListener.getTest().info("2-) Click on Woman Dresses category.");
			homePage.scrollCategoriesToLeft();
			homePage.clickOnCategory(9);

			// 3-) Add Ladies Multicolored Dresses.
			ExtentReportListener.getTest().info("3-) Add Ladies Multicolored Dresses.");
			homePage.addToCart("Ladies Multicolored Dress");

			// 4-) Verify that buttons Sofa for Coffe Cafe is turned to "Added to Cart".
			ExtentReportListener.getTest()
				.info("4-) Verify that buttons Sofa for Coffe Cafe is turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Ladies Multicolored Dress"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

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