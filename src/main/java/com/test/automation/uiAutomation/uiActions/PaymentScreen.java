package com.test.automation.uiAutomation.uiActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.testBase.TestBase;

import io.appium.java_client.AppiumDriver;

public class PaymentScreen extends TestBase {
	private String propVippsAFriendBtn = "";
	private String propSearchMobileNumberTextField = "";
	private String propSearchedMobileNumber = "";
	private String propAmountField = "";
	private String propNextButton = "";
	private String propPaymentSendBtn = "";
	private String propCustomMessage="";
	private String propTxnMessage="";
	private String propVippsAFriendBtnNew = "";
	private AppiumDriver<WebElement> vippsDriver = null;
	private String os;
	private WebDriverWait wait;

	public PaymentScreen(AppiumDriver<WebElement> vippsDriver, String os) {
		this.os = os;
		this.vippsDriver = vippsDriver;
		wait = new WebDriverWait(vippsDriver, 10000);
		if (os.equalsIgnoreCase("ANDROID")) {
			this.propVippsAFriendBtn = "no.dnb.vipps:id/shortcut_icon";
			this.propSearchMobileNumberTextField = "no.dnb.vipps:id/trasactionSearch";
			this.propSearchedMobileNumber = "no.dnb.vipps:id/tv_contactNo";
			this.propAmountField = "no.dnb.vipps:id/edt_pay_input";
			this.propNextButton = "no.dnb.vipps:id/open_settings_icon";
			this.propPaymentSendBtn = "no.dnb.vipps:id/btnSendpayment";
			this.propCustomMessage="no.dnb.vipps:id/custom_message_input";
			this.propTxnMessage="no.dnb.vipps:id/message_text";
			this.propVippsAFriendBtnNew="com.dnb.vipps.android.mock.debug:id/button";
		}
	}

	public void makePayment(String rxerMobileNumber, String amount, String customMessage,ExtentTest test) {
		if (os.equalsIgnoreCase("ANDROID")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propVippsAFriendBtn)));
			vippsDriver.findElement(By.id(propVippsAFriendBtn)).click();
			vippsDriver.findElement(By.id(propSearchMobileNumberTextField)).sendKeys(rxerMobileNumber);
			vippsDriver.findElement(By.id(propSearchedMobileNumber)).click();
			vippsDriver.findElement(By.id(propAmountField)).sendKeys(amount);
			vippsDriver.findElement(By.id(propCustomMessage)).sendKeys(customMessage);
			vippsDriver.findElement(By.id(propNextButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propPaymentSendBtn)));
			vippsDriver.findElement(By.id(propPaymentSendBtn)).click();
			test.log(LogStatus.INFO, "Paying to mobile number " + rxerMobileNumber);
			}
	}

	public void ClickOnChatMessage(ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propTxnMessage)));
		List<WebElement> chatHeaders =vippsDriver.findElementsById("no.dnb.vipps:id/chat_header");
		System.out.println(chatHeaders.size());
		chatHeaders.get(chatHeaders.size()-1).click();
		test.log(LogStatus.INFO, "Clicked on chat for recipet");
	}
}