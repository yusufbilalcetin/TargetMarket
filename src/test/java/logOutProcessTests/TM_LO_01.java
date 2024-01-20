package logOutProcessTests;

import baseTest.Hooks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TM_LO_01 extends Hooks {

	// Test method using a DataProvider to run multiple test cases with different users
	@Test(dataProvider = "userCredentials")
	public void testLoginProcessWithDifferentUsers(String username, String password) {
		// Click on the Target Market link on the Inar Academy home page
		pages.getInarAcademyHomePage().clickOnTargetMarketLink();

		// Login using the provided username and password
		pages.getTargetMarketLoginPage().login(username, password);

		// Verify the welcome text on the Target Market home page after login
		String expectedWelcomeText = "Welcome to the Target Market, " + username + "!";
		assertEquals(expectedWelcomeText, pages.getTargetMarketHomePage().getWelcomeText(), "Wrong welcome text");

		pages.getTargetMarketLogOutPage().clickOnLogOutButton();

		String expectedLogOutText = "Login";
		assertEquals(expectedLogOutText, pages.getTargetMarketLogOutPage().getLogOutText(), "Wrong LogOut Process");

	}

	// DataProvider method to provide different user credentials for the test
	@DataProvider(name = "userCredentials")
	public String[][] getUserCredentials() {
		return new String[][] { { "standard_user", "secret_password" }, { "problem_user", "secret_password" },
				{ "performance_glitch_user", "secret_password" } };
	}

}
