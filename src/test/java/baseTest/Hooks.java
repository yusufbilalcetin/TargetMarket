package baseTest;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Driver;
import utils.Pages;

public class Hooks {

	protected static Pages pages;

	protected SoftAssert softAssert = new SoftAssert();

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

	public void wait(int secs) {
		try {
			Thread.sleep(secs * 1000L);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}