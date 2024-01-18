package orderProcessTests.homeDecorationTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;
import utils.JSUtils;
// 1-) Navigate to ordering page.
// 2-) Click on Home Decoration category.
// 3-) Add Plant Hanger For Home to cart.
// 4-) Verify that button in Plant Hanger For Home card is turned to "Added to Cart".
// 5-) Verify that discount number is correct
// 6-) Click on cart button.
// 7-) Verify that Plant Hanger For Home is visible on the popup.
// 8-) Verify that the price is the same on the popup.
// 9-) Click on "-" button to decrease the amount of item.
//10-) Verify that 'Your cart is empty' message
//11-)Click close button on the cart empty message popup
//12-)Verify that button in Plant Hanger For Home card is turned to "Add to Cart".

public class TM_HD_02 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testHomeDecoration() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(3);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		wait(2);

		// 2-) Click on Home Decoration caregory.
		homePage.clickOnCategory(6);

		wait(2);

		// 3-) Add Plant Hanger For Home to cart.
		homePage.addToCart("Plant Hanger For Home");

		// 4-) Verify that button in Plant Hanger For Home card is turned to "Added to
		// Cart".
		softAssert.assertEquals(homePage.getButtonText("Plant Hanger For Home"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		// 5-) Verify that discount number is correct
		softAssert.assertEquals(homePage.getDiscount("Plant Hanger For Home"), "18", "Discount number is not correct");

		// 6-) Click on cart button.
		homePage.clickOnCartButton();

		// 7-) Verify that Plant Hanger For Home is visible on the popup.
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), homePage.getProductName("Plant Hanger For Home"),
				"Product is not added to the cart");

		// 8-) Verify that the price is the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Plant Hanger For Home")),
				"Product price is different on the cart");

		// 9-) Click on "-" button to decrease the amount of item.
		homePage.clickOnDecreaseButtonOnCart(1, 1);

		// 10-) Verify that 'Your cart is empty' message
		softAssert.assertEquals(homePage.getCartEmptyText(), "Your cart is empty.",
				"Product can not be removed from cart");

		// 11-)Click close button on the cart empty message popup
		homePage.clickCartEmptyCloseButton();

		// 12-)Verify that button in Plant Hanger For Home card is turned to "Add to
		// Cart".
		softAssert.assertEquals(homePage.getButtonText("Plant Hanger For Home"), "Add to Cart",
				"Button text does not turn to 'Add to Cart'");

	}

}