package orderProcessTests.TopsTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

/**
 * 1. Navigate to ordering page. 2. Click on Tops category. 3. Add Women Sweaters Wool to
 * cart. 4. Verify that the button in Women Sweaters Wool card is turned to "Added to
 * Cart". 5. Verify that the discount number is correct. 6. Click on the cart button. 7.
 * Verify that Women Sweaters Wool is visible on the popup. 8. Verify that the price is
 * the same on the popup. 9. Click on "-" button to decrease the amount of the item. 10.
 * Verify that 'Your cart is empty' message. 11. Click the close button on the cart empty
 * message popup. 12. Verify that the button in Women Sweaters Wool card is turned to "Add
 * to Cart".
 */
@Listeners(ExtentReportListener.class)
public class TM_TO_01 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testTops() {
		try {
			// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1-) Navigate to ordering page.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
			pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
			wait(5);

			TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

			// 2-) Click on Tops caregory.
			ExtentReportListener.getTest().info(".");
			homePage.clickOnCategory(8);

			// 3-) Add Women Sweaters Wool to cart.
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			homePage.addToCart("Women Sweaters Wool");

			// 4-) Verify that button in Women Sweaters Wool card is turned to "Added to
			// Cart".
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Women Sweaters Wool"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// 5-) Verify that discount number is correct
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			softAssert.assertEquals(homePage.getDiscount("Women Sweaters Wool"), "% 17 OFF",
					"Discount number is not correct");

			// 6-) Click on cart button.
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			homePage.clickOnCartButton();

			// 7-) Verify that Women Sweaters Wool is visible on the popup.
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), homePage.getProductName("Women Sweaters Wool"),
					"Product is not added to the cart");

			// 8-) Verify that the price is the same on the popup.
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Women Sweaters Wool")),
					"Product price is different on the cart");

			// 9-) Click on "-" button to decrease the amount of item.
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			homePage.clickOnDecreaseButtonOnCart(1, 1);

			// 10-) Verify that 'Your cart is empty' message
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			softAssert.assertEquals(homePage.getCartEmptyText(), "Your cart is empty.",
					"Product can not be removed from cart");

			// 11-)Click close button on the cart empty message popup
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			homePage.clickCartEmptyCloseButton();

			// 12-)Verify that button in Women Sweaters Wool card is turned to "Add to
			// Cart".
			ExtentReportListener.getTest()
				.info("12-)Verify that button in ank Tops for Womens/Girls card is turned to \"Add to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Women Sweaters Wool"), "Add to Cart",
					"Button text does not turn to 'Add to Cart'");

			softAssert.assertAll("Tops test 2 cannot be completed:");

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
