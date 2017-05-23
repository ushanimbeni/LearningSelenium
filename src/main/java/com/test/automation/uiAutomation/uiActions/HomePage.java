package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Making POM
public class HomePage {

	WebDriver driver; 
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signInButton;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement pwd;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement invalidEmailAddressError;
	
	public HomePage(WebDriver webDriver)
	{
		PageFactory.initElements(webDriver, this);
	}
	
	public void Login(String emailAddress, String password)
	{
		signInButton.click();
		email.sendKeys(emailAddress);
		pwd.sendKeys(password);
		submitButton.click();
	}
	
	public String getErrorInvalidEmailAddress()
	{
		return invalidEmailAddressError.getText();
	}
	
}
