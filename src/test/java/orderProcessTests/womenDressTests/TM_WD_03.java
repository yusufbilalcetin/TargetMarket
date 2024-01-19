package orderProcessTests.womenDressTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;
// 1-) Navigate to ordering page.
// 2-) Click on Woman Shoes category.
//3-) Add Malai Maxi Dress.
// 4-) Verify that buttons Malai Maxi Dress is turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that Malai Maxi Dress is visible on the popup.
// 7-) Verify that the prices are the same on the popup.
// 8-) Click on "+" button to increase the amount of items.
// 9-) Verify that the amount is "6" and the total price is correct.
// 10- Click on "-" button to decrease the amount of items.
//11- Verify that the amount is "4" and the total price is correct


public class TM_WD_03 extends Hooks {

    SoftAssert softAssert = new SoftAssert();

    @Test
    void testProcessesWomanShoes2() {
        // 1-) Navigate to ordering page.

        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
        wait(5);

        TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

        // 2-) Click on Woman Shoes category.
        homePage.clickOnCategory(9);

        //3-) Add Malai Maxi Dress.

        homePage.addToCart("Malai Maxi Dress");

        // 4-) Verify that buttons Malai Maxi Dress is turned to "Added to Cart".

        softAssert.assertEquals(homePage.getButtonText("Malai Maxi Dress"), "Added to Cart",
                "Button text does not turn to 'Added to Cart'");

        // 5-) Click on cart button.
        homePage.clickOnCartButton();

        // 6-) Verify that Malai Maxi Dress is visible on the popup.

        softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "Malai Maxi Dress",
                "Product is not added to cart");

        // 7-) Verify that the prices are the same on the popup.
        softAssert.assertTrue(
                homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("Malai Maxi Dress")),
                "Product price is different on the cart");

        // 8-) Click on "+" button to increase the amount of items.

        homePage.clickOnIncreaseButtonOnCart(1, 5);

        wait(2);

        // 9-) Verify that the amount is "6" and the total price is correct.
        softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "6",
                "Increase product amount button on the cart doesn't work");

        // 10- Click on "-" button to decrease the amount of items.

        homePage.clickOnDecreaseButtonOnCart(1, 2);
        wait(2);

        //11- Verify that the amount is "4" and the total price is correct
        softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "4",
                "Increase product amount button on the cart doesn't work");

        int totalPrice2 = Integer.parseInt(homePage.getProductPrice("Chappals & Shoe Ladies Metallic").substring(1)) * 4;

        softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice2),
                "Total price is wrong on the cart");

        softAssert.assertAll("Furniture test 3 could not be completed: Total price is incorrect on the cart.");

    }
}