package orderProcessTests.furnitureTests;

import baseTest.Hooks;
import org.testng.ITestContext;
import org.testng.ITestResult;
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
public class TM_FU_02 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testFurniture() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(5);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Groceries caregory.
		homePage.clickOnCategory(7);

		// 3-) Add Elbow Macaroni to cart.
		homePage.addToCart("Sofa for Coffe Cafe");

		// 4-) Verify that button in Elbow Macaroni card is turned to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText("Sofa for Coffe Cafe"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		// 5-) Verify that discount number is correct
		softAssert.assertEquals(homePage.getDiscount("Sofa for Coffe Cafe"), "% 16 OFF",
				"Discount number is not correct");

		// 6-) Click on cart button.
		homePage.clickOnCartButton();

		// 7-) Verify that Orange Essence Food Flavou is visible on the popup.
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), homePage.getProductName("Sofa for Coffe Cafe"),
				"Product is not added to the cart");

		// 8-) Verify that the price is the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Sofa for Coffe Cafe")),
				"Product price is different on the cart");

		// 9-) Click on "-" button to decrease the amount of item.
		homePage.clickOnDecreaseButtonOnCart(1, 1);

		// 10-) Verify that 'Your cart is empty' message
		softAssert.assertEquals(homePage.getCartEmptyText(), "Your cart is empty.",
				"Product can not be removed from cart");

		// 11-)Click close button on the cart empty message popup
		homePage.clickCartEmptyCloseButton();

		// 12-)Verify that button in Orange Essence Food Flavou card is turned to "Add to
		// Cart".
		softAssert.assertEquals(homePage.getButtonText("Sofa for Coffe Cafe"), "Add to Cart",
				"Button text does not turn to 'Add to Cart'");

		softAssert.assertAll("Furniture test 2 cannot be completed:");

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
