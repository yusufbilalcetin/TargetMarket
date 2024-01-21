package orderProcessTests.groceriesTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Groceries category.
// 3-) Add 'Elbow Macaroni - 400 gm' to cart.
// 4-) Verify that button in 'Elbow Macaroni - 400 gm' card is turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that  'Elbow Macaroni - 400 gm' is visible on the popup.
// 7-) Verify that the price is the same on the popup.
// 8-) Click on four times "+" button to increase the amount of item.
// 9-) Verify that the amount is "5" and the total price is correct.
@Listeners(ExtentReportListener.class)
public class TM_GR_01 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testGroceries() {
		try {

			// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1. Navigate to ordering page.");

			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
			pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
			wait(5);

			TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

			// 2-) Click on Groceries caregory.
			ExtentReportListener.getTest().info("2-) Click on Groceries caregory.");
			homePage.clickOnCategory(5);

			// 3-) Add Elbow Macaroni to cart.
			ExtentReportListener.getTest().info("3-) Add Elbow Macaroni to cart.");
			homePage.addToCart("Elbow Macaroni - 400 gm");

			// 4-) Verify that button in Elbow Macaroni card is turned to "Added to Cart".
			ExtentReportListener.getTest().info(" 4-) Verify that button in Elbow Macaroni card is turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Elbow Macaroni - 400 gm"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// 5-) Click on cart button.
			ExtentReportListener.getTest().info("5-) Click on cart button.");
			homePage.clickOnCartButton();

			// 6-) Verify that Elbow Macaroni is visible on the popup.
			ExtentReportListener.getTest().info(" 6-) Verify that Elbow Macaroni is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Elbow Macaroni - 400 gm",
					"Product is not added to cart");

			// 7-) Verify that the price is the same on the popup.
			ExtentReportListener.getTest().info(" 7-) Verify that the price is the same on the popup.");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Elbow Macaroni - 400 gm")),
					"Product price is different on the cart");

			// 8-) Click on four times "+" button to increase the amount of item.
			ExtentReportListener.getTest().info(" 8-) Click on four times \"+\" button to increase the amount of item.");
			homePage.clickOnIncreaseButtonOnCart(1, 4);
			wait(2);

			// 9-) Verify that the amount is "5" and the total price is correct.
			ExtentReportListener.getTest().info(" 9-) Verify that the amount is \"5\" and the total price is correct.");
			softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "5",
					"Increase product amount button on the cart doesn't work");

			int totalPrice = Integer.parseInt(homePage.getProductPrice("Elbow Macaroni - 400 gm").substring(1)) * 5;
			softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice),
					"Total price is wrong on the cart");

			softAssert.assertAll("Groceries test 1 cannot be completed:");
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