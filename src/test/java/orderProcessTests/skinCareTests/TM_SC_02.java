package orderProcessTests.skinCareTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
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
        try{

		// 1-) Navigate to ordering page.
            ExtentReportListener.getTest().info("1-) Navigate to ordering page.");

            pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		pages.getTargetMarketHomePage().clickOnCategory(4);
            ExtentReportListener.getTest().pass("Test passed");
		;
	}catch (Exception e) {
            // If any exception occurs, report the test as failed
            ExtentReportListener.getTest().fail("Test failed");
        }
    }

	@Test(priority = 2)

	void testSkinBeautySerumImage() {
            try{

		goToHomePageAndChooseSkincare();

		// 3-) Find Skin Beauty Serum.
                ExtentReportListener.getTest().info("3-) Find Skin Beauty Serum.");

                pages.getTargetMarketHomePage().findProduct("Skin Beauty Serum.");
            ExtentReportListener.getTest().pass("Test passed");

		// 4-) Verify that its image is displayed properly.
		// softAssert.assertTrue(pages.getTargetMarketHomePage().isProductPictureLoadedProperly("Skin
		// Beauty Serum."),
		// "Product picture is not loaded properly");
                ExtentReportListener.getTest().info("4-) Verify that its image is displayed properly.\n" +
                        "\t\t// softAssert.assertTrue(pages.getTargetMarketHomePage().isProductPictureLoadedProperly(\"Skin\n" +
                        "\t\t// Beauty Serum.\"),\n" +
                        "\t\t// \"Product picture is not loaded properly\");");

            }catch (Exception e) {
                // If any exception occurs, report the test as failed
                ExtentReportListener.getTest().fail("Test failed");
            }
    }

	@Test(priority = 3)
	void checkSkinBeautySerumNameButton() {
            try{

		goToHomePageAndChooseSkincare();
		// 5-) Verify that its name is displayed properly.
                ExtentReportListener.getTest().info("5-) Verify that its name is displayed properly.");
                softAssert.assertEquals(pages.getTargetMarketHomePage().getProductName("Skin Beauty Serum."),
				"Skin Beauty Serum.", "Product name is not displayed properly");
            ExtentReportListener.getTest().pass("Test passed");

		// 6-) Verify that its "Add to Cart" button is displayed properly
		// softAssert.assertTrue(pages.getTargetMarketHomePage().isAddToCartButtonVisible("Skin
		// Beauty Serum."),
		// "Add to Cart button is not visible");
                ExtentReportListener.getTest().info("6-) Verify that its \"Add to Cart\" button is displayed properly\n" +
                        "\t\t// softAssert.assertTrue(pages.getTargetMarketHomePage().isAddToCartButtonVisible(\"Skin\n" +
                        "\t\t// Beauty Serum.\"),\n" +
                        "\t\t// \"Add to Cart button is not visible\");");

            }catch (Exception e) {
        // If any exception occurs, report the test as failed
        ExtentReportListener.getTest().fail("Test failed");
    }
}

	@Test(priority = 4)
	void checkSkinBeautySerumDiscount() {
            try{

		goToHomePageAndChooseSkincare();
		// 7-) Verify that the discount is "% 11 OFF"
                ExtentReportListener.getTest().info("7-) Verify that the discount is \"% 11 OFF\"");
                softAssert.assertEquals(pages.getTargetMarketHomePage().getDiscount("Skin Beauty Serum."), "% 11 OFF",
				"Discount rate is not '%10 OFF'");
            ExtentReportListener.getTest().pass("Test passed");
	}catch (Exception e) {
                // If any exception occurs, report the test as failed
                ExtentReportListener.getTest().fail("Test failed");
            }
    }

	@Test(priority = 5)
	void checkSkinBeautySerumAddCartFunction() {
            try{

		goToHomePageAndChooseSkincare();
		// 8-) Add Skin Beauty Serum. to cart.
                ExtentReportListener.getTest().info("8-) Add Skin Beauty Serum. to cart.");
                pages.getTargetMarketHomePage().addToCart("Skin Beauty Serum.");

		// 9-) Verify that button in Skin Beauty Serum. card is turned to "Added to Cart".
                ExtentReportListener.getTest().info(" 9-) Verify that button in Skin Beauty Serum. card is turned to \"Added to Cart\".");
                softAssert.assertEquals(pages.getTargetMarketHomePage().getButtonText("Skin Beauty Serum."), "Added to Cart",
				"Text button doesn't turn to 'Added to Cart'");

		softAssert.assertAll("Skincare test 2 cannot be completed:");
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
