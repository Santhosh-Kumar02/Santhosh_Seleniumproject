package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Searchhotelpom {
	WebDriver driver;
	public static String a = null;
	public static String b = null;
	public static String c = null;
	
	By hotel=By.xpath("//span[contains(text(),'Hotels')]");
	By country=By.xpath("//div[@class='SearchBlockUIstyles__HotelTypeSelectWrap-fity7j-3 hbNGIH']//div[1]//input[1]");
	By locname=By.id("downshift-1-input");
	
	By checkincal = By.xpath("//div[@data-testid='openCheckinCalendar']//h4");
	By calnavigate = By.xpath("//div[@class='dcalendarstyles__MonthChangeRightArrowDiv-r2jz2t-16 fKhSuo']//div[@class='dcalendarstyles__SliderArrow-r2jz2t-14 hOuIUr']");
	By Checkindate = By.xpath("//span[normalize-space()='2']");
	
	By checkoutcal = By.xpath("//div[@data-testid='openCheckoutCalendar']//h4");
	By Checkoutdate = By.xpath("//ul[@class='dcalendarstyles__DateWrapDiv-r2jz2t-7 jXPZCe']//li[5]//span");
	
	By guestrooms = By.xpath("//div[@class='SearchBlockUIstyles__SearchInputWrap-fity7j-11 kQVDaW']//input[@class='SearchBlockUIstyles__CitySearchInput-fity7j-12 gPhhhX']");
	By Selectguest = By.xpath("//div[@class='SearchBlockUIstyles__AutoSuggestInnerWrap-fity7j-1 eTLsVu']//div[2]//div[1]//span[1]");
	By Confirmguest = By.xpath("//button[contains(text(),'Done')]");

	By Searchhotel = By.xpath("//button[normalize-space()='Search Hotels']");
	By hotels = By.tagName("h4");
	By hotelname = By.xpath("(//h4)[1]");
	By morelinks = By.xpath("//li[normalize-space()='more links']");
	
	By checkintxt = By.xpath("(//h4)[3]");
	By checkouttxt = By.xpath("(//h4)[4]");
	By guestinfo = By.xpath("//div[@class='SearchBlockUIstyles__SearchInputWrap-fity7j-11 kQVDaW']//input[@class='SearchBlockUIstyles__CitySearchInput-fity7j-12 gPhhhX']");
	
	public Searchhotelpom (WebDriver driver) {
		this.driver=driver;
	}
	
	public Searchhotelpom (String a, String b) {
	this.a=a;
	this.b=b;
	this.c=c;
	}

	public Searchhotelpom (String c) {
		this.c=c;
		}
	
	public void enterhotel() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(hotel).click();
	}
	public void entercountry() throws InterruptedException
	{
		Thread.sleep(2000);
	driver.findElement(country).click();	
	}
	public void locationname(String LOC) throws AWTException, InterruptedException
	{
		driver.findElement(locname).sendKeys(LOC);
		Thread.sleep(1000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	r= null;
	System.gc();
	}
	
	public void checkin()
	{
		driver.findElement(checkincal).click();
		//driver.findElement(calnavigate).click();
		driver.findElement(calnavigate).click();
		driver.findElement(Checkindate).click();
		
	}
	
	public Searchhotelpom checkout(String a,String b)
	{
		//driver.findElement(checkoutcal).click();
		//driver.findElement(checkoutcal).click();
		driver.findElement(Checkoutdate).click();
		a= driver.findElement(checkintxt).getText();
		b= driver.findElement(checkouttxt).getText();
		
return new Searchhotelpom(a,b);
	}
	
	public void checkout()
	{
		//driver.findElement(checkoutcal).click();
		//driver.findElement(checkoutcal).click();
		driver.findElement(Checkoutdate).click();
	}
	

	public Searchhotelpom selectguestroom(String c) {
		driver.findElement(guestrooms).click();
		driver.findElement(Selectguest).click();
		driver.findElement(Confirmguest).click();
		c =driver.findElement(guestinfo).getAttribute("value");
		return new Searchhotelpom(c);
	}
	public void selectguestroom() {
		driver.findElement(guestrooms).click();
		driver.findElement(Selectguest).click();
		driver.findElement(Confirmguest).click();
}
	
	public void searchhot() throws InterruptedException {
		driver.findElement(Searchhotel).click();
	
		//get hotel counts
		Thread.sleep(2000);
		List<WebElement> hots = driver.findElements(hotels);
		int a = hots.size();
		Reporter.log("Count of hotels is:" + a +"<p>");
		
		//get hotel name
		Thread.sleep(2000);
		WebElement h = driver.findElement(hotelname);
		String Hotname = h.getText();
		Reporter.log("Hotel Name is:" + Hotname+"<p>");
		
	}
	
	public Integer searchhot(int x) throws InterruptedException {
		driver.findElement(Searchhotel).click();
	
		//get hotel counts
		Thread.sleep(2000);
		List<WebElement> hots = driver.findElements(hotels);
		int a = hots.size();
		Reporter.log("Count of hotels is:" + a +"<p>");
		
		//get hotel name
		Thread.sleep(2000);
		WebElement h = driver.findElement(hotelname);
		String Hotname = h.getText();
		Reporter.log("Hotel Name is:" + Hotname+"<p>");
		return a;
		
	}
}
