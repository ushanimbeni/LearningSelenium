package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ReceiptScreen {
	private String receiptPaymentStatus="";
	private String receiptTxnMessage="";
	private String receiptTxnDate="";
	private String receiptTxnID="";
	private String receiptBackicon="";
	
	private AppiumDriver<WebElement> vippsDriver = null;
	private String os;
	private WebDriverWait wait;

	public ReceiptScreen(AppiumDriver<WebElement> vippsDriver, String os) {
		this.os = os;
		this.vippsDriver = vippsDriver;
		wait = new WebDriverWait(vippsDriver, 10000);
		if (os.equalsIgnoreCase("ANDROID")) {
			this.receiptPaymentStatus="no.dnb.vipps:id/txtPaymentStatus";
			this.receiptTxnMessage="no.dnb.vipps:id/txtMerchantMsg";
			this.receiptTxnDate="no.dnb.vipps:id/date";
			this.receiptTxnID="no.dnb.vipps:id/serialNumber";
			this.receiptBackicon="no.dnb.vipps:id/go_back_icon";
		}
	}
	
	public boolean verifyReceipt(String txnStatus,String txnMessage,ExtentTest test)
	{		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(receiptPaymentStatus)));		
		MobileElement appPaymentStatus=(MobileElement) vippsDriver.findElement(By.id(receiptPaymentStatus));
		test.log(LogStatus.INFO, "Got the payment status from app as : " + appPaymentStatus.getText().toString());
		MobileElement appTxnMessage=(MobileElement) vippsDriver.findElement(By.id(receiptTxnMessage));
		test.log(LogStatus.INFO, "Got the payment text from app as : " + appTxnMessage.getText().toString());		
		if (appPaymentStatus.getText().toString().equalsIgnoreCase(txnStatus))
		{			
			test.log(LogStatus.INFO, "Payment status is Correct");
			if (appTxnMessage.getText().toString().equalsIgnoreCase(txnMessage))
			{				
				test.log(LogStatus.INFO, "Payment message is Correct");
				return true;
			}
		}
		return false;		
	}
	
	public void clickOnBackButton()
	{
		MobileElement backbtn=(MobileElement) vippsDriver.findElement(By.id(receiptBackicon));
		backbtn.click();
	}
}
