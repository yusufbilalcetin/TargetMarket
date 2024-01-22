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
//3-) Add to Cart Sneaker Shoes.
// 4-) Verify that button Sneaker Shoes is turned to "Added to Cart".
//5-) Add to Cart Sneaker Shoes.
// 6-) Verify that Sneaker Shoes is visible on the popup.
// 7-) Verify that the prices are the same on the popup.
// 8-) Verify that Women Strip Heel is visible on the popup.
// 9-) Verify that the prices are the same on the popup.
@Listeners(ExtentReportListener.class)
public class TM_WS_01 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testProcessWomanShoes() {
		try {

			// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1-) Navigate to ordering page.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
			pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
			wait(5);

			TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

			// 2-) Click on Woman Shoes category.
			ExtentReportListener.getTest().info(" 2-) Click on Woman Shoes category.");
			homePage.scrollCategoriesToLeft();
			homePage.clickOnCategory(10);

			// 3-) Add to Cart Sneaker Shoes.
			ExtentReportListener.getTest().info("3-) Add to Cart Sneaker Shoes.");
			homePage.addToCart("Sneaker shoes");

			// 4-) Verify that button Sneaker Shoes is turned to "Added to Cart".
			ExtentReportListener.getTest().info("4-) Verify that button Sneaker Shoes is turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Sneaker shoes"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");
			// 5-) Add to Cart Sneaker Shoes.
			ExtentReportListener.getTest().info("5-) Add to Cart Sneaker Shoes.");
			homePage.addToCart("Women Strip Heel");

			// 6-) Verify that button Women Strip Heel is turned to "Added to Cart".
			ExtentReportListener.getTest()
				.info("6-) Verify that button Women Strip Heel is turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Women Strip Heel"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// 5-) Click on cart button.
			ExtentReportListener.getTest().info("5-) Click on cart button.");
			homePage.clickOnCartButton();

			// 6-) Verify that Sneaker Shoes is visible on the popup.
			ExtentReportListener.getTest().info("6-) Verify that Sneaker Shoes is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Sneaker shoes",
					"Product is not added to cart");

			// 7-) Verify that the prices are the same on the popup.
			ExtentReportListener.getTest().info("7-) Verify that the prices are the same on the popup.");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Sneaker shoes")),
					"Product price is different on the cart");
			// 8-) Verify that Women Strip Heel is visible on the popup.
			ExtentReportListener.getTest().info("8-) Verify that Women Strip Heel is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Women Strip Heel",
					"Product is not added to cart");

			// 9-) Verify that the prices are the same on the popup.
			ExtentReportListener.getTest().info("9-) Verify that the prices are the same on the popup.");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Women Strip Heel")),
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