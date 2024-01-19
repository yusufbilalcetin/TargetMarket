package orderProcessTests.TopsTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

/**
 * 1. Navigate to ordering page. 2. Click on Tops category. 3. Add Sleeve Shirt Womens and
 * ank Tops for Womens/Girls to cart. 4. Verify that buttons Orange Essence Food Flavou
 * and cereals muesli fruit nuts cards are turned to "Added to Cart". 5. Click on cart
 * button. 6. Verify that Sleeve Shirt Womens and ank Tops for Womens/Girls are visible on
 * the popup. 7. Verify that the prices are the same on the popup. 8. Click on "+" button
 * to increase the amount of items. 9. Verify that the amount is "2" and the total price
 * is correct.
 */

public class TM_TO_03 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testTops() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(5);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Tops category.
		homePage.clickOnCategory(8);

		// 3-) Add Sleeve Shirt Womens and cereals muesli fruit nuts to cart.
		homePage.addToCart("Sleeve Shirt Womens");
		homePage.addToCart("ank Tops for Womens/Girls");

		// 4-) Verify that buttons Orange Essence Food Flavou and cereals
		// muesli fruit nuts cards are turned to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText("Sleeve Shirt Womens"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		softAssert.assertEquals(homePage.getButtonText("ank Tops for Womens/Girls"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		// 5-) Click on cart button.
		homePage.clickOnCartButton();

		// 6-) Verify that Sleeve Shirt Womens and ank Tops for Womens/Girls are
		// visible on the popup.
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Sleeve Shirt Womens",
				"Product is not added to cart");

		softAssert.assertEquals(homePage.getProductNameOnTheCart(2), "ank Tops for Womens/Girls",
				"Product is not added to cart");

		// 7-) Verify that the prices are the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Sleeve Shirt Womens")),
				"Product price is different on the cart");

		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(2).contains(homePage.getProductPrice("ank Tops for Womens/Girls")),
				"Product price is different on the cart");

		// 8-) Click on "+" button to increase the amount of items.
		homePage.clickOnIncreaseButtonOnCart(1, 1);
		homePage.clickOnIncreaseButtonOnCart(2, 1);

		wait(2);

		// 9-) Verify that the amount is "2" and the total price is correct.
		softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "2",
				"Increase product amount button on the cart doesn't work");

		softAssert.assertEquals(homePage.getProductNumberOnTheCart(2), "2",
				"Increase product amount button on the cart doesn't work");

		int totalPrice1 = Integer.parseInt(homePage.getProductPrice("Sleeve Shirt Womens").substring(1)) * 2;
		int totalPrice2 = Integer.parseInt(homePage.getProductPrice("ank Tops for Womens/Girls").substring(1)) * 2;

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice1),
				"Total price is wrong on the cart");

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(2).contains("$" + totalPrice2),
				"Total price is wrong on the cart");

		softAssert.assertAll("Furniture test 3 could not be completed: Total price is incorrect on the cart.");

	}

}
