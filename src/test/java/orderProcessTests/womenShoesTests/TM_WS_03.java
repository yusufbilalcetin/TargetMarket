package orderProcessTests.womenShoesTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Woman Shoes category.
// 3-) Find Women Shoes.
// 4-) Verify that buttons Women Shoes is turned to "Added to Cart".
//5-Verify tha the discount is "%17".
@Listeners(ExtentReportListener.class)
public class TM_WS_03 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testProcessesWomanShoes3() {
		try {
			// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1-) Navigate to ordering page.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
			pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
			wait(5);

			TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

			// 2-) Click on Woman Shoes category.
			ExtentReportListener.getTest().info("2-) Click on Woman Shoes category.");
			homePage.scrollCategoriesToLeft();
			homePage.clickOnCategory(10);

			// 3-Add to Cart Women Shoes
			ExtentReportListener.getTest().info("3-)Add to Cart Women Shoes");
			homePage.addToCart("Women Shoes");

			// 4-) Verify that buttons Women Shoes is turned to "Added to Cart".
			ExtentReportListener.getTest().info("4-) Verify that buttons Women Shoes is turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Women Shoes"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// 5-Verify tha the discount is "%17".
			ExtentReportListener.getTest().info("5-)Verify tha the discount is \"%17\".");
			homePage.getDiscount("Women Shoes");
			softAssert.assertEquals(homePage.getDiscount("Women Shoes"), "%17 OF", "Wrong discount!");

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