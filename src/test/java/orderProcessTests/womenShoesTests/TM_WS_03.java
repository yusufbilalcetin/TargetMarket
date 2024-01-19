package orderProcessTests.womenShoesTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;


// 1-) Navigate to ordering page.
// 2-) Click on Woman Shoes category.
// 3-) Find Women Shoes.
// 4-) Verify that buttons Women Shoes is turned to "Added to Cart".
//5-Verify tha the discount is "%17".

public class TM_WS_03 extends Hooks {
    SoftAssert softAssert = new SoftAssert();

    @Test
    void testProcessesWomanShoes3() {
        // 1-) Navigate to ordering page.

        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
        wait(5);

        TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

        // 2-) Click on Woman Shoes category.
        homePage.scrollCategoriesToLeft();
        homePage.clickOnCategory(10);

        //3-Add to Cart Women Shoes
        homePage.addToCart("Women Shoes");

        // 4-) Verify that buttons Women Shoes is turned to "Added to Cart".
        softAssert.assertEquals(homePage.getButtonText("Women Shoes"), "Added to Cart",
                "Button text does not turn to 'Added to Cart'");


        //5-Verify tha the discount is "%17".
        homePage.getDiscount("Women Shoes");
        softAssert.assertEquals(homePage.getDiscount("Women Shoes"), "%17 OF", "Wrong discount!");


    }
}