package checkOutProcessTests;

import baseTest.Hooks;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckOutPage;
import pages.TargetMarketHomePage;

import static org.testng.AssertJUnit.assertEquals;

/*
  1-)Click on TargetMarket Page
  2-)Login on TargetMarket LoginPage
  3.Navigate to TargetMarket Homepage
  4.Click on Smartphone Category
  5.Click on "Add to Cart" Button for IPhone 9
  6-)Verify that Button is turned to "Added to Cart"
  7-)Click on "Cart" Button
  8-)Verify that Iphone 9 is added to Cart
  9-)Click on "Go To CheckOut" Button
  10-)Click on "Increase (+)" Button
  11-)Verify that Iphone 9 is added to Cart for 2 times
  12-)Verify that total cost is correct and doubled
  13-)Fill valid customer information to place order
  14-)Click on "Place Order" Button
  15-)Verify that Customer name is correct on Verify Screen
  16-)Verify that total cost is  correct on Verify Screen
  17-)Verify that total amount is correct on Verify Screen


 */
public class TM_CO_01 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testCheckOutIPhone() {

		// Click on TargetMarket Page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// Login on TargetMarket LoginPage
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// Navigate to TargetMarket Homepage
		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// Click on Smartphone Category
		homePage.clickOnCategory(2);

		// Click on "Add to Cart" Button for IPhone 9
		homePage.addToCart("iPhone 9");

		// Verify that Button is turned to "Added to Cart"
		softAssert.assertEquals(homePage.getButtonText("iPhone 9"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// Click on "Cart" Button
		homePage.clickOnCartButton();
		wait(2);

		// Verify that Iphone 9 is added to Cart
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "iPhone 9", "Product is not added to the cart");

		// Click on "Go To CheckOut" Button
		homePage.clickOnGoToCheckoutButton();
		wait(1);

		CheckOutPage checkOutPage = new CheckOutPage();

		// Click on "Increase (+)" Button
		checkOutPage.clickOnIncreaseButton();

		// Verify that Iphone 9 is added to Cart for 2 times
		String expectedproductName = "iPhone 9 x 2";
		String actualProductName = checkOutPage.getProductNameOnCheckoutPage();
		assertEquals(actualProductName, expectedproductName);

		// Verify that total cost is correct and doubled
		int totalPriceOnCheckOutPage = Integer.parseInt(checkOutPage.getUnitPriceOnCheckOutPage()) * 2;
		assertEquals(1098, totalPriceOnCheckOutPage);

		// Fill valid customer information to place order
		checkOutPage.fillOrderInformation("Ross", "Barkley", "187 Downing St.", "1111222233334444", "1234567890");

		// Click on "Place Order" Button
		checkOutPage.clickOnPlaceOrderButton();
		wait(1);

		// Verify that Customer name is correct on Verify Screen
		assertEquals(checkOutPage.getfullNameToVerify("Ross", "Barkley"),
				checkOutPage.getVerifyOrderScreenNameText().getText());

		// Verify that total cost is correct on Verify Screen
		assertEquals(checkOutPage.getTotalCostToVerify("1098.00"),
				checkOutPage.getVerifyOrderScreenTotalCostText().getText());

		// Verify that total amount is correct on Verify Screen
		assertEquals(checkOutPage.getTotalAmountToVerify("2"),
				checkOutPage.getVerifyOrderScreenTotalAmountText().getText());

	}

}
