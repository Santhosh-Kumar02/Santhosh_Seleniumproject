package org.project.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.project.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {

	
	public WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() throws Exception
	{
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sandyy\\Selenium certification\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
				driver.get(Utility.fetchPropertyValue("applicaionURL").toString());
				driver.manage().window().maximize();
		}
		else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(Utility.fetchPropertyValue("applicaionURL").toString());
			driver.manage().window().maximize();
		}
		else{
			throw new Exception("Browser is not correct");
		}

	}
	@AfterMethod
	public void closeBrowser()
	{
	driver.quit();
	}
	
	
	
	
	
}
