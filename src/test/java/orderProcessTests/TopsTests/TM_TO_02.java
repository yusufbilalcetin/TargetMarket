package orderProcessTests.TopsTests;

import baseTest.Hooks;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

/**
 * 1-) Navigate to the Inar Academy homepage. 2-) Click on target market page. 3-) Perform
 * user login. 4-) Click on the Tops category. 5-) Add Sleeve Shirt Womens and Tank Tops
 * for Womens/Girls to the cart. 6-). Verify that the button text for both items is now
 * "Added to Cart." 7-) Verify that both items are visible in the cart popup. 8-) Verify
 * that the individual product prices in the cart match the expected prices. 9-) Increase
 * the quantity of each item to 3 by clicking the "+" button twice. 10-) Verify that the
 * quantity is now "3" and the total price is correct.
 */
public class TM_TO_02 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testTops() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(5);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Tops caregory.
		homePage.clickOnCategory(8);

		// 3-) Add Elbow Macaroni to cart.
		homePage.addToCart("ank Tops for Womens/Girls");

		// 4-) Verify that button in Elbow Macaroni card is turned to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText("ank Tops for Womens/Girls"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		// 5-) Verify that discount number is correct
		softAssert.assertEquals(homePage.getDiscount("ank Tops for Womens/Girls"), "% 12 OFF",
				"Discount number is not correct");

		// 6-) Click on cart button.
		homePage.clickOnCartButton();

		// 7-) Verify that ank Tops for Womens/Girls is visible on the popup.
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1),
				homePage.getProductName("ank Tops for Womens/Girls"), "Product is not added to the cart");

		// 8-) Verify that the price is the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("ank Tops for Womens/Girls")),
				"Product price is different on the cart");

		// 9-) Click on "-" button to decrease the amount of item.
		homePage.clickOnDecreaseButtonOnCart(1, 1);

		// 10-) Verify that 'Your cart is empty' message
		softAssert.assertEquals(homePage.getCartEmptyText(), "Your cart is empty.",
				"Product can not be removed from cart");

		// 11-)Click close button on the cart empty message popup
		homePage.clickCartEmptyCloseButton();

		// 12-)Verify that button in ank Tops for Womens/Girls card is turned to "Add to
		// Cart".
		softAssert.assertEquals(homePage.getButtonText("ank Tops for Womens/Girls"), "Add to Cart",
				"Button text does not turn to 'Add to Cart'");

		softAssert.assertAll("Tops test 2 cannot be completed:");

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
