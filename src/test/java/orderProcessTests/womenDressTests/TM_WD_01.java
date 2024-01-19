package orderProcessTests.womenDressTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;
// 1-) Navigate to ordering page.
// 2-) Click on Woman Dresses.
// 3-) Add Ladies Multicolored Dresses.
// 4-) Verify that button in Ladies Multicolored Dresses card is turned to "Added to Cart".
public class TM_WD_01 extends Hooks {

    SoftAssert softAssert = new SoftAssert();

    @Test
    void testWomenDresses() {
        // 1-) Navigate to ordering page.
        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
        wait(5);

        TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

        // 2-) Click on Woman Dresses category.
        homePage.clickOnCategory(9);

        //3-) Add Ladies Multicolored Dresses.

        homePage.addToCart("Ladies Multicolored Dress");

        // 4-) Verify that buttons Sofa for Coffe Cafe is turned to "Added to Cart".

        softAssert.assertEquals(homePage.getButtonText("Ladies Multicolored Dress"), "Added to Cart",
                "Button text does not turn to 'Added to Cart'");


    }
}