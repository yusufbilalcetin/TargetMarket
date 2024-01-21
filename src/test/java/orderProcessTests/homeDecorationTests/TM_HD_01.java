package orderProcessTests.homeDecorationTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Home Decoration category.
// 3-) Add Flying Wooden Bird to cart.
// 4-) Verify that button in Flying Wooden Bird card is turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that  Flying Wooden Bird is visible on the popup.
// 7-) Verify that the price is the same on the popup.
// 8-) Click on two times "+" button to increase the amount of item.
// 9-) Verify that the amount is "3" and the total price is correct.

public class TM_HD_01 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testHomeDecoration() {
		try{

		// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1. Navigate to ordering page.");

			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(3);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();
		wait(1);

		// 2-) Click on Home Decoration category.
			ExtentReportListener.getTest().info("2-) Click on Home Decoration category.");
			homePage.clickOnCategory(6);

		wait(3);

		// 3-) Add Flying Wooden Bird to cart.
			ExtentReportListener.getTest().info("3-) Add Flying Wooden Bird to cart.");
			homePage.addToCart("Flying Wooden Bird");

		// 4-) Verify that button in Flying Wooden Bird card is turned to "Added to Cart".
			ExtentReportListener.getTest().info("4-) Verify that button in Flying Wooden Bird card is turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Flying Wooden Bird"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// 5-) Click on cart button.
			ExtentReportListener.getTest().info("5-) Click on cart button.");
			homePage.clickOnCartButton();

		// 6-) Verify that Flying Wooden Bird is visible on the popup.
			ExtentReportListener.getTest().info("6-) Verify that Flying Wooden Bird is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Flying Wooden Bird",
				"Product is not added to the cart");

		// 7-) Verify that the price is the same on the popup.
			ExtentReportListener.getTest().info("7-) Verify that the price is the same on the popup.");
			softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Flying Wooden Bird")),
				"Product price is different on the cart");

		// 8-) Click on two times "+" button to increase the amount of item.
			ExtentReportListener.getTest().info("8-) Click on two times \"+\" button to increase the amount of item.");
			homePage.clickOnIncreaseButtonOnCart(1, 2);

		// 9-) Verify that the amount is "3" and the total price is correct.
			ExtentReportListener.getTest().info("9-) Verify that the amount is \"3\" and the total price is correct.");
			softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "3",
				"Increase product amount button on the cart doesn't work");

		int totalPrice = Integer.parseInt(homePage.getProductPrice("Flying Wooden Bird").substring(1)) * 3;

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice),
				"Total price is wrong on the cart");

		softAssert.assertAll("Home Decoration test 1 cannot be completed:");
			ExtentReportListener.getTest().pass("Test passed");

	}catch (Exception e) {
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
