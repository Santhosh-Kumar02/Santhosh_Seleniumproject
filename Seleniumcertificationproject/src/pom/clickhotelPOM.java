package pom;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class clickhotelPOM {

	WebDriver driver;
	
	By hotelname = By.xpath("(//h4)[1]");
	By hotellist = By.xpath("//*[@itemprop='name']");
	By payathotel = By.xpath("(//span[@class='ToggleButtonListstyles__FilterToggleCircularSwitch-sc-148wx03-7 fJBRPT'])[3]");
	By rating4 = By.xpath("//div[@class='Filtersstyles__AverageReviewWrapper-bkjigy-8 ipQgCe']");
	By price = By.xpath("(//span)[66]");
	By verify_rating4 = By.xpath("//span[contains(text(),'4+')]");
	By verify_price = By.xpath("//div[@class='Chip-o2aze2-0 kLlkpl']//span//span[contains(text(),'₹2001 - ₹4000')]");
	
	public clickhotelPOM (WebDriver driver) {
		this.driver=driver;
	}
	
	public String clickhotel()
	{
		WebDriverWait mywait=new WebDriverWait(driver,10);
		  mywait.until(ExpectedConditions.visibilityOfElementLocated(hotelname));
		  
		WebElement comp=driver.findElement(hotelname);
		  Actions act = new Actions(driver);
		  act.moveToElement(comp).perform();
		  
		driver.findElement(hotelname).click();
		
String hname = driver.findElement(hotelname).getText();
		return hname;
	}

	public Integer clickhotel1()
	{
		WebDriverWait mywait=new WebDriverWait(driver,10);
		  mywait.until(ExpectedConditions.visibilityOfElementLocated(hotelname));
		  
		  List<WebElement> hotels = driver.findElements(hotellist);
			int count = hotels.size();
		return count;
	}
	
	public void filter_payathotel() {
		
		WebDriverWait mywait=new WebDriverWait(driver,10);
		  mywait.until(ExpectedConditions.visibilityOfElementLocated(payathotel));
		  driver.findElement(payathotel).click();
			System.out.println("'pay at hotel' filter has been applied");
			Reporter.log("'pay at hotel' filter has been applied"+"<p>");

	}
	public void filter_rating4() {
		WebDriverWait mywait=new WebDriverWait(driver,10);
		  mywait.until(ExpectedConditions.visibilityOfElementLocated(rating4));
		driver.findElement(rating4).click();
		System.out.println("'4+ rating' filter has been applied");
		Reporter.log("'4+ rating' filter has been applied"+"<p>");
		
	}
	public void filter_price() {
		WebDriverWait mywait=new WebDriverWait(driver,10);
		  mywait.until(ExpectedConditions.visibilityOfElementLocated(price));
		driver.findElement(price).click();
		System.out.println("'price range ₹2000-₹4000' filter has been applied");
		Reporter.log("'price range ₹2000-₹4000' filter has been applied"+"<p>");
	}
	
	public void verify_filter_price() throws InterruptedException {
		Thread.sleep(3000);
		boolean verprice =  driver.findElement(verify_price).isDisplayed();
	Assert.assertTrue(verprice);
	System.out.println("Filter by price range verified");
	Reporter.log("Filter by price range verified"+"<p>");
	}
	
	public void verify_rating4() {
		boolean verprice =  driver.findElement(verify_rating4).isDisplayed();
	Assert.assertTrue(verprice);
	System.out.println("Filter by rating-4 verified");
	Reporter.log("Filter by rating-4 verified"+"<p>");
	}	
	
	
	
}
