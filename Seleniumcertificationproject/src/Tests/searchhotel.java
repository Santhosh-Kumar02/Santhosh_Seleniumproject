package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pom.Searchhotelpom;

public class searchhotel {
	
	@Test public void searchhotell() throws Exception 
 {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();  
		Searchhotelpom hot = new Searchhotelpom(driver);
 hot.enterhotel();
 hot.entercountry();
 hot.locationname("OOTY");
 hot.checkin();
 hot.checkout();
 hot.selectguestroom();
 hot.searchhot(); 
 
 //saving hotel name value in test NG
driver.quit();

 }
}
  
  
  
  