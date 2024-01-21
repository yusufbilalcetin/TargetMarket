package orderProcessTests.skinCareTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Skincare category.
// 3-) Add Tree Oil 30ml and Oil Free Moisturizer 100ml to cart.
// 4-) Verify that buttons inTree Oil 30ml and Oil Free Moisturizer 100ml cards are turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Tree Oil 30ml and Oil Free Moisturizer 100ml are visible on the popup.
// 7-) Verify that the prices are the same on the popup.
// 8-) Click on "+" button to increase the amount of items.
// 9-) Verify that the amount is "2" and the total price is correct.
public class TM_SC_03 extends Hooks {

	@Test
	void testLaptopsOrderingMultiple() {
		try{

		// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1-) Navigate to ordering page.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Skincare category.
			ExtentReportListener.getTest().info(" 2-) Click on Skincare category.");
			homePage.clickOnCategory(4);

		// 3-) Add Tree Oil 30ml and Oil Free Moisturizer 100ml to cart.
			ExtentReportListener.getTest().info("3-) Add Tree Oil 30ml and Oil Free Moisturizer 100ml to cart.");
			homePage.addToCart("Tree Oil 30ml");
		homePage.addToCart("Oil Free Moisturizer 100ml");

		// 4-) Verify that buttons inTree Oil 30ml and Oil Free Moisturizer 100ml cards
		// are turned to "Added to Cart".
			ExtentReportListener.getTest().info("4-) Verify that buttons inTree Oil 30ml and Oil Free Moisturizer 100ml cards\n" +
					"\t\t// are turned to \"Added to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Tree Oil 30ml"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");
		softAssert.assertEquals(homePage.getButtonText("Oil Free Moisturizer 100ml"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// 5-) Click on cart button.
			ExtentReportListener.getTest().info("5-) Click on cart button.");
			homePage.clickOnCartButton();

		// 6-) Verify that Tree Oil 30ml and Oil Free Moisturizer 100ml are visible on the
		// popup.
			ExtentReportListener.getTest().info("6-) Verify that Tree Oil 30ml and Oil Free Moisturizer 100ml are visible on the\n" +
					"\t\t// popup.");
			wait(2);
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Tree Oil 30ml",
				"Product is not added to the cart");
		softAssert.assertEquals(homePage.getProductNameOnTheCart(2), "Oil Free Moisturizer 100ml",
				"Product is not added to the cart");

		// 7-) Verify that the prices are the same on the popup.
			ExtentReportListener.getTest().info("7-) Verify that the prices are the same on the popup.");
			softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Tree Oil 30ml")),
				"Product price is different on the cart");
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(2)
					.contains(homePage.getProductPrice("Oil Free Moisturizer 100ml")),
				"Product price is different on the cart");

		// 8-) Click on "+" button twice to increase the amount of the first item to 3.
			ExtentReportListener.getTest().info("8-) Click on \"+\" button twice to increase the amount of the first item to 3.");
			wait(2);
		homePage.clickOnIncreaseButtonOnCart(1, 2);

		// Click on "+" button 3 times to increase the amount of the second item to 4.
		homePage.clickOnIncreaseButtonOnCart(2, 3);

		// 9-) Verify that the first product's amount is "3" and the total price is
		// correct.
			ExtentReportListener.getTest().info("9-) Verify that the first product's amount is \"3\" and the total price is\n" +
					"\t\t// correct.");
			wait(2);
		softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "3",
				"Increase product amount button on the cart doesn't work");

		int totalPrice = Integer.parseInt(homePage.getProductPrice("Tree Oil 30ml").substring(1)) * 3;
		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice),
				"The first product's total price is wrong on the cart");

		// 10-) Verify that the second product's amount is "4" and the total price is
		// correct.
			ExtentReportListener.getTest().info("10-) Verify that the second product's amount is \"4\" and the total price is\n" +
					"\t\t// correct.");
			softAssert.assertEquals(homePage.getProductNumberOnTheCart(2), "4",
				"Increase product amount button on the cart doesn't work");

		int totalPrice2 = Integer.parseInt(homePage.getProductPrice("Oil Free Moisturizer 100ml").substring(1)) * 4;
		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(2).contains("$" + totalPrice2),
				"The second product's total price is wrong on the cart");

		softAssert.assertAll("Skincare test 3 cannot be completed:");
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
