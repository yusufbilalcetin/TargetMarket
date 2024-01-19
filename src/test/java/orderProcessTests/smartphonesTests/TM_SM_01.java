package orderProcessTests.smartphonesTests;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;
import utils.BrowserUtils;

// 1-) Navigate to ordering page.
// 2-) Click on Smartphones.
// 3-) Add iPhone 9 to cart.
// 4-) Verify that button in iPhone 9 card is turned to "Added to Cart".
// 5-) Click on cart button.
// 6-) Verify that iPhone 9 is visible on the popup.
// 7-) Verify that the price is the same on the popup.
// 8-) Click on "+" button to increase the amount of item.
// 9-) Verify that the amount is "2" and the total price is correct.
public class TM_SM_01 extends Hooks {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void testSmartPhones(){
        // 1-) Navigate to ordering page.
        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

        // 2-) Click on Smartphones category.
        wait(5);
        BrowserUtils.scrollDownWithPageDown();
        homePage.clickOnCategory(2);

        // 3-) Add MacBook Pro to cart.
        wait(5);
        BrowserUtils.scrollDownWithPageDown();
        homePage.addToCart("iPhone 9");

        // 4-) Verify that button in iPhone 9 card is turned to "Added to Cart".
        softAssert.assertEquals(homePage.getButtonText("iPhone 9"), "Added to Cart",
                "Button text doesn't turn to 'Added to Cart'");

        // 5-) Click on cart button.
        homePage.clickOnCartButton();

        // 6-) Verify that iPhone 9 is visible on the popup.
        wait(2);
        softAssert.assertEquals(homePage.getProductNameOnTheCart(1), "iPhone 9", "Product is not added to the cart");
        ;

        // 7-) Verify that the price is the same on the popup.
        softAssert.assertTrue(homePage.getPerProductPriceOnTheCart(1).contains(homePage.getProductPrice("iPhone 9")),
                "Product price is different on the cart");

        // 8-) Click on "+" button twice to increase the amount of item to 3.
        wait(2);
        homePage.clickOnIncreaseButtonOnCart(1, 2);

        // 9-) Verify that the amount is "3" and the total price is correct.
        wait(2);
        softAssert.assertEquals(homePage.getProductNumberOnTheCart(1), "3",
                "Increase product amount button on the cart doesn't work");

        int totalPrice = Integer.parseInt(homePage.getProductPrice("iPhone 9").substring(1)) * 3;
        softAssert.assertTrue(homePage.getTotalProductPriceOnTheCart(1).contains("$" + totalPrice),
                "Total price is wrong on the cart");

        softAssert.assertAll("Smartphones test 1 cannot be completed:");
    }
}
