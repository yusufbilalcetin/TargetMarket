package loginProcessTests;

import baseTest.Hooks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TM_LP_03 extends Hooks {

	@Test
	public void testWithoutPassword() {
		// Click on the Target Market link on the Inar Academy home page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// Login using the locked out username
		pages.getTargetMarketLoginPage().login("standard_user", "");

		// Verify that Please enter your password alert showed
		assertTrue(pages.getTargetMarketLoginPage().isPasswordErrorMessageDisplayed(),
				"Error message is not displayed");

		String errorMessage = "Please enter your password";
		assertEquals(errorMessage, pages.getTargetMarketLoginPage().getPasswordErrorMessageText(),
				"Error message is not" + errorMessage);
	}

}
