package loginProcessTests;

import baseTest.Hooks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TM_LP_02 extends Hooks {

	@Test
	public void testLoginProcessWithLockedUser() {
		// Click on the Target Market link on the Inar Academy home page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// Login using the locked out username
		pages.getTargetMarketLoginPage().login("locked_out_user", "secret_password");

		// Verify that locked user can not login
		assertTrue(pages.getTargetMarketLoginPage().isErrorMessageDisplayed(), "Error message is not displayed");

		String errorMessage = "Your account is locked.";
		assertEquals(errorMessage, pages.getTargetMarketLoginPage().getErrorMessageText(),
				"Error message is not" + errorMessage);
	}

}
