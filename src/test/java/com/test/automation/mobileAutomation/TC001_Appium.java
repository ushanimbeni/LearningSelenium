package com.test.automation.mobileAutomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.LoginScreen;
import com.test.automation.uiAutomation.uiActions.PaymentScreen;
import com.test.automation.uiAutomation.uiActions.ReceiptScreen;

import reports.ExtentManager;

public class TC001_Appium extends TestBase {
	LoginScreen loginScreen;
	PaymentScreen paymentScreen;
	ReceiptScreen receiptScreen;
	ExtentReports extentReports;
	ExtentTest test;

	@BeforeMethod
	public void setUP() {
		initMobileDriver(System.getProperty("user.dir") + "/testData/", "uat3.apk", "ANDROID", "ANDROID", "true",
				"http://0.0.0.0:4723/wd/hub");
		loginScreen = new LoginScreen(vippsDriver, os);
		paymentScreen = new PaymentScreen(vippsDriver, os);
		receiptScreen = new ReceiptScreen(vippsDriver, os);
		extentReports = ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "Res.html");
	}

	@Test
	public void testMakePayment() throws Exception {
		test = extentReports.startTest("TCID -- " + "Payment Flow");
		loginScreen.enterKey("4", "2", "6", "8",test);
		paymentScreen.makePayment("92511830", "2", "Hello123_2",test);
		paymentScreen.ClickOnChatMessage(test);
		if (receiptScreen.verifyReceipt("Money Sent", "Hello123_2",test)) {
			test.log(LogStatus.PASS, "Payment flow PASSED");
		} else {
			test.log(LogStatus.FAIL, "Payment flow PASSED");
		}
		extentReports.endTest(test);
		extentReports.flush();
		// 47700014
	}

	@AfterMethod
	public void endTest() 
	{
		vippsDriver.close();
	}
}
