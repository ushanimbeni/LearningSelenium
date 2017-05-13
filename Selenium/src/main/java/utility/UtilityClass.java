package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class UtilityClass 
{
	String crhomeDriverPath="";
	public UtilityClass() 
	{
		this.crhomeDriverPath="/Users/usha/Desktop/chromedriver";
	}
	
    public int sum(int a, int b)
    {
		return a+b;
    }
    
    public int multiply(int m,int n)
    {
    	
    	return m*n;
    }
    public WebDriver launchBrowser(String url)
    {
    	System.setProperty("webdriver.chrome.driver", crhomeDriverPath);
    	WebDriver driver=new ChromeDriver();
    	driver.get(url);
    	driver.manage().window().maximize();
    	return driver;
    }
    
}
