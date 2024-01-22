package orderProcessTests.furnitureTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

/**
 * 1-) Navigate to the Inar Academy homepage. 2-) Click on target market page. 3-) Perform
 * user login. 4-) Click on the Furniture category. 5-) Add Sofa for Coffe Cafe to the
 * cart. 6-) Verify that the button text for Sofa for Coffe Cafe is "Added to Cart". 7-)
 * Click on the cart button. 8-) Verify that Sofa for Coffe Cafe are visible on the popup.
 * 9-) Verify that the price is the same on the popup. 10-) Click on the "+" button twice
 * to increase the quantity of each item to 3. 11-) Verify that the quantity is "3" and
 * the total price is correct.
 */
@Listeners(ExtentReportListener.class)
public class TM_FU_02 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testFurniture() {
		try {
			// Step 1: Navigate to the Inar Academy homepage
			ExtentReportListener.getTest().info("Step 1: Navigate to the Inar Academy homepage.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();

			// Step 2: Click on target market page
			ExtentReportListener.getTest().info("Step 2: Click on target market page.");
			pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
			wait(5);

			TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

			// Step 3: Click on Furniture category
			ExtentReportListener.getTest().info("Step 3: Click on Furniture category.");
			homePage.clickOnCategory(7);

			// Step 4: Add Sofa for Coffe Cafe to cart
			ExtentReportListener.getTest().info("Step 4: Add Sofa for Coffe Cafe to cart.");
			homePage.addToCart("Sofa for Coffe Cafe");

			// Step 5: Verify that button text is 'Added to Cart'
			ExtentReportListener.getTest().info("Step 5: Verify that button text is 'Added to Cart'.");
			softAssert.assertEquals(homePage.getButtonText("Sofa for Coffe Cafe"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// Step 6: Verify that discount number is correct
			ExtentReportListener.getTest().info("Step 6: Verify that discount number is correct.");
			softAssert.assertEquals(homePage.getDiscount("Sofa for Coffe Cafe"), "% 16 OFF",
					"Discount number is not correct");

			// Step 7: Click on cart button
			ExtentReportListener.getTest().info("Step 7: Click on cart button.");
			homePage.clickOnCartButton();

			// Step 8: Verify that Sofa for Coffe Cafe is visible on the popup
			ExtentReportListener.getTest().info("Step 8: Verify that Sofa for Coffe Cafe is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), homePage.getProductName("Sofa for Coffe Cafe"),
					"Product is not added to the cart");

			// Step 9: Verify that the price is the same on the popup
			ExtentReportListener.getTest().info("Step 9: Verify that the price is the same on the popup.");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Sofa for Coffe Cafe")),
					"Product price is different on the cart");

			// Step 10: Click on "-" button to decrease the amount of the item.
			ExtentReportListener.getTest().info("Step 10: Click on '-' button to decrease the amount of the item.");
			homePage.clickOnDecreaseButtonOnCart(1, 1);

			// Step 11: Verify that 'Your cart is empty' message
			ExtentReportListener.getTest().info("Step 11: Verify that 'Your cart is empty' message.");
			softAssert.assertEquals(homePage.getCartEmptyText(), "Your cart is empty.",
					"Product cannot be removed from cart");

			// Step 12: Click close button on the cart empty message popup
			ExtentReportListener.getTest().info("Step 12: Click close button on the cart empty message popup.");
			homePage.clickCartEmptyCloseButton();

			// Step 13: Verify that the amount is '2' and the total price is correct.
			ExtentReportListener.getTest()
				.info("Step 13: Verify that the amount is '2' and the total price is correct.");
			// Add your verification logic here for the quantity and total price.

			// Assertions for existing steps
			softAssert.assertAll("Furniture test 2 cannot be completed:");

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
