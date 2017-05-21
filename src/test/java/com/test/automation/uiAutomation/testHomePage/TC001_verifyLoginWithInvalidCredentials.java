package com.test.automation.uiAutomation.testHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_verifyLoginWithInvalidCredentials {

	WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception
	{
		//String chromeDriverPath=System.getProperty("user.dir")+"/driver/chromedriver";
		//System.out.println(chromeDriverPath);
		String chromeDriverPath="/Users/usha/Desktop/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}
	
	@Test
	public void testLoginWithInvalidCredentials()
	{
		//test
		WebElement signInButton= driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));
		signInButton.click();
				
		System.out.println("Hello");
	}
	
	@AfterTest
	public void endTest()
	{
		//driver.close();
	}
}
