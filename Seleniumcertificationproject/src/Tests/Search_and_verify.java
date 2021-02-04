package Tests;
import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pom.Searchhotelpom;
import pom.SelectroomPOM;
import pom.clickhotelPOM;

import org.openqa.selenium.JavascriptExecutor;

public class Search_and_verify {


	@Test public void Search_Verify() throws InterruptedException, AWTException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();  
		Searchhotelpom hot = new Searchhotelpom(driver);
		clickhotelPOM hot1 = new clickhotelPOM(driver);
		SelectroomPOM hot2 = new SelectroomPOM(driver);
		hot.enterhotel();
		 hot.entercountry();
		 hot.locationname("OOTY");
		 hot.checkin();
		 hot.checkout();
		 hot.selectguestroom();
		 int c =0;
		 c=hot.searchhot(c); 

		 //verify hotel counts
		 if(c>0) {
				Reporter.log("<p>"+"Hotel count is verified and count is:" + c+"<p>");
				}else {
					Reporter.log("<p>"+"Alert hotel counts not available:" + c+"<p>");
				}
				Thread.sleep(2000);

				//log hotel name
		String hotelname = hot1.clickhotel();
	Reporter.log("<p>"+"Hotel Name in next page is: " + hotelname);
		
		hot2.selectroom2(hotelname);
		
		//use the below path to save the screenshots
	String filpath = "./screenshots/roomimage.png";
	
		hot2.log_image(driver, filpath);
		
		hot2.verify_location();
		hot2.verify_Guestreview();
		hot2.verify_qna();
		hot2.verify_hotelpolicies();
		driver.quit();
	
		
	}
	
	
	
}
