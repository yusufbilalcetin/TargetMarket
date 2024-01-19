package orderProcessTests.laptopTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Laptops caregory.
// 3-) Find Microsoft Surface Laptop 4
// 4-) Verify that its image is displayed properly.
// 5-) Verify that its name is displayed properly.
// 6-) Verify that its "Add to Cart" button is displayed properly
// 7-) Verify that the discount is "%10"
// 8-) Add Microsoft Surface Laptop 4 to cart.
// 9-) Verify that button in Microsoft Surface Laptop 4 card is tunred to "Added to Cart".
public class TM_LA_02 extends Hooks {

	@Test
	void testLaptopsUIElements() {

		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Laptops category.
		homePage.clickOnCategory(3);

		// 3-) Find Microsoft Surface Laptop 4
		homePage.findProduct("Microsoft Surface Laptop 4");

		// 4-) Verify that its image is displayed properly.
		softAssert.assertTrue(homePage.isProductPictureLoadedProperly("Microsoft Surface Laptop 4"),
				"Product picture is not loaded properly");

		// 5-) Verify that its name is displayed properly.
		softAssert.assertEquals(homePage.getProductName("Microsoft Surface Laptop 4"), "Microsoft Surface Laptop 4",
				"Product name is not displayed properly");

		// 6-) Verify that its "Add to Cart" button is displayed properly
		softAssert.assertTrue(homePage.isAddToCartButtonVisible("Microsoft Surface Laptop 4"),
				"Add to Cart button is not visible");

		// 7-) Verify that the discount is "%10 OFF"
		softAssert.assertEquals(homePage.getDiscount("Microsoft Surface Laptop 4"), "% 10 OFF",
				"Discount rate is not '%10 OFF'");

		// 8-) Add Microsoft Surface Laptop 4 to cart.
		homePage.addToCart("Microsoft Surface Laptop 4");

		// 9-) Verify that button in Microsoft Surface Laptop 4 card is turned to "Added
		// to Cart".
		softAssert.assertEquals(homePage.getButtonText("Microsoft Surface Laptop 4"), "Added to Cart",
				"Text button doesn't turn to 'Added to Cart'");

		softAssert.assertAll("Laptops test 2 cannot be completed:");
	}

}