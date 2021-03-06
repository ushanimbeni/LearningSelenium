package com.test.automation.uiAutomation.testHomePage;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

import utility.ExcelReader;

public class TC002_verfiyResgistration_DataProviderUsingExcelProvider extends TestBase 
{
	ExcelReader excelReader;
	
	@DataProvider
	public Object[][] ValidDataProvider() 
	{
		excelReader=new ExcelReader(System.getProperty("user.dir") + "/testData/VerifyRegistration_DNB.xls");
		Object[][] testObjArray=excelReader.getTestDataForDataprovider();
		return testObjArray;		
	}

	@BeforeMethod
	public void setUP() {
		init("CHROME","C://Common//help.html");
	}

	@Test(dataProvider = "ValidDataProvider")
	public void testLogin(String executionStatus, String email, String firstName, String lastName, String pwd,
			String address, String city, String postalCode, String mobile) {
		if (executionStatus.equalsIgnoreCase("Y")) {
			HomePage homePage = new HomePage(driver);
			email="Deep" + new Random().nextInt() + "@gmail.com";
			homePage.registerUser(email, firstName, lastName, pwd, address, city, postalCode, mobile);
			Assert.assertEquals(homePage.getValidationText(), "My account");
			System.out.println("User registered successfully");
		}

	}

	@AfterMethod
	public void endTest() {
		driver.close();
	}

}
