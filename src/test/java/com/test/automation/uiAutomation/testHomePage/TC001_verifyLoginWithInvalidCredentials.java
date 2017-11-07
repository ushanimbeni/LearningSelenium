package com.test.automation.uiAutomation.testHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC001_verifyLoginWithInvalidCredentials extends TestBase{

	
	@BeforeTest
	public void setup() throws Exception
	{
		init("CHROME","C://help.html");
	}
	
	@Test
	public void testLoginWithInvalidCredentials() throws Exception
	{
		HomePage homePage=new HomePage(driver);
		homePage.Login("abc@gmai", "asd");
		String expectedError = "Invalid email address.";
		Assert.assertEquals(homePage.getErrorInvalidEmailAddress(), expectedError);
		System.out.println("Test case passed");
	}
	
	@AfterTest
	public void endTest()
	{
		driver.close();
	}
}
