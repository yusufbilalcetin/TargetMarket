package loginProcessTests;

import baseTest.Hooks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//1- Click on the Target Market link on the Inar Academy home page
//2- Try to Login using the locked out username
//3- Verify that locked user can not login
//4- Verify that "Your account is locked." text appears
public class TM_LP_02 extends Hooks {

	@Test
	public void testLoginProcessWithLockedUser() {
		// 1- Click on the Target Market link on the Inar Academy home page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// 2- Try to Login using the locked out username
		pages.getTargetMarketLoginPage().login("locked_out_user", "secret_password");

		// 3- Verify that locked user can not login
		assertTrue(pages.getTargetMarketLoginPage().isErrorMessageDisplayed(), "Error message is not displayed");

		// 4- Verify that "Your account is locked." text appears
		String errorMessage = "Your account is locked.";
		assertEquals(errorMessage, pages.getTargetMarketLoginPage().getErrorMessageText(),
				"Error message is not" + errorMessage);
	}

}
