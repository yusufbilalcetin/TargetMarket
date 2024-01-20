package orderProcessTests.homeDecorationTests;

import baseTest.Hooks;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Home Decoration category.
// 3-) Add Flying Wooden Bird and 3D Embellishment Art Lamp to cart.
// 4-) Verify that buttons Flying Wooden Bird and 3D Embellishment Art Lamp cards are turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Flying Wooden Bird and 3D Embellishment Art Lamp are visible on the popup.
// 7-) Verify that the prices are the same on the popup.
// 8-) Click on "+" button to increase the amount of items.
// 9-) Verify that the amount is "2" and the total price is correct.

public class TM_HD_03 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testHomeDecorations() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(3);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		wait(2);

		// 2-) Click on Home Decoration category.
		homePage.clickOnCategory(6);

		wait(2);

		// 3-) Add Flying Wooden Bird and 3D Embellishment Art Lamp to cart.
		homePage.addToCart("Flying Wooden Bird");
		homePage.addToCart("3D Embellishment Art Lamp");

		// 4-) Verify that buttons Flying Wooden Bird and 3D Embellishment Art Lamp
		// cards are turned to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText("Flying Wooden Bird"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		softAssert.assertEquals(homePage.getButtonText("3D Embellishment Art Lamp"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		// 5-) Click on cart button.
		homePage.clickOnCartButton();

		// 6-) Verify that Flying Wooden Bird and 3D Embellishment Art Lamp are
		// visible on the popup.
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Flying Wooden Bird",
				"Product is not added to cart");

		softAssert.assertEquals(homePage.getProductNameOnTheCart(2), "3D Embellishment Art Lamp",
				"Product is not added to cart");

		// 7-) Verify that the prices are the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Flying Wooden Bird")),
				"Product price is different on the cart");

		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(2).contains(homePage.getProductPrice("3D Embellishment Art Lamp")),
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

		int totalPrice1 = Integer.parseInt(homePage.getProductPrice("Flying Wooden Bird").substring(1)) * 2;
		int totalPrice2 = Integer.parseInt(homePage.getProductPrice("3D Embellishment Art Lamp").substring(1)) * 2;

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice1),
				"Total price is wrong on the cart");

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(2).contains("$" + totalPrice2),
				"Total price is wrong on the cart");

		softAssert.assertAll("Home Decorations test 3 cannot be completed:");
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
