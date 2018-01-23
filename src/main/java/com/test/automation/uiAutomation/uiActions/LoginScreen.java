package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class LoginScreen {
	private String pin = "";
	private String okButton = "";
	private AppiumDriver<WebElement> vippsDriver = null;
	private String os;
	WebDriverWait wait;

	public LoginScreen(AppiumDriver<WebElement> vippsDriver, String os) {
		this.vippsDriver = vippsDriver;
		this.os = os;
		wait = new WebDriverWait(vippsDriver, 20);
		if (os.equalsIgnoreCase("ANDROID")) {
			pin = "no.dnb.vipps:id/ll_parent";
			okButton = "no.dnb.vipps:id/txt_right_button";

		}
	}

	public void enterDigitsOfPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) {

		if (os.equalsIgnoreCase("ANDROID")) {
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pin))) != null) {
				vippsDriver.findElement(By.id(pin)).sendKeys(firstNumber + secondNumber + thirdNumber + fourthNumber);
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

	public void enterKey(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) {
		enterDigitsOfPin(firstNumber, secondNumber, thirdNumber, fourthNumber);
		// clickOnOkButton();
	}

	protected boolean isElementPresent(By by) {
		if (vippsDriver.findElement(by).isDisplayed())
			return true;
		else
			return false;
	}
}
