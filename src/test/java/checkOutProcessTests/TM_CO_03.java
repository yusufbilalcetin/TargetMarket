package checkOutProcessTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckOutPage;
import pages.TargetMarketHomePage;

import static org.testng.AssertJUnit.assertEquals;

/*
    1-)  Click on TargetMarket Page
    2-)  Login on TargetMarket LoginPage
    3-)  Navigate to TargetMarket Homepage
    4-)  Click on Smartphone Category
    5-)  Click on "Add to Cart" Button for IPhone 9
    6-)  Verify that Button is turned to "Added to Cart"
    7-)  Scroll up the Page
    8-)  Click on Furniture Category
    9-)  Click on "Add To Cart" Button to add "Plastic Table" on Cart
    10-)  Verify that the button turns to "Added To Cart"
    11-) Click on "Cart" Button
    12-) Verify that Iphone 9 is added to Cart
    13-) Verify that Plastic Table is added to Cart
    14-) Click on "Go To CheckOut" Button
    15-) Verify that Iphone 9 is added to Cart for 2 times
    16-) Verify that Plastic Table is the expected one and amount
    17-) Verify that total cost is correct
    18-) Fill valid customer information to place order
    19-) Click on Place Order Button
    20-) Verify that Customer name is correct on Verify Screen
    21-) Verify that total cost is correct on Verify Screen
    22-) Verify that total amount is correct on Verify Screen


 */

public class TM_CO_03 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testCheckOutMultipleProducts() {

		// Click on TargetMarket Page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// Login on TargetMarket LoginPage
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// Navigate to TargetMarket Homepage
		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		CheckOutPage checkOutPage = new CheckOutPage();

		// Click on Smartphone Category
		homePage.clickOnCategory(2);

		// Click on "Add to Cart" Button for IPhone 9
		homePage.addToCart("iPhone 9");

		// Verify that Button is turned to "Added to Cart"
		softAssert.assertEquals(homePage.getButtonText("iPhone 9"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// Scroll up the Page
		checkOutPage.scrollUpWithPageUp();

		// Click on Furniture Category
		homePage.clickOnCategory(7);

		// Click on "Add To Cart" Button to add "Plastic Table" on Cart
		homePage.addToCart("Plastic Table");

		// Verify that the button turns to "Added To Cart"
		softAssert.assertEquals(homePage.getButtonText("Plastic Table"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// Click on "Cart" Button
		homePage.clickOnCartButton();
		wait(2);

		// Verify that Iphone 9 is added to Cart
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "iPhone 9", "Product is not added to the cart");

		// Verify that Plastic Table is added to Cart
		softAssert.assertEquals(homePage.getProductNameOnTheCart(2), "Plastic Table",
				"Product is not added to the cart");

		// Click on "Go To CheckOut" Button
		homePage.clickOnGoToCheckoutButton();
		wait(1);

		// Click on "Increase (+)" Button
		checkOutPage.clickOnIncreaseButton();
		wait(3);

		// Verify that Iphone 9 is added to Cart for 2 times
		String expectedproductName = "iPhone 9 x 2";
		String actualProductName = checkOutPage.getProductNameOnCheckoutPage();
		assertEquals(actualProductName, expectedproductName);

		// Verify that Plastic Table is the expected one and amount
		String expectedproductName2 = "Plastic Table x 1";
		String actualProductName2 = checkOutPage.getSecondProductNameOnCheckoutPage();
		assertEquals(actualProductName2, expectedproductName2);

		// Verify that total cost is correct
		double totalPriceOnCheckOutPage = Double.parseDouble(checkOutPage.getTotalPrice());
		assertEquals(1148.00, totalPriceOnCheckOutPage);

		// Fill valid customer information to place order
		checkOutPage.fillOrderInformation("Ross", "Barkley", "187 Downing St.", "1111222233334444", "1234567890");

		// Click on Place Order Button
		checkOutPage.clickOnPlaceOrderButton();
		wait(1);

		// Verify that Customer name is correct on Verify Screen
		assertEquals(checkOutPage.getfullNameToVerify("Ross", "Barkley"),
				checkOutPage.getVerifyOrderScreenNameText().getText());

		// Verify that total cost is correct on Verify Screen
		assertEquals(checkOutPage.getTotalCostToVerify("1148.00"),
				checkOutPage.getVerifyOrderScreenTotalCostText().getText());

		// Verify that total amount is correct on Verify Screen
		assertEquals(checkOutPage.getTotalAmountToVerify("3"),
				checkOutPage.getVerifyOrderScreenTotalAmountText().getText());

	}

}
