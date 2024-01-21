package loginProcessTests;

import baseTest.Hooks;
import listeners.ExtentReportListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//1- Create a DataProvider method to provide different user credentials for the test
//2- Create Test method using the DataProvider to run multiple test cases with different users
//3- Click on the Target Market link on the Inar Academy home page
//4- Login using the provided username and password(Login method calls clickLogin())
//5- Verify the welcome text on the Target Market home page after login
@Listeners(ExtentReportListener.class)
public class TM_LP_01 extends Hooks {



        // 1- Create a DataProvider method to provide different user credentials for the test
        @DataProvider(name = "userCredentials")
        public String[][] getUserCredentials () {
        return new String[][]{{"standard_user", "secret_password"}, {"problem_user", "secret_password"},
                {"performance_glitch_user", "secret_password"}};
    }

        // 2- Create Test method using the DataProvider to run multiple test cases with
        // different users

        @Test(dataProvider = "userCredentials")
        public void testLoginProcessWithDifferentUsers (String username, String password){
        // 3- Click on the Target Market link on the Inar Academy home page
    try{
        ExtentReportListener.getTest().info("1- Create a DataProvider method to provide different user credentials for the test");
        ExtentReportListener.getTest().info("2- Create Test method using the DataProvider to run multiple test cases with\n" +
                "        // different users");
        ExtentReportListener.getTest().info("// 3- Click on the Target Market link on the Inar Academy home page");

        pages.getInarAcademyHomePage().clickOnTargetMarketLink();

        // 4- Login using the provided username and password(Login method calls
        // clickLogin())
        ExtentReportListener.getTest().info("4- Login using the provided username and password(Login method calls\n" +
                "        // clickLogin())");
        pages.getTargetMarketLoginPage().login(username, password);

        // 5- Verify the welcome text on the Target Market home page after login
        ExtentReportListener.getTest().info("5- Verify the welcome text on the Target Market home page after login");

        String expectedWelcomeText = "Welcome to the Target Market, " + username + "!";
        assertEquals(expectedWelcomeText, pages.getTargetMarketHomePage().getWelcomeText(), "Wrong welcome text");
        ExtentReportListener.getTest().pass("Test passed");
    }
		catch(Exception e){
            // If any exception occurs, report the test as failed
            ExtentReportListener.getTest().fail("Test failed");
        }
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}