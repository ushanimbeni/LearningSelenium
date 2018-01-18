package com.test.automation.mobileAutomation;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class TC001_Appium extends TestBase {
	@SuppressWarnings("rawtypes")
	AndroidDriver driver;
	@BeforeTest
	public void setup() throws Exception {
		File appDir = new File(System.getProperty("user.dir")+ "/testData");
		File app = new File(appDir, "sit3.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");

		// mandatory capabilities
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");

		// other caps
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		
	}

	@Test
	public void testLoginWithInvalidCredentials() throws Exception {
		Thread.sleep(10000);
		By porpBtnExistingUser=By.id("no.dnb.vipps:id/btnExistingUser");
		WebElement btnExistingUser= driver.findElement(porpBtnExistingUser);
		if (btnExistingUser.isEnabled())
		{
			System.out.println("enabled");
			btnExistingUser.click();
			
		}
		WebElement number=driver.findElement(By.id("no.dnb.vipps:id/edtMobileNumber"));
		number.sendKeys("93999243");
		WebElement iConRight=driver.findElement(By.id("no.dnb.vipps:id/icon_right"));
		iConRight.click();
		
		
//		System.out.println(driver.findElement(btnExistingUser).getText());
		
	}

	@AfterTest
	public void endTest() {

	}
}
