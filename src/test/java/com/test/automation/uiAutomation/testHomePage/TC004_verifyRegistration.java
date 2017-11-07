package com.test.automation.uiAutomation.testHomePage;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HelpPage;

public class TC004_verifyRegistration extends TestBase
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	@DataProvider
	public Object[][] ValidDataProvider()
	{
		return new Object[][] { { "Y", "Deepak1", "test1", "test1", "deepak1 -- has been created" },
				{ "Y", "Deepak2", "test1", "test1", "Deepak2 -- has been created" },
				{ "Y", "Deepak3", "test1", "test1", "Deepak3 -- has been created" } };
	}

	@BeforeTest
	public void setUP()
	{
		init("CHROME", System.getProperty("user.dir") + "/testData/help.html");
		// htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
		// + "\\target\\rep.html");
		// extent = new ExtentReports();
		// extent.attachReporter(htmlReporter);
		// extent.setSystemInfo("Environment", "SIT");
		// extent.setSystemInfo("User Name", "Deepak");
		// htmlReporter.config().setDocumentTitle("Developer Portal automation
		// Test Report");
		// htmlReporter.config().setReportName("Developer Portal Automation
		// Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		// htmlReporter.config().setTheme(Theme.DARK);
	}

	@Test(dataProvider = "ValidDataProvider")
	public void testLogin(String execution, String username, String pwd, String cpwd, String expectedResult) throws InterruptedException
	{

		if (execution.equalsIgnoreCase("Y"))
		{
			// logger = extent.createTest("AutomationSuite");
			HelpPage helpPage = new HelpPage(driver);
			
			helpPage.registerUser(username, pwd, cpwd);
			if (helpPage.getValidationMessageForRegistration().equals(expectedResult))
			{
				System.out.println("Test case has been passed for user name " + username);
				Assert.assertEquals(true, true);
			} else
			{
				System.out.println("Test case has been failed for user name " + username);
				Assert.assertEquals(true, false);
			}
			// extent.removeTest(logger);
		}
	}

	@AfterTest
	public void endTest()
	{
		driver.close();

		// extent.flush();
	}
	//
	// @AfterSuite
	// public void endsuit()
	// {
	//
	// }

}
