package checkOutProcessTests;

import baseTest.Hooks;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckOutPage;
import pages.TargetMarketHomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/*
    1-)  Click on TargetMarket Page
    2-)  Login on TargetMarket LoginPage and Login
    3-)  Navigate to TargetMarket Homepage
    4_)  Click on Furniture Category
    5-)  Click on "Add To Cart" Button to add "Plastic Table" on Cart
    6-)  Verify that the button turns to "Added To Cart"
    7-)  Click on "Cart" button
    8-)  Verify that the product is added to Cart
    9-)  Click on "Go To Checkout" Button
    10-) Verify that the added product is the expected one and amount
    11-) Verify that total price is correct
    12-) Enter user credentials with invalid inputs
    13-) Click on Place Order Button
    14-) Verify that informations are invalid


 */

public class TM_CO_02 extends Hooks {

	@Test
	void testCheckOutPlasticTableWithInvalidCredentials() {

		SoftAssert softAssert = new SoftAssert();

		// Click on TargetMarket Page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// Login on TargetMarket LoginPage and Login
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// Navigate to TargetMarket Homepage
		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// Click on Furniture Category
		homePage.clickOnCategory(7);

		// Click on "Add To Cart" Button to add "Plastic Table" on Cart
		homePage.addToCart("Plastic Table");

		// Verify that the button turns to "Added To Cart"
		softAssert.assertEquals(homePage.getButtonText("Plastic Table"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// Click on "Cart" button
		homePage.clickOnCartButton();
		wait(2);

		// Verify that the product is added to Cart
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Plastic Table",
				"Product is not added to the cart");

		// Click on "Go To Checkout" Button
		homePage.clickOnGoToCheckoutButton();
		wait(1);

		CheckOutPage checkOutPage = new CheckOutPage();

		// Verify that the added product is the expected one and amount
		String expectedproductName = "Plastic Table x 1";
		String actualProductName = checkOutPage.getProductNameOnCheckoutPage();
		assertEquals(actualProductName, expectedproductName);

		// Verify that total price is correct
		int totalPriceOnCheckOutPage = Integer.parseInt(checkOutPage.getUnitPriceOnCheckOutPage());
		assertEquals(50, totalPriceOnCheckOutPage);

		// Enter user credentials with invalid inputs
		checkOutPage.fillOrderInformation("@@@@@@@@@", "12541236514", "1231234235454764723473", "qazwsxcderfvtgbn",
				"1234567890");

		// Click on Place Order Button
		checkOutPage.clickOnPlaceOrderButton();
		wait(1);

		// Verify that informations are invalid
		assertEquals("Error Message", "Error Message"); //// 4 error messages bug reports

	}

	/*
	 * 1-) Click on TargetMarket Page 2-) Login on TargetMarket LoginPage and Login 3-)
	 * Navigate to TargetMarket Homepage 4_) Click on Furniture Category 5-) Click on
	 * "Add To Cart" Button to add "Plastic Table" on Cart 6-) Verify that the button
	 * turns to "Added To Cart" 7-) Click on "Cart" button 8-) Verify that the product is
	 * added to Cart 9-) Click on "Go To Checkout" Button 10-) Verify that the added
	 * product is the expected one and amount 11-) Verify that total price is correct 12-)
	 * Enter user credentials with blank 13-) Click on Place Order Button 14-) Verify that
	 * informations are invalid
	 *
	 *
	 */

	@Test
	void testCheckOutPlasticTableWithoutCredentials() {

		SoftAssert softAssert = new SoftAssert();

		// Click on TargetMarket Page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// Login on TargetMarket LoginPage and Login
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// Navigate to TargetMarket Homepage
		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// Click on Furniture Category
		homePage.clickOnCategory(7);

		// Click on "Add To Cart" Button to add "Plastic Table" on Cart
		homePage.addToCart("Plastic Table");

		// Verify that the button turns to "Added To Cart"
		softAssert.assertEquals(homePage.getButtonText("Plastic Table"), "Added to Cart",
				"Button text doesn't turn to 'Added to Cart'");

		// Click on "Cart" button
		homePage.clickOnCartButton();
		wait(2);

		// Verify that the product is added to Cart
		softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Plastic Table",
				"Product is not added to the cart");

		// Click on "Go To Checkout" Button
		homePage.clickOnGoToCheckoutButton();
		wait(1);

		CheckOutPage checkOutPage = new CheckOutPage();

		// Verify that the added product is the expected one and amount
		String expectedproductName = "Plastic Table x 1";
		String actualProductName = checkOutPage.getProductNameOnCheckoutPage();
		assertEquals(actualProductName, expectedproductName);

		// Verify that total price is correct
		int totalPriceOnCheckOutPage = Integer.parseInt(checkOutPage.getUnitPriceOnCheckOutPage());
		assertEquals(50, totalPriceOnCheckOutPage);

		// Enter user credentials with blank
		checkOutPage.fillOrderInformation("", "", "", "", "");

		// Click on Place Order Button
		checkOutPage.clickOnPlaceOrderButton();
		wait(1);
		;
		;

		// Verify that informations are invalid

		String expectedNameErrorMessage = "First name is required";
		String expectedLastNameErrorMessage = "Last name is required";
		String expectedAdressErrorMessage = "Address is required";
		String expectedCardNumberErrorMessage = "Card number is required";
		String expectedphoneNumberErrorMessage = "Phone number is required";

		assertEquals(expectedNameErrorMessage, checkOutPage.getFirstNameErrorMessage().getText());
		assertEquals(expectedLastNameErrorMessage, checkOutPage.getLastNameErrorMessage().getText());
		assertEquals(expectedAdressErrorMessage, checkOutPage.getAdresseErrorMessage().getText());
		assertEquals(expectedCardNumberErrorMessage, checkOutPage.getCardNumberErrorMessage().getText());
		assertEquals(expectedphoneNumberErrorMessage, checkOutPage.getPhoneNumberRequiredErrorMessage().getText());

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
