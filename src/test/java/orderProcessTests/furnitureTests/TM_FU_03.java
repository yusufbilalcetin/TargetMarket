package orderProcessTests.furnitureTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

/**
 * 1-) Navigate to ordering page. 2-) Click on Furniture category. 3-) Add Mornadi Velvet
 * Bed and Sofa for Coffe Cafe to cart. 4-) Verify that buttons Orange Essence Food Flavou
 * and cereals muesli fruit nuts cards are turned to "Added to Cart". 5-) Click on cart
 * button. 6-) Verify that Orange Essence Food Flavou and cereals muesli fruit nuts are
 * visible on the popup. 7-) Verify that the prices are the same on the popup. 8-) Click
 * on "+" button to increase the amount of items. 9-) Verify that the amount is "2" and
 * the total price is correct.
 */
public class TM_FU_03 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testFurniture() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(5);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Furniture category.
		homePage.clickOnCategory(7);

		// 3-) Add Mornadi Velvet Bed and Sofa for Coffe Cafe to cart.
		homePage.addToCart("Mornadi Velvet Bed");
		homePage.addToCart("Sofa for Coffe Cafe");

		// 4-) Verify that buttons Mornadi Velvet Bed and Sofa for Coffe Cafe
		// cards are turned to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText("Mornadi Velvet Bed"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		softAssert.assertEquals(homePage.getButtonText("Sofa for Coffe Cafe"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		// 5-) Click on cart button.
		homePage.clickOnCartButton();

		// 6-) Verify that Mornadi Velvet Bed and Sofa for Coffe Cafe are
		// visible on the popup.
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Mornadi Velvet Bed",
				"Product is not added to cart");

		softAssert.assertEquals(homePage.getProductNameOnTheCart(2), "Sofa for Coffe Cafe",
				"Product is not added to cart");

		// 7-) Verify that the prices are the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Mornadi Velvet Bed")),
				"Product price is different on the cart");

		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(2).contains(homePage.getProductPrice("Sofa for Coffe Cafe")),
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

		int totalPrice1 = Integer.parseInt(homePage.getProductPrice("Mornadi Velvet Bed").substring(1)) * 2;
		int totalPrice2 = Integer.parseInt(homePage.getProductPrice("Sofa for Coffe Cafe").substring(1)) * 2;

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice1),
				"Total price is wrong on the cart");

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(2).contains("$" + totalPrice2),
				"Total price is wrong on the cart");

		softAssert.assertAll("Furniture test 3 could not be completed: Total price is incorrect on the cart.");

	}

}
