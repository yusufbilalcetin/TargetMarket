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
 * Test case TM_FU_01: 1. Navigate to ordering page. 2. Click on Furniture category. 3.
 * Add Sofa for Coffe Cafe to cart. 4. Verify that the button for Sofa for Coffe Cafe is
 * turned to "Added to Cart". 5. Click on the cart button. 6. Verify that Sofa for Coffe
 * Cafe is visible on the popup. 7. Verify that the prices are the same on the popup. 8.
 * Click on "+" button to increase the amount of items. 9. Verify that the amount is "2"
 * and the total price is correct.
 */
@Listeners(ExtentReportListener.class)
public class TM_FU_01 extends Hooks {

	private SoftAssert softAssert = new SoftAssert();

	@Test
	void testFurniture() {
		try {
			// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1. Navigate to ordering page.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
			pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
			wait(5);

			TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

			// 2-) Click on Furniture category.
			ExtentReportListener.getTest().info("2. Click on Furniture category.");
			homePage.clickOnCategory(7);

			// 3-) Add Sofa for Coffe Cafe to cart.
			ExtentReportListener.getTest().info("3. Add Sofa for Coffe Cafe to cart.");
			homePage.addToCart("Sofa for Coffe Cafe");

			// 4-) Verify that buttons Sofa for Coffe Cafe is turned to "Added to Cart".
			ExtentReportListener.getTest()
				.info("4. Verify that buttons Sofa for Coffe Cafe is turned to 'Added to Cart'.");
			softAssert.assertEquals(homePage.getButtonText("Sofa for Coffe Cafe"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// 5-) Click on cart button.
			ExtentReportListener.getTest().info("5. Click on cart button.");
			homePage.clickOnCartButton();

			// 6-) Verify that Sofa for Coffe Cafe is visible on the popup.
			ExtentReportListener.getTest().info("6. Verify that Sofa for Coffe Cafe is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Sofa for Coffe Cafe",
					"Product is not added to cart");

			// 7-) Verify that the prices are the same on the popup.
			ExtentReportListener.getTest().info("7. Verify that the prices are the same on the popup.");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Sofa for Coffe Cafe")),
					"Product price is different on the cart");

			// 8-) Click on "+" button to increase the amount of items.
			ExtentReportListener.getTest().info("8. Click on '+' button to increase the amount of items.");
			homePage.clickOnIncreaseButtonOnCart(1, 1);

			wait(2);

			// 9-) Verify that the amount is "2" and the total price is correct.
			ExtentReportListener.getTest().info("9. Verify that the amount is '2' and the total price is correct.");
			softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "2",
					"Increase product amount button on the cart doesn't work");

			int totalPrice2 = Integer.parseInt(homePage.getProductPrice("Sofa for Coffe Cafe").substring(1)) * 2;

			softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice2),
					"Total price is wrong on the cart");

			// Assert all and handle the failures
			softAssert.assertAll("Furniture test 3 could not be completed: Total price is incorrect on the cart.");

			// Report the test as passed
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
