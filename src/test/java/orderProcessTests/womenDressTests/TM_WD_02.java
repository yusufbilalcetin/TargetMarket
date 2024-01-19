package orderProcessTests.womenDressTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;
// 1-) Navigate to ordering page.
// 2-) Click on Woman Dresses category.
//3-) Add Night Suit Dress
// 4-) Verify that buttons Night Suit is turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Night Suit is visible on the popup.
// 7-) Verify that the prices are the same on the popup.
public class TM_WD_02 extends Hooks {
    SoftAssert softAssert = new SoftAssert();

    @Test
    void testVerifyPrice() {

        // 1-) Navigate to ordering page.
        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
        wait(5);

        TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

        // 2-) Click on Woman Dresses category.
        homePage.clickOnCategory(9);

        //3-) Add Night Suit Dress

        homePage.addToCart("NIGHT SUIT");

        // 4-) Verify that buttons Night Suit is turned to "Added to Cart".

        softAssert.assertEquals(homePage.getButtonText("NIGHT SUIT"), "Added to Cart",
                "Button text does not turn to 'Added to Cart'");

        // 5-) Click on cart button.
        homePage.clickOnCartButton();

        // 6-) Verify that Night Suit is visible on the popup.

        softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "NIGHT SUIT",
                "Product is not added to cart");

        // 7-) Verify that the prices are the same on the popup.
        softAssert.assertTrue(
                homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("NIGHT SUIT")),
                "Product price is different on the cart");


    }
}