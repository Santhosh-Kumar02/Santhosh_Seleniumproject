
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Payment_POM {

	WebDriver driver;
	By cardnum = By.xpath("(//input[@placeholder='Card Number'])[1]");
	By nameincard = By.xpath("(//input[@placeholder='Name'])[1]");
	By expiryd = By.xpath("(//input[@placeholder='MM / YY'])[1]");
	By cvv = By.xpath("(//input[@placeholder='CVV NO.'])[1]");
	By paybutton = By.xpath("(//button[@class='button green large citipatBtn btn payNowBtn'])[1]");
    
	By address = By.xpath("(//input[@placeholder='811 North Cataline Avenue, No.3002'])[1]");
	By zip = By.xpath("(//input[@placeholder='560076'])[1]");
	By city = By.xpath("(//input[@placeholder='City'])[1]");
	By state = By.xpath("(//input[@placeholder='State'])[1]");
	By error = By.xpath("//p[contains(text(),'Please Enter Valid Card Number')]");
	
	public Payment_POM(WebDriver driver) {
this.driver=driver;
}	
	
	public void entercarddetails(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cardnum));
		driver.findElement(cardnum).sendKeys("7373983238574932");
		driver.findElement(nameincard).sendKeys("Santhosh");
		driver.findElement(expiryd).sendKeys("08/23");
		driver.findElement(cvv).sendKeys("987");
		//driver.findElement(address).sendKeys("7g, pillayar koil street");
		//driver.findElement(city).sendKeys("Chennai");
		//driver.findElement(zip).sendKeys("32432");
		//driver.findElement(state).sendKeys("Tamil Nadu");
		driver.findElement(paybutton).click();
		
		Boolean is = driver.findElement(error).isDisplayed();
		Assert.assertTrue(is);
		
		System.out.print("Error message verified");
		Reporter.log("Error message in payments page is verified"+"<p>");
		
    
	}   
}
