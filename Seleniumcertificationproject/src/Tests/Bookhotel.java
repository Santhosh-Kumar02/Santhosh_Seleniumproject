package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pom.Enter_guestdetailsPOM;
import pom.Payment_POM;
import pom.Searchhotelpom;
import pom.clickhotelPOM;
import pom.SelectroomPOM;
public class Bookhotel {
	@Test public void bookhotel() throws Exception 
 {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();  
		Searchhotelpom hot = new Searchhotelpom(driver);
		clickhotelPOM hot1 = new clickhotelPOM(driver);
		SelectroomPOM hot2 = new SelectroomPOM(driver);
		Enter_guestdetailsPOM hot3 = new Enter_guestdetailsPOM(driver);
		Payment_POM hot4 = new Payment_POM(driver);
 hot.enterhotel();
 hot.entercountry();
 hot.locationname("OOTY");
 hot.checkin();
 
 String a = null;
 String b = null;
 String c = null;
 
 hot.checkout(a,b);
 hot.selectguestroom(c);
 hot.searchhot(); 
 
//saving hotel name and hotel search count
String hotelname = hot1.clickhotel();
hot2.selectroom(hotelname);

//verifying hotel name
hot3.verify_booking_details(Searchhotelpom.a, Searchhotelpom.b, Searchhotelpom.c);
hot3.Enter_guest_details();
hot4.entercarddetails();

driver.quit();
 }
}
