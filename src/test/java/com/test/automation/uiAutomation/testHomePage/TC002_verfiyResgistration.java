package com.test.automation.uiAutomation.testHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC002_verfiyResgistration  extends TestBase {

	String firstName="test";
	String lastName = "testlast";
	String pwd = "passsword";
	String address = "Alnagata 18 Oslo";
	String city = "Oslo";
	String postCode = "12345";
	String mobile = "4537892456";
	
	@BeforeClass
	public void setUP()
	{
		init();
	}
	
	@Test
	public void testLogin()
	{
		HomePage homePage=new HomePage(driver);
		homePage.registerUser(firstName, lastName, pwd, address,  city, postCode, mobile);
		Assert.assertEquals(homePage.getValidationText(),"My account");
		System.out.println("User registered successfully");

	}
		
	@AfterClass
	public void endTest()
	{
		driver.close();
	}
	
	
}
