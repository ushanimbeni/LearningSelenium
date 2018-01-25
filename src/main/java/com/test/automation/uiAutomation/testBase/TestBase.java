package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	protected WebDriver driver;
	protected AppiumDriver<WebElement> vippsDriver = null;
	protected String os;
	String chromeDriverPath;

	public void init(String browser, String url) {
		selectBrowser(browser.toUpperCase());
		getURL(url);
		driver.manage().window().maximize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initMobileDriver(String appDirectoryPath, String appName, String device,
			String platformName, String boolNoReset, String appiumServerURL) 
	{
		File appDir = new File(appDirectoryPath);
		File app = new File(appDir, appName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", platformName);

		// mandatory capabilitiess
		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("platformName", platformName);

		// other caps
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("noReset", boolNoReset);
		try {
			vippsDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
			os=platformName;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("CHROME")) {
			if (SystemUtils.IS_OS_WINDOWS) {
				chromeDriverPath = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
			} else if (SystemUtils.IS_OS_MAC) {
				chromeDriverPath = "/Users/usha/Desktop/chromedriver";
			}
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		}
	}

	public void getURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.close();
	}

}
