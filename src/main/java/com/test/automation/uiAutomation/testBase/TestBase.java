package com.test.automation.uiAutomation.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public WebDriver driver;
	public void init()
	{
		selectBrowser("CHROME");
		getURL("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	public void selectBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("CHROME"))
		{
			String chromeDriverPath="/Users/usha/Desktop/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver=new ChromeDriver();
		}
	}
	public void getURL(String url)
	{
		driver.get(url);
	}
	public void closeBrowser()
	{
		driver.close();
	}
}
