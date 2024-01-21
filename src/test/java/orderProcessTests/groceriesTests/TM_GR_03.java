package orderProcessTests.groceriesTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Groceries  category.
// 3-) Add Orange Essence Food Flavou and cereals muesli fruit nuts to cart.
// 4-) Verify that buttons Orange Essence Food Flavou  and cereals muesli fruit nuts cards
// are turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Orange Essence Food Flavou  and cereals muesli fruit nuts are
// visible on the popup.
// 7-) Verify that the prices are the same on the popup.
// 8-) Click on "+" button to increase the amount of items.
// 9-) Verify that the amount is "2" and the total price is correct.
@Listeners(ExtentReportListener.class)
public class TM_GR_03 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testGroceries() {
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(5);

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Groceries category.
		homePage.clickOnCategory(5);

		// 3-) Add Orange Essence Food Flavou and cereals muesli fruit nuts to cart.
		homePage.addToCart("Orange Essence Food Flavou");
		homePage.addToCart("cereals muesli fruit nuts");

		// 4-) Verify that buttons Orange Essence Food Flavou and cereals
		// muesli fruit nuts cards are turned to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText("Orange Essence Food Flavou"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		softAssert.assertEquals(homePage.getButtonText("cereals muesli fruit nuts"), "Added to Cart",
				"Button text does not turn to 'Added to Cart'");

		// 5-) Click on cart button.
		homePage.clickOnCartButton();

		// 6-) Verify that Orange Essence Food Flavou and cereals muesli fruit nuts are
		// visible on the popup.
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Orange Essence Food Flavou",
				"Product is not added to cart");

		softAssert.assertEquals(homePage.getProductNameOnTheCart(2), "cereals muesli fruit nuts",
				"Product is not added to cart");

		// 7-) Verify that the prices are the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1)
					.contains(homePage.getProductPrice("Orange Essence Food Flavou")),
				"Product price is different on the cart");

		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(2).contains(homePage.getProductPrice("cereals muesli fruit nuts")),
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

		int totalPrice1 = Integer.parseInt(homePage.getProductPrice("Orange Essence Food Flavou").substring(1)) * 2;
		int totalPrice2 = Integer.parseInt(homePage.getProductPrice("cereals muesli fruit nuts").substring(1)) * 2;

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice1),
				"Total price is wrong on the cart");

		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(2).contains("$" + totalPrice2),
				"Total price is wrong on the cart");

		softAssert.assertAll("Groceries test 3 cannot be completed:");
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
