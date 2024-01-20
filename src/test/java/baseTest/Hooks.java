package baseTest;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Driver;
import utils.Pages;

public abstract class Hooks {

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

	public abstract void onStart(ITestContext context);

	public abstract void onTestStart(ITestResult result);

	public abstract void onTestSuccess(ITestResult result);

	public abstract void onTestFailure(ITestResult result);

	public abstract void onTestSkipped(ITestResult result);

	public abstract void onFinish(ITestContext context);

}
