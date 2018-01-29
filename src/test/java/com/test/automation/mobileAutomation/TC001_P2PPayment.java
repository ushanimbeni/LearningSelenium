package com.test.automation.mobileAutomation;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.LoginScreen;
import com.test.automation.uiAutomation.uiActions.PaymentScreen;
import com.test.automation.uiAutomation.uiActions.ReceiptScreen;

import reports.ExtentManager;
import utility.ExcelReader;
import utility.UtilityClass;

public class TC001_P2PPayment extends TestBase {

	LoginScreen loginScreen;
	PaymentScreen paymentScreen;
	ReceiptScreen receiptScreen;
	ExtentReports extentReports;
	ExtentTest test;
	UtilityClass utilityClass;
	ExcelReader excelReader;

	@BeforeClass	//this method will be called once 
	public void BeforeClass() throws IOException {
		utilityClass = new UtilityClass();
		excelReader = new ExcelReader(System.getProperty("user.dir") + "/testData/001_p2pPayment.xlsx");

		extentReports = ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "Res.html");
	}

	@DataProvider
	public Object[][] ValidDataProvider() {
		Object[][] testObjArray = excelReader.getTestDataForDataprovider();
		return testObjArray;
	}

	@BeforeMethod
	public void BeforeTest() throws IOException {
		initMobileDriver(System.getProperty("user.dir") + "/testData/", utilityClass.getPropertyValue("apkName"),
				utilityClass.getPropertyValue("device"), utilityClass.getPropertyValue("platformName"),
				utilityClass.getPropertyValue("NoReset"), utilityClass.getPropertyValue("appiumServerURL"));
		loginScreen = new LoginScreen(vippsDriver, os);
		paymentScreen = new PaymentScreen(vippsDriver, os);
		receiptScreen = new ReceiptScreen(vippsDriver, os);
	}

	@Test(dataProvider = "ValidDataProvider")
	public void testMakePayment(String execution, String useCase, String SenderMobileNumber, String pin,
			String rxMobileNumber, String txnAmount, String txnText, String expectedPaymentStatus) throws Exception {
		if (execution.equals("Y")) {
			switch (useCase) {
			case "P2P_PAYMENT":
				test = extentReports.startTest("TCID -- " + useCase);
				loginScreen.enterKey(pin, test);
				paymentScreen.makePayment(rxMobileNumber, txnAmount, txnText, test);
				paymentScreen.ClickOnChatMessage(test);
				if (receiptScreen.verifyReceipt(expectedPaymentStatus, txnText, test)) {
					test.log(LogStatus.PASS, "Payment flow PASSED");
				} else {
					test.log(LogStatus.FAIL, "Payment flow FAILED");
				}
				// Move Back to Origonal Screen
				receiptScreen.clickOnBackButton();
				receiptScreen.clickOnBackButton();
				break;
			default:
				break;
			}
		}
		extentReports.endTest(test);
		extentReports.flush();
		// 47700014
		// 48644314
	}

	@AfterMethod
	public void endTest() {
	}
}
