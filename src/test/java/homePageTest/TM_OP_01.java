package homePageTest;

import baseTest.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TargetMarketHomePage;

// 1-) Navigate to ordering page.
// 2-) Click on Sorting Types and then "A-Z"
// 3-) Verify that items are listed alphabetically(A-Z)
// 4-) Click on Sorting Types and then "Z-A"
// 5-) Verify that items are listed alphabetically(Z-A)
// 6-) Click on Sorting Types and then "Highest Price"
// 7-) Verify that items are sorted from high price to low price.
// 8-) Click on Sorting Types and then "Lowest Price"
// 9-) Verify that items are sorted from low price to high price..
public class TM_OP_01 extends Hooks {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testOrderPagesSortingFunctionality() {
        //1-) Navigate to ordering page.
        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
        TargetMarketHomePage homePage = pages.getTargetMarketHomePage();

        //2-) Click on Sorting Types and then "A-Z"
        homePage.selectByAtoZ();

        //3-) Verify that items are listed alphabetically(A-Z)
        softAssert.assertTrue(homePage.isSortedAtoZ(), "sorted incorrectly from A to Z");


        //4-) Click on Sorting Types and then "Z-A"
        homePage.selectByZtoA();

        //5-) Verify that items are listed alphabetically(Z-A)
        softAssert.assertTrue(homePage.isSortedZtoA(), "sorted incorrectly from Z to A");

        //6-) Click on Sorting Types and then "Highest Price"
        homePage.selectByHighestPrice();

        // 7-) Verify that items are sorted from high price to low price.
        softAssert.assertTrue(homePage.isSortedHighToLow(),"sorted incorrectly from highest price to lowest price");

        // 8-) Click on Sorting Types and then "Lowest Price"
        homePage.selectByLowestPrice();

        // 9-) Verify that items are sorted from low price to high price..
        softAssert.assertTrue((homePage.isSortedLowToHigh()),"sorted incorrectly from lowest price to highest price");
        softAssert.assertAll("Homepage test fails");


    }
}
