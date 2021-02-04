package org.project.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.utility.Utility;
import org.testng.Reporter;

public class Login_page_POM {
WebDriver driver;

	public  Login_page_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clicksignin() throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchlocaterValue("signin_btn"))).click();
	}
	public void enteremail(String mail) throws Exception
	{
		boolean aler=	driver.findElement(By.xpath(Utility.fetchlocaterValue("ale"))).isDisplayed();
				if(aler==true) {
					driver.findElement(By.xpath(Utility.fetchlocaterValue("ale"))).click();
				}
		driver.findElement(By.id(Utility.fetchlocaterValue("Login_id"))).sendKeys(mail);	
	}

	public void enterpassword(String pwd) throws Exception
	{
		driver.findElement(By.name(Utility.fetchlocaterValue("Password_name"))).sendKeys(pwd);
	}

	public void ClickLogin() throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchlocaterValue("Login_btn"))).click();
	}
	
	public void verify_incorrect_login() 
	{
		try {
			if (driver.findElement(By.xpath(Utility.fetchlocaterValue("mailerrclass"))).isDisplayed()==true){
				Reporter.log("'" + driver.findElement(By.xpath(Utility.fetchlocaterValue("mailerrclass"))).getText()+ "'" + "Error message has been verified" + "<p>");
				//System.out.println("'Please enter valid email id' Error message has been verified");
			}
			else if ( driver.findElement(By.xpath(Utility.fetchlocaterValue("pwderrclass"))).isDisplayed()==true) {
				Reporter.log("'" + driver.findElement(By.xpath(Utility.fetchlocaterValue("pwderrclass"))).getText() + "'" + "Error message has been verified" + "<p>");
				//System.out.println("No error message present");
			}
			else {
				Reporter.log("No Error message available" + "<p>");
			}
		}
		
		catch (Exception e) {
		}
		
	
	
	}
}
	
