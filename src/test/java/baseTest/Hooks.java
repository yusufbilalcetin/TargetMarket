package baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Driver;
import utils.Pages;

public class Hooks {

	protected static Pages pages;

	@BeforeMethod
	@Parameters("browserType")
	public static void setUpTestEnvironment(@Optional("chrome") String browserType) {
		Driver.getDriver(browserType);
		pages = new Pages();
	}

	@AfterMethod
	public static void tearDown() {
		Driver.closeDriver();
	}

}
