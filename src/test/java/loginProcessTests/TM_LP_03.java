package loginProcessTests;

import baseTest.Hooks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//1- Click on the Target Market link on the Inar Academy home page
//2- Try to Login using a valid username and by leaving the password field blank
//3- Verify that alert message displayed
//4- Verify that alert message is "Please enter your password"

public class TM_LP_03 extends Hooks {

	@Test
	public void testWithoutPassword() {
		// 1- Click on the Target Market link on the Inar Academy home page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// 2- Try to Login using a valid username and by leaving the password field blank
		pages.getTargetMarketLoginPage().login("standard_user", "");

		// 3- Verify that alert showed
		assertTrue(pages.getTargetMarketLoginPage().isPasswordErrorMessageDisplayed(),
				"Error message is not displayed");

		// 4- Verify that alert message is "Please enter your password"
		String errorMessage = "Please enter your password";
		assertEquals(errorMessage, pages.getTargetMarketLoginPage().getPasswordErrorMessageText(),
				"Error message is not" + errorMessage);
	}

}
