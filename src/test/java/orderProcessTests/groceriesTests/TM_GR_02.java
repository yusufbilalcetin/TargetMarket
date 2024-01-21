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
// 2-) Click on Groceries category.
// 3-) Add Orange Essence Food Flavou to cart.
// 4-) Verify that button in Orange Essence Food Flavou card is turned to "Added to Cart".
// 5-) Verify that discount number is correct
// 6-) Click on cart button.
// 7-) Verify that   Orange Essence Food Flavou is visible on the popup.
// 8-) Verify that the price is the same on the popup.
// 9-) Click on "-" button to decrease the amount of item.
//10-) Verify that 'Your cart is empty' message
//11-)Click close button on the cart empty message popup
//12-)Verify that button in Orange Essence Food Flavou card is turned to "Add to Cart".
@Listeners(ExtentReportListener.class)
public class TM_GR_02 extends Hooks {

	SoftAssert softAssert = new SoftAssert();

	@Test
	void testGroceries() {
        try {
            // 1-) Navigate to ordering page.
            ExtentReportListener.getTest().info(" 1-) Navigate to ordering page.");

            pages.getInarAcademyHomePage().clickOnTargetMarketLink();
            pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
            wait(5);

            TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

            // 2-) Click on Groceries caregory.
            ExtentReportListener.getTest().info(" 2-) Click on Groceries caregory.");
            homePage.clickOnCategory(5);

            // 3-) Add Elbow Macaroni to cart.
            ExtentReportListener.getTest().info(" 3-) Add Elbow Macaroni to cart.");
            homePage.addToCart("Orange Essence Food Flavou");

            // 4-) Verify that button in Elbow Macaroni card is turned to "Added to Cart".
            ExtentReportListener.getTest().info(" 4-) Verify that button in Elbow Macaroni card is turned to \"Added to Cart\".");
            softAssert.assertEquals(homePage.getButtonText("Orange Essence Food Flavou"), "Added to Cart",
                    "Button text does not turn to 'Added to Cart'");

            // 5-) Verify that discount number is correct
            ExtentReportListener.getTest().info(" 5-) Verify that discount number is correct");
            softAssert.assertEquals(homePage.getDiscount("Orange Essence Food Flavou"), "% 8 OFF",
                    "Discount number is not correct");

            // 6-) Click on cart button.
            ExtentReportListener.getTest().info("  6-) Click on cart button.");
            homePage.clickOnCartButton();

            // 7-) Verify that Orange Essence Food Flavou is visible on the popup.
            ExtentReportListener.getTest().info("  7-) Verify that Orange Essence Food Flavou is visible on the popup.");
            softAssert.assertEquals(homePage.getProductNameOnTheCart(1),
                    homePage.getProductName("Orange Essence Food Flavou"), "Product is not added to the cart");

            // 8-) Verify that the price is the same on the popup.
            ExtentReportListener.getTest().info(" 8-) Verify that the price is the same on the popup.");
            softAssert.assertTrue(
                    homePage.getPerProductPriceOnTheCart(1)
                            .contains(homePage.getProductPrice("Orange Essence Food Flavou")),
                    "Product price is different on the cart");

            // 9-) Click on "-" button to decrease the amount of item.
            ExtentReportListener.getTest().info("9-) Click on \"-\" button to decrease the amount of item.");
            homePage.clickOnDecreaseButtonOnCart(1, 1);

            // 10-) Verify that 'Your cart is empty' message
            ExtentReportListener.getTest().info("10-) Verify that 'Your cart is empty' message");
            softAssert.assertEquals(homePage.getCartEmptyText(), "Your cart is empty.",
                    "Product can not be removed from cart");

            // 11-)Click close button on the cart empty message popup
            ExtentReportListener.getTest().info("11-)Click close button on the cart empty message popup");
            homePage.clickCartEmptyCloseButton();

            // 12-)Verify that button in Orange Essence Food Flavou card is turned to "Add to
            // Cart".
            ExtentReportListener.getTest().info(" // 12-)Verify that button in Orange Essence Food Flavou card is turned to \"Add to\n" +
                    "            // Cart\".");
            softAssert.assertEquals(homePage.getButtonText("Orange Essence Food Flavou"), "Add to Cart",
                    "Button text does not turn to 'Add to Cart'");

            softAssert.assertAll("Groceries test 2 cannot be completed:");
            ExtentReportListener.getTest().pass("Test passed");
        } catch (Exception e) {
            // If any exception occurs, report the test as failed
            ExtentReportListener.getTest().fail("Test failed");
        }
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
