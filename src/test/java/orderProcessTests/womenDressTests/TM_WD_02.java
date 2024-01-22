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
// 2-) Click on Woman Dresses category.
//3-) Add Night Suit Dress
// 4-) Verify that buttons Night Suit is turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Night Suit is visible on the popup.
// 7-) Verify that the prices are the same on the popup.
@Listeners(ExtentReportListener.class)
public class TM_WD_02 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testVerifyPrice() {
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

			// 3-) Add Night Suit Dress
			ExtentReportListener.getTest().info("3-) Add Night Suit Dress");
			homePage.addToCart("NIGHT SUIT");

			// 4-) Verify that buttons Night Suit is turned to "Added to Cart".
			ExtentReportListener.getTest().info("4-) Verify that buttons Night Suit is turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("NIGHT SUIT"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// 5-) Click on cart button.
			ExtentReportListener.getTest().info("5-) Click on cart button.");
			homePage.clickOnCartButton();

			// 6-) Verify that Night Suit is visible on the popup.
			ExtentReportListener.getTest().info("6-) Verify that Night Suit is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "NIGHT SUIT", "Product is not added to cart");

			// 7-) Verify that the prices are the same on the popup.
			ExtentReportListener.getTest().info("7-) Verify that the prices are the same on the popup.");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("NIGHT SUIT")),
					"Product price is different on the cart");

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