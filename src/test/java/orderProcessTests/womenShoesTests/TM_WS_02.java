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
//3-) Add Chappals & Shoe Ladies Metallic.
// 4-) Verify that buttons Chappals & Shoe Ladies Metallic is turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Chappals & Shoe Ladies Metallic is visible on the popup.
// 7-) Verify that the prices are the same on the popup.
// 8-) Click on "+" button to increase the amount of items.
// 9-) Verify that the amount is "2" and the total price is correct.
@Listeners(ExtentReportListener.class)
public class TM_WS_02 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testProcessesWomanShoes2() {
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

			// 3-) Add Chappals & Shoe Ladies Metallic.
			ExtentReportListener.getTest().info("3-) Add Chappals & Shoe Ladies Metallic.");
			homePage.addToCart("Chappals & Shoe Ladies Metallic");

			// 4-) Verify that buttons Chappals & Shoe Ladies Metallic is turned to "Added
			// to
			// Cart".
			ExtentReportListener.getTest()
				.info("4-) Verify that buttons Chappals & Shoe Ladies Metallic is turned to Added to Cart.");
			softAssert.assertEquals(homePage.getButtonText("Chappals & Shoe Ladies Metallic"), "Added to Cart",
					"Button text does not turn to 'Added to Cart'");

			// 5-) Click on cart button.
			ExtentReportListener.getTest().info("5-) Click on cart button.");
			homePage.clickOnCartButton();

			// 6-) Verify that Chappals & Shoe Ladies Metallic is visible on the popup.
			ExtentReportListener.getTest()
				.info("6-) Verify that Chappals & Shoe Ladies Metallic is visible on the popup.");
			softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Chappals & Shoe Ladies Metallic",
					"Product is not added to cart");

			// 7-) Verify that the prices are the same on the popup.
			ExtentReportListener.getTest().info("7-) Verify that the prices are the same on the popup.");
			softAssert.assertTrue(
					homePage.getPerProductPriceOnTheCart(1)
						.contains(homePage.getProductPrice("Chappals & Shoe Ladies Metallic")),
					"Product price is different on the cart");

			// 8-) Click on "+" button to increase the amount of items.
			ExtentReportListener.getTest().info("8-) Click on \"+\" button to increase the amount of items.");
			homePage.clickOnIncreaseButtonOnCart(1, 2);

			wait(2);

			// 9-) Verify that the amount is "3" and the total price is correct.
			ExtentReportListener.getTest().info("9-) Verify that the amount is \"3\" and the total price is correct.");
			softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "3",
					"Increase product amount button on the cart doesn't work");

			int totalPrice2 = Integer.parseInt(homePage.getProductPrice("Chappals & Shoe Ladies Metallic").substring(1))
					* 3;

			softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice2),
					"Total price is wrong on the cart");

			softAssert.assertAll("Furniture test 3 could not be completed: Total price is incorrect on the cart.");

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