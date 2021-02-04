package pom;
import java.text.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Enter_guestdetailsPOM {
	WebDriver driver;
	By cin =By.xpath("(//p[@class='DurationBlockNew__CheckInWrapPara-sc-1977hwn-3 ljAwjt'])[1]");
	By cout=By.xpath("(//p[@class='DurationBlockNew__CheckInWrapPara-sc-1977hwn-3 ljAwjt'])[2]");
   By guest=By.xpath("(//p[@class='DurationBlockNew__CheckInWrapPara-sc-1977hwn-3 ljAwjt'])[3]");

   
   //guest details
   By fname=By.xpath("//input[@placeholder='Enter First Name']");
   By lname=By.xpath("//input[@placeholder='Enter Last Name']");
   By email=By.xpath("//input[@placeholder='Enter Email Address']");
   By phone =By.xpath("//input[@placeholder='Enter Phone Number']");
   By payment = By.xpath("//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-9 GuestDetailsBlockstyles__CustomButton-sc-1rzm4ar-6 bdisym hvAOPy']");
   
	public Enter_guestdetailsPOM(WebDriver driver) {
		this.driver= driver;
	}
	
	public void verify_booking_details(String a, String b, String c) throws InterruptedException, ParseException {
		Thread.sleep(2000);
		String d = driver.findElement(cin).getText();
		String e =driver.findElement(cout).getText();
		String f = driver.findElement(guest).getText();
	
//formatting booking data in new page to format available in searchi hotel page
		String td= d.split(" ")[1].trim();
		td = td.replaceFirst("^0*", "");
		String tm= d.split(" ")[2].trim();
		String ty= d.split(" ")[3].trim();		
		d=tm+td+ty;

		
		td= e.split(" ")[1].trim();
		td = td.replaceFirst("^0*", "");
		tm= e.split(" ")[2].trim();
		ty= e.split(" ")[3].trim();		
		e=tm+td+ty;

					
		f=f.replaceAll("[|]", "in");

		a=a.trim();
		a=a.replaceAll(",", "");
		a=a.replaceAll(" ", "");
		b=b.trim();
		b=b.replaceAll(",", "");
		b=b.replaceAll(" ", "");
		c=c.replaceAll(" ", "");
		f=f.replaceAll(" ", "");
		
		//verifying booking details
		Assert.assertEquals(d,a.trim());
		Assert.assertEquals(e, b.trim());
		Assert.assertEquals(f, c);
		
		System.out.println("");
		System.out.println("Booking details verified");
		Reporter.log("Booking details verified"+"<p>");
		
	a=null;
	b=null;
	c=null;
	d=null;
	e=null;
	f=null;
	}
	
	public void Enter_guest_details() {
	driver.findElement(fname).sendKeys("Santhosh");
	driver.findElement(lname).sendKeys("D");
	driver.findElement(email).sendKeys("sandycena@gmail.com");
	driver.findElement(phone).sendKeys("6381799834");
	driver.findElement(payment).click();
	}
}