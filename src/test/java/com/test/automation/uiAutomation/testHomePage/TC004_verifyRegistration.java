package com.test.automation.uiAutomation.testHomePage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HelpPage;

import reports.ExtentManager;

public class TC004_verifyRegistration extends TestBase
{
	ExtentReports extentReports;
	ExtentTest test;

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
		extentReports = ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "Res.html");
	}

	@Test(dataProvider = "ValidDataProvider")
	public void testLogin(String execution, String username, String pwd, String cpwd, String expectedResult) throws InterruptedException
	{

		if (execution.equalsIgnoreCase("Y"))
		{
			test = extentReports.startTest("TCID -- " + username);
			HelpPage helpPage = new HelpPage(driver);

			helpPage.registerUser(username, pwd, cpwd);
			test.log(LogStatus.INFO, "testing for : " + username);
			if (helpPage.getValidationMessageForRegistration().equals(expectedResult))
			{
				System.out.println("Test case has been passed for user name " + username);
				test.log(LogStatus.PASS, "Success for TC ID : " + username);
			} else
			{
				System.out.println("Test case has been failed for user name " + username);
				test.log(LogStatus.FAIL, "Success for TC ID : " + username);
			}
			extentReports.endTest(test);
			extentReports.flush();
		}
	}

	@AfterTest
	public void endTest()
	{
		driver.close();
	}
	//
	// @AfterSuite
	// public void endsuit()
	// {
	//
	// }

}
