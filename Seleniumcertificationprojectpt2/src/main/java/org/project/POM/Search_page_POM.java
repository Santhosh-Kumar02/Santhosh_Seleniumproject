package org.project.POM;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.utility.Utility;
import org.testng.Assert;
import org.testng.Reporter;
public class Search_page_POM {
WebDriver driver;

public Search_page_POM(WebDriver driver)
{
		this.driver=driver;
}
public void enter_value(String searchitem) throws Exception {
	boolean aler=	driver.findElement(By.xpath(Utility.fetchlocaterValue("ale"))).isDisplayed();
	if(aler==true) {
		driver.findElement(By.xpath(Utility.fetchlocaterValue("ale"))).click();
	}
	
	driver.findElement(By.xpath(Utility.fetchlocaterValue("searchbox"))).sendKeys(searchitem);
}

public void Click_search() throws Exception {
	driver.findElement(By.xpath(Utility.fetchlocaterValue("searchbtn"))).click();
}

public void click_result() throws Exception {
	driver.findElement(By.xpath(Utility.fetchlocaterValue("firstprd"))).click();
}
public void robot_click() throws AWTException {
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}

public void verifycounts() throws NumberFormatException, Exception {
int a = 	Integer.parseInt(driver.findElement(By.xpath(Utility.fetchlocaterValue("resultcount"))).getText());
boolean is = (a>0);
Assert.assertTrue(is);
Reporter.log("Search result counts verified" + "<P>");
Reporter.log("Count is:" + a);
}
}