package homePageTest;

import baseTest.Hooks;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on "Smartphones"
// 3-) Verify that all the items are in the smartphone category
// 4-) Click on "Laptops"
// 5-) Verify that all the items are in the laptop category
// 6-) Click on "Skincare"
// 7-) Verify that all the items are in the skincare category
// 8-) Click on "Groceries"
// 9-) Verify that all the items are in the groceries category.
public class TM_OP_03 extends Hooks {

	@Test
	public void testItemsListingFunctionality() {
		SoftAssert softAssert = new SoftAssert();
		// 1-) Navigate to ordering page.
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		wait(3);
		TargetMarketHomePage homePage = pages.getTargetMarketHomePage();
		wait(5);
		for (int i = 1; i < 10; i++) {
			homePage.clickOnCategory(i);
			softAssert.assertTrue(homePage.areItemsListedCategorically(i),
					"Category(index" + i + ") is listed non-categorically");
			wait(1);
		}
		// homePage.clickOnCategory(1);
		// softAssert.assertTrue(homePage.areItemsListedCategorically(1),"");
		softAssert.assertAll("Homepage test fails");

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
