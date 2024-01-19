package orderProcessTests.laptopTests;

import baseTest.Hooks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Laptops caregory.
// 3-) Add Samsung Galaxy Book and HP Pavilion 15-DK1056WM to cart.
// 4-) Verify that buttons in Samsung Galaxy Book and HP Pavilion 15-DK1056WM cards are tunred to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Samsung Galaxy Book and HP Pavilion 15-DK1056WM are visible on the popup.
// 7-) Verify that the prices are the same on the popup.
// 8-) Click on "+" button to increase the amount of items.
// 9-) Verify that the first product's amount is "3" and the total price is correct.
// 10-) Verify that the second product's amount is "4" and the total price is correct.
public class TM_LA_03 extends Hooks {

	@Test
	void testLaptopsOrderingMultiple() {

		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Laptops category.
		homePage.clickOnCategory(3);

		// 3-) Add Samsung Galaxy Book and HP Pavilion 15-DK1056WM to cart.
		homePage.addToCart("Samsung Galaxy Book");
		homePage.addToCart("HP Pavilion 15-DK1056WM");

		// 4-) Verify that button in MacBook Pro card is turned to "Added to Cart".
		softAssert.assertEquals(homePage.getButtonText("Samsung Galaxy Book"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");
		softAssert.assertEquals(homePage.getButtonText("HP Pavilion 15-DK1056WM"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// 5-) Click on cart button.
		homePage.clickOnCartButton();

		// 6-) Verify that Samsung Galaxy Book and HP Pavilion 15-DK1056WM are visible on
		// the popup.
		wait(2);
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Samsung Galaxy Book",
				"Product is not added to the cart");
		softAssert.assertEquals(homePage.getProductNameOnTheCart(2), "HP Pavilion 15-DK1056WM",
				"Product is not added to the cart");

		// 7-) Verify that the prices are the same on the popup.
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Samsung Galaxy Book")),
				"Product price is different on the cart");
		softAssert.assertTrue(
				homePage.getPerProductPriceOnTheCart(2).contains(homePage.getProductPrice("HP Pavilion 15-DK1056WM")),
				"Product price is different on the cart");

		// 8-) Click on "+" button twice to increase the amount of the first item to 3.
		wait(2);
		homePage.clickOnIncreaseButtonOnCart(1, 2);

		// Click on "+" button 3 times to increase the amount of the second item to 4.
		homePage.clickOnIncreaseButtonOnCart(2, 3);

		// 9-) Verify that the first product's amount is "3" and the total price is
		// correct.
		wait(2);
		softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "3",
				"Increase product amount button on the cart doesn't work");

		int totalPrice = Integer.parseInt(homePage.getProductPrice("Samsung Galaxy Book").substring(1)) * 3;
		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice),
				"The first product's total price is wrong on the cart");

		// 10-) Verify that the second product's amount is "4" and the total price is
		// correct.
		softAssert.assertEquals(homePage.getProductNumberOnTheCart(2), "4",
				"Increase product amount button on the cart doesn't work");

		int totalPrice2 = Integer.parseInt(homePage.getProductPrice("HP Pavilion 15-DK1056WM").substring(1)) * 4;
		softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(2).contains("$" + totalPrice2),
				"The second product's total price is wrong on the cart");

		softAssert.assertAll("Laptops test 3 cannot be completed:");
	}

}
