package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.uiAutomation.testBase.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PaymentScreen extends TestBase {
	private String propVippsAFriendBtn = "";
	private String propSearchMobileNumberTextField = "";
	private String propSearchedMobileNumber = "";
	private String propAmountField = "";
	private String propNextButton = "";
	private String propPaymentSendBtn="";
	private AppiumDriver<WebElement> vippsDriver = null;
	private String os;
	private WebDriverWait wait;

	public PaymentScreen(AppiumDriver<WebElement> vippsDriver, String os) {
		this.os = os;
		this.vippsDriver = vippsDriver;
		wait=new WebDriverWait(vippsDriver, 10000);
		if (os.equalsIgnoreCase("ANDROID")) {
			this.propVippsAFriendBtn = "no.dnb.vipps:id/shortcut_icon";
			this.propSearchMobileNumberTextField = "no.dnb.vipps:id/trasactionSearch";
			this.propSearchedMobileNumber = "no.dnb.vipps:id/tv_contactNo";
			this.propAmountField = "no.dnb.vipps:id/edt_pay_input";
			this.propNextButton = "no.dnb.vipps:id/open_settings_icon";
			this.propPaymentSendBtn="no.dnb.vipps:id/btnSendpayment";
		}
	}

	public void makePayment(String rxerMobileNumber, String amount) {
		if (os.equalsIgnoreCase("ANDROID")) {
			vippsDriver.findElement(By.id(propVippsAFriendBtn)).click();
			vippsDriver.findElement(By.id(propSearchMobileNumberTextField)).sendKeys(rxerMobileNumber);
			vippsDriver.findElement(By.id(propSearchedMobileNumber)).click();
			vippsDriver.findElement(By.id(propAmountField)).sendKeys(amount);
			vippsDriver.findElement(By.id(propNextButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propPaymentSendBtn)));
			vippsDriver.findElement(By.id(propPaymentSendBtn)).click();
		}
	}
}