package orderProcessTests.smartphonesTests;

import baseTest.Hooks;
import org.testng.annotations.Test;


// 1-) Navigate to ordering page.
// 2-) Click on Smartphones category.
// 3-) Find OPPOF19.
// 4-) Verify that its image is displayed properly.
// 5-) Verify that its name is displayed properly.
// 6-) Verify that its "Add to Cart" button is displayed properly
// 7-) Verify that the discount is "%11"
// 8-) Add "OPPOF19" to cart.
// 9-) Verify that button in "OPPOF19" card is turned to "Added to Cart".

public class TM_SM_02 extends Hooks {


    void goToHomePageAndChooseOPPOF19() {
        // 1-) Navigate to ordering page.
        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
        wait(4);

        pages.getTargetMarketHomePage().clickOnCategory(2);

    }

    @Test(priority = 2)
    void testOPPOF19Image() {
        goToHomePageAndChooseOPPOF19();

        // 3-) Find OPPOF19.
        pages.getTargetMarketHomePage().findProduct("OPPOF19");

        // 4-) Verify that its image is displayed properly.
        softAssert.assertTrue(pages.getTargetMarketHomePage().isProductPictureLoadedProperly("OPPOF19"),
                "Product picture is not loaded properly");
    }

    @Test(priority = 3)
    void checkOPPOF19NameButton() {
        goToHomePageAndChooseOPPOF19();
        // 5-) Verify that its name is displayed properly.
        softAssert.assertEquals(pages.getTargetMarketHomePage().getProductName("OPPOF19"),
                "OPPOF19", "Product name is not displayed properly");

        // 6-) Verify that its "Add to Cart" button is displayed properly
        softAssert.assertTrue(pages.getTargetMarketHomePage().isAddToCartButtonVisible("OPPOF19"),
                "Add to Cart button is not visible");
    }

    @Test(priority = 4)
    void checkOPPOF19Discount() {
        goToHomePageAndChooseOPPOF19();
        // 7-) Verify that the discount is "% 11 OFF"
        softAssert.assertEquals(pages.getTargetMarketHomePage().getDiscount("OPPOF19"), "% 18 OFF",
                "Discount rate is not '%18 OFF'");
    }

    @Test(priority = 5)
    void checkOPPOF19AddCartFunction() {
        goToHomePageAndChooseOPPOF19();
        // 8-) Add OPPOF19. to cart.
        pages.getTargetMarketHomePage().addToCart("OPPOF19");

        // 9-) Verify that button in OPPOF19. card is turned to "Added to Cart".
        softAssert.assertEquals(pages.getTargetMarketHomePage().getButtonText("OPPOF19"), "Added to Cart",
                "Text button doesn't turn to 'Added to Cart'");

        softAssert.assertAll("Smartphones test 2 cannot be completed:");
    }

}