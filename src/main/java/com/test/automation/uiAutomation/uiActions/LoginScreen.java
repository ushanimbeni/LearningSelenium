package com.test.automation.uiAutomation.uiActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import utility.UtilityClass;

public class LoginScreen {
	private String propPin = "";
	private String okButton = "";
	private String propPinNew="";
	private AppiumDriver<WebElement> vippsDriver = null;
	private String os;
	WebDriverWait wait;

	public LoginScreen(AppiumDriver<WebElement> vippsDriver, String os) {
		this.vippsDriver = vippsDriver;
		this.os = os;
		wait = new WebDriverWait(vippsDriver, 20);
		if (os.equalsIgnoreCase("ANDROID")) {
			propPin = "no.dnb.vipps:id/ll_parent";
			okButton = "no.dnb.vipps:id/txt_right_button";
			propPinNew="com.dnb.vipps.android.mock.debug:id/txt_pin_entry";

		}
	}

	public void enterDigitsOfPin(String pin,ExtentTest test) throws IOException {

		if (os.equalsIgnoreCase("ANDROID")) {
			if (new UtilityClass().getPropertyValue("newApp").equalsIgnoreCase("true"))
			{
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propPinNew))) != null) {
					String pinArray[]=new UtilityClass().stringToArray(pin);
					vippsDriver.findElement(By.id(propPinNew)).sendKeys(pinArray[0] +pinArray[1]+pinArray[2] + pinArray[3] );
					test.log(LogStatus.INFO, "Entered the pin number as " + pin);					
				}
			}
			else 				
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propPin))) != null) {
				String pinArray[]=new UtilityClass().stringToArray(pin);
				vippsDriver.findElement(By.id(propPin)).sendKeys(pinArray[0] +pinArray[1]+pinArray[2] + pinArray[3] );
				test.log(LogStatus.INFO, "Entered the pin number as " + pin);
				System.out.println("2");
			}
		}
	}

	public void clickOnOkButton() {
		if (os.equalsIgnoreCase("ANDROID")) {
			if (isElementPresent(By.id(okButton))) {
				vippsDriver.findElement(By.id(okButton)).click();
				System.out.println("The user is not logged into this device");				
			} else {
				System.out.println("This time push notification did not popsup");
			}

		}
	}

	public void enterKey(String pin,ExtentTest test) throws IOException {
		enterDigitsOfPin(pin,test);		
		// clickOnOkButton();
	}

	protected boolean isElementPresent(By by) {
		if (vippsDriver.findElement(by).isDisplayed())
			return true;
		else
			return false;
	}
}
