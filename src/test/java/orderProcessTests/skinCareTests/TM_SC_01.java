package orderProcessTests.skinCareTests;

import baseTest.Hooks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Skincare category.
// 3-) Verify each product's discount is correct
// 4-) Add each skincare product to cart.
// 5-) Verify that button in the related card is tunred to "Added to Cart".
// 6-) Click on cart button.
// 7-) Verify that the product is visible on the popup.
// 8-) Verify that its price is the same on the popup.
// 9-) Click on "+" button to increase the amount of item.
// 10-) Verify that the amount is "2" and the total price is correct.
public class TM_SC_01 extends Hooks {

	@DataProvider(name = "products")
	public String[][] provideProducts() {
		return new String[][] { { "Hyaluronic Acid Serum", "$19", "% 13 OFF" }, { "Tree Oil 30ml", "$12", "% 4 OFF" },
				{ "Oil Free Moisturizer 100ml", "$40", "% 13 OFF" }, { "Skin Beauty Serum.", "$46", "% 11 OFF" },
				{ "Freckle Treatment Cream- 15gm", "$70", "% 17 OFF" } };
	}

	@Test(dataProvider = "products")
	void testSkinCareOrderingMultiple(String product, String price, String discount) {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Laptops category.
		homePage.clickOnCategory(4);

		// 3-) Verify each product's discount is correct
		softAssert.assertEquals(homePage.getDiscount(product), discount,
				"Discount rate is not correct for the " + product);

		// 4-) Add each skincare product to cart.
		homePage.addToCart(product);

		// 5-) Verify that button in the related card is tunred to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText(product), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart' for " + product);

		// 6-) Click on cart button.
		homePage.clickOnCartButton();

		// 7-) Verify that the product is visible on the popup.
		wait(2);
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), product, product + " is not added to the cart");
		;

		// 8-) Verify that its price is the same on the popup.
		softAssert.assertTrue(homePage.getPerProductPriceOnTheCart(1).contains(price),
				product + " price is different on the cart");

		// 9-) Click on "+" button twice to increase the amount of item to 3.
		wait(2);
		homePage.clickOnIncreaseButtonOnCart(1, 2);

		// 10-) Verify that the amount is "3" and the total price is correct.
		wait(2);
		softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "3",
				"Increase product amount button on the cart doesn't work");

		int totalPrice = Integer.parseInt(price.substring(1)) * 3;
		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice),
				"Total price is wrong on the cart");

		softAssert.assertAll("Skincare test 1 cannot be completed:");
	}

}
