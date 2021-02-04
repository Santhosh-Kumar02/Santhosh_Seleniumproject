package Tests;
import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pom.Searchhotelpom;
import pom.clickhotelPOM;

public class Search_and_filter {

@Test public void Search_Verify() throws InterruptedException, AWTException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();  
		Searchhotelpom hot = new Searchhotelpom(driver);
		clickhotelPOM hot1 = new clickhotelPOM(driver);
		hot.enterhotel();
		 hot.entercountry();
		 hot.locationname("OOTY");
		 hot.checkin();
		 hot.checkout();
		 hot.selectguestroom();
		 hot.searchhot();
		 
		 //diplay the hotel counts
		 int a=hot1.clickhotel1();
		 System.out.println("Hotel counts verified. Count of hotels is : " + a);
		 Reporter.log("Hotel counts verified. Count of hotels is : " + a+"<p>");
		 //apply filters
		 hot1.filter_payathotel();
		 hot1.filter_rating4();
		 hot1.filter_price();
		 //verify filters
		 hot1.verify_filter_price();
		 hot1.verify_rating4();

		 driver.quit();

}
}
