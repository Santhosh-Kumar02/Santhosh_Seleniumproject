package org.project.POM;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.poifs.nio.ByteArrayBackedDataSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.utility.Utility;
import org.testng.Reporter;

public class Result_page_POM {
WebDriver driver;
public static String nam = null;
public static String oprice = null;
public static String orprice = null;


public Result_page_POM(WebDriver driver){
this.driver = driver;
}

public void get_product_name_and_price() throws Exception {
	
	Set<String> awin = driver.getWindowHandles();	
	//switch to new window
	Iterator<String> win = awin.iterator();
	//getting current window handle
	win.next();	
	String newwin = win.next();
	driver.switchTo().window(newwin);
	

	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchlocaterValue("prodname"))));	
	
	String name = driver.findElement(By.xpath(Utility.fetchlocaterValue("prodname"))).getText();
	String offprice = driver.findElement(By.xpath(Utility.fetchlocaterValue("prodfprice"))).getText();
	String orgprice = driver.findElement(By.xpath(Utility.fetchlocaterValue("prodoprice"))).getText();

	Reporter.log("product name is: " + name + "<p>");
	Reporter.log("Offer price is: " + offprice + "<p>");
	Reporter.log("Original price is: " + orgprice + "<p>");
}




}
