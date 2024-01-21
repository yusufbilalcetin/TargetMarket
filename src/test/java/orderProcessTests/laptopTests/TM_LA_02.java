package orderProcessTests.laptopTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
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
		try{

		// 1-) Navigate to ordering page.
			ExtentReportListener.getTest().info("1-) Navigate to ordering page.");
			pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

		// 2-) Click on Laptops category.
			ExtentReportListener.getTest().info(" 2-) Click on Laptops category.");
			homePage.clickOnCategory(3);

		// 3-) Find Microsoft Surface Laptop 4
			ExtentReportListener.getTest().info("3-) Find Microsoft Surface Laptop 4");
			homePage.findProduct("Microsoft Surface Laptop 4");

		// 4-) Verify that its image is displayed properly.
		// softAssert.assertTrue(homePage.isProductPictureLoadedProperly("Microsoft
		// Surface Laptop 4"),
		// "Product picture is not loaded properly");

		// 5-) Verify that its name is displayed properly.
			ExtentReportListener.getTest().info("5-) Verify that its name is displayed properly.");
			softAssert.assertEquals(homePage.getProductName("Microsoft Surface Laptop 4"), "Microsoft Surface Laptop 4",
				"Product name is not displayed properly");

		// 6-) Verify that its "Add to Cart" button is displayed properly
		// softAssert.assertTrue(homePage.isAddToCartButtonVisible("Microsoft Surface
		// Laptop 4"),
		// "Add to Cart button is not visible");
			ExtentReportListener.getTest().info(" 6-) Verify that its \"Add to Cart\" button is displayed properly\n" +
					"\t\t// softAssert.assertTrue(homePage.isAddToCartButtonVisible(\"Microsoft Surface\n" +
					"\t\t// Laptop 4\"),\n" +
					"\t\t// \"Add to Cart button is not visible\");");


			// 7-) Verify that the discount is "%10 OFF"
			ExtentReportListener.getTest().info("7-) Verify that the discount is \"%10 OFF\"");
			softAssert.assertEquals(homePage.getDiscount("Microsoft Surface Laptop 4"), "% 10 OFF",
				"Discount rate is not '%10 OFF'");

		// 8-) Add Microsoft Surface Laptop 4 to cart.
			ExtentReportListener.getTest().info("8-) Add Microsoft Surface Laptop 4 to cart.");
			homePage.addToCart("Microsoft Surface Laptop 4");

		// 9-) Verify that button in Microsoft Surface Laptop 4 card is turned to "Added
		// to Cart".
			ExtentReportListener.getTest().info("9-) Verify that button in Microsoft Surface Laptop 4 card is turned to \"Added\n" +
					"\t\t// to Cart\".");
			softAssert.assertEquals(homePage.getButtonText("Microsoft Surface Laptop 4"), "Added to Cart",
				"Text button doesn't turn to 'Added to Cart'");

		softAssert.assertAll("Laptops test 2 cannot be completed:");
		ExtentReportListener.getTest().pass("Test passed");
	}catch (Exception e) {
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
