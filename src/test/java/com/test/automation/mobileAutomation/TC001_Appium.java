package com.test.automation.mobileAutomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.LoginScreen;
import com.test.automation.uiAutomation.uiActions.PaymentScreen;

public class TC001_Appium extends TestBase {
	LoginScreen loginScreen;
	PaymentScreen paymentScreen;	

	@BeforeMethod
	public void setUP() {
		initMobileDriver(System.getProperty("user.dir") + "/testData/", "mte.apk","ANDROID", "ANDROID",
				"true", "http://0.0.0.0:4723/wd/hub");	
		loginScreen = new LoginScreen(vippsDriver,os);
		paymentScreen=new PaymentScreen(vippsDriver,os);		
	}

	@Test
	public void testMakePayment() throws Exception {
		loginScreen.enterKey("1", "2", "3", "6");
		Thread.sleep(6000);
		paymentScreen.makePayment("92511860", "10");

	}

	@AfterMethod
	public void endTest() {

	}
}
