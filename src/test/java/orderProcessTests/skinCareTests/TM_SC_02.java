package orderProcessTests.skinCareTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Skincare category.
// 3-) Find Skin Beauty Serum.
// 4-) Verify that its image is displayed properly.
// 5-) Verify that its name is displayed properly.
// 6-) Verify that its "Add to Cart" button is displayed properly
// 7-) Verify that the discount is "%11"
// 8-) Add "Skin Beauty Serum." to cart.
// 9-) Verify that button in "Skin Beauty Serum." card is turned to "Added to Cart".

public class TM_SC_02 extends Hooks {

	void goToHomePageAndChooseSkincare() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		pages.getTargetMarketHomePage().clickOnCategory(4);
		;
	}

	@Test(priority = 2)
	void testSkinBeautySerumImage() {
		goToHomePageAndChooseSkincare();

		// 3-) Find Skin Beauty Serum.
		pages.getTargetMarketHomePage().findProduct("Skin Beauty Serum.");

		// 4-) Verify that its image is displayed properly.
		// softAssert.assertTrue(pages.getTargetMarketHomePage().isProductPictureLoadedProperly("Skin
		// Beauty Serum."),
		// "Product picture is not loaded properly");
	}

	@Test(priority = 3)
	void checkSkinBeautySerumNameButton() {
		goToHomePageAndChooseSkincare();
		// 5-) Verify that its name is displayed properly.
		softAssert.assertEquals(pages.getTargetMarketHomePage().getProductName("Skin Beauty Serum."),
				"Skin Beauty Serum.", "Product name is not displayed properly");

		// 6-) Verify that its "Add to Cart" button is displayed properly
		// softAssert.assertTrue(pages.getTargetMarketHomePage().isAddToCartButtonVisible("Skin
		// Beauty Serum."),
		// "Add to Cart button is not visible");
	}

	@Test(priority = 4)
	void checkSkinBeautySerumDiscount() {
		goToHomePageAndChooseSkincare();
		// 7-) Verify that the discount is "% 11 OFF"
		softAssert.assertEquals(pages.getTargetMarketHomePage().getDiscount("Skin Beauty Serum."), "% 11 OFF",
				"Discount rate is not '%10 OFF'");
	}

	@Test(priority = 5)
	void checkSkinBeautySerumAddCartFunction() {
		goToHomePageAndChooseSkincare();
		// 8-) Add Skin Beauty Serum. to cart.
		pages.getTargetMarketHomePage().addToCart("Skin Beauty Serum.");

		// 9-) Verify that button in Skin Beauty Serum. card is turned to "Added to Cart".
		softAssert.assertEquals(pages.getTargetMarketHomePage().getButtonText("Skin Beauty Serum."), "Added to Cart",
				"Text button doesn't turn to 'Added to Cart'");

		softAssert.assertAll("Skincare test 2 cannot be completed:");
	}

}
