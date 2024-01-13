import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TM_LP_01 extends Hooks {

    @Test
    void testLoginProcessWithValidUser() {
        pages.getInarAcademyHomePage().clickOnTargetMarketLink();
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        assertEquals("Welcome to the Target Market, standard_user!", pages.getTargetMarketHomePage().getWelcomeText(), "Wrong welcome text");
    }
}
