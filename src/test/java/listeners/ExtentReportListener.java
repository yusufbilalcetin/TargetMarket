package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

	private static final ExtentReports extent = new ExtentReports();

	private static ExtentTest test;

	static {
		extent.attachReporter(new ExtentSparkReporter("extent.html"));
	}


	public static ExtentTest getTest() {
		return test;
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed");
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite is ending!");
		extent.flush();
	}

}
