package pom;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
public class SelectroomPOM {
	
	WebDriver driver;
	By selectroom = By.xpath("//div[@class='TextFieldExpt__Tag-sc-7a7pro-0 fRzssR']");
	By selectroom1 = By.xpath("(//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-9 RoomFlavorstyles__ButtonWrapper-sc-1btnl3r-15 bdisym bCgKhF'])[1]");
	By acthotelname = By.xpath("(//h3)[1]");
	By images_link = By.xpath("(//p)[1]");
	//By imagelink = By.xpath("//body/div[@id='modal-root']/div[@class='HotelsModal__Modal-rgix69-1 gwNsNy']/div[@class='HotelsModal__ModalGuts-rgix69-2 coUOZc']/section[@class='CaptivateAllImageModalstyles__CaptivateAllImageModalInnerWrap-sc-1qs4uea-0 fWesaY']/div[@class='CaptivateAllImageModalstyles__LeftOuterContainer-sc-1qs4uea-15 ckLkit']/div[@class='CaptivateAllImageModalstyles__CaptivateLeftContainer-sc-1qs4uea-3 kUhhnh']/div[1]/img[1]");
	By imgclose = By.xpath("//div[@class='CaptivateAllImageModalstyles__CaptivateRightTopWrap-sc-1qs4uea-6 kRxKMl']//div[@class='dwebCommonstyles__CenteredSpaceWrap-sc-112ty3f-0 jIrlaB']//*[local-name()='svg']");
	
	By loc = By.xpath("//a[normalize-space()='Location']");
	By loc_verify = By.xpath("//div[@class='LocationMapstyles__ContentContainer-caml-2 gUnDCA']");
	
	By greview= By.xpath("//a[normalize-space()='Guest Reviews']");
	By greview_verify = By.xpath("//div[@class='RnRstyles__ReviewByUserWrapperDiv-sc-1i6bb0l-8 bmoTPm']");
	
	By qna = By.xpath("//a[normalize-space()='Questions & Answers']");
	By qna_verify = By.xpath("(//div[@class='UserAnswerstyles__WrapperDiv-sc-1c5jue4-0 anIYY'])[1]");

	By hpolicy = By.xpath("//a[normalize-space()='Hotel Policies']");
	By hpolicy_verify = By.xpath("//ul[@class='Policystyles__PolicyListBlock-sc-1vd94lq-3 jTNnrQ']");
	
	// = By.xpath("");
	
	
	public SelectroomPOM(WebDriver driver) {
	this.driver=driver;
	}

	public void selectroom(String hname) throws InterruptedException {
		Set<String> awin = driver.getWindowHandles();	
		//switch to new window
		Iterator<String> win = awin.iterator();
		//getting current window handle
		win.next();
		String newwin = win.next();
		driver.switchTo().window(newwin);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(acthotelname));
		
	//Verify hotelname and click on select room
String actualhotelname = driver.findElement(acthotelname).getText();	
Assert.assertEquals(actualhotelname, hname);
System.out.print("Hotel name verified");
Reporter.log("<p>"+"Hotel name verified"+"<p>");
driver.findElement(selectroom).click();
WebDriverWait wait1 = new WebDriverWait(driver,10);
wait1.until(ExpectedConditions.visibilityOfElementLocated(selectroom1));


//
driver.findElement(selectroom1).click();
}
	public void selectroom2(String hname) throws InterruptedException {
		Set<String> awin = driver.getWindowHandles();	
		//switch to new window
		Iterator<String> win = awin.iterator();
		//getting current window handle
		win.next();
		String newwin = win.next();
		driver.switchTo().window(newwin);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(acthotelname));
		
	//Verify hotelname and click on select room
String actualhotelname = driver.findElement(acthotelname).getText();	
Assert.assertEquals(actualhotelname, hname);
System.out.print("Hotel name verified");
Reporter.log("<p>"+"Hotel name verified");
}
	
	public void log_image(WebDriver driver, String filpath) throws IOException {
	driver.findElement(images_link).click();    
	
TakesScreenshot scrn =((TakesScreenshot)driver);
File src =scrn.getScreenshotAs(OutputType.FILE);

File dest = new File(filpath);
FileUtils.copyFile(src, dest);
Reporter.log("<p>"+"Room image has been logged in the following location" + "<p>"+filpath);
driver.findElement(imgclose).click(); 
	}

public void verify_location() {
	driver.findElement(loc).click();
	boolean lverify = driver.findElement(loc_verify).isDisplayed();
	Assert.assertTrue(lverify);
	System.out.println("");
	System.out.println("Location menu has been verified");
	Reporter.log("<p>"+"Location menu has been verified"+"<p>");
}

public void verify_Guestreview() {
	driver.findElement(greview).click();
	boolean gverify = driver.findElement(greview_verify).isDisplayed();
	Assert.assertTrue(gverify);
	System.out.println("Guest Reviews menu has been  verified");
	Reporter.log("<p>"+"Guest Reviews menu has been  verified"+"<p>");
}

public void verify_qna() {
	driver.findElement(qna).click();
	boolean qverify = driver.findElement(qna_verify).isDisplayed();
	Assert.assertTrue(qverify);
	System.out.println("Question and Answers verify menu has been verified");
	Reporter.log("Question and Answers verify menu has been verified"+"<p>");
}

public void verify_hotelpolicies() {
	driver.findElement(hpolicy).click();
	boolean pverify = driver.findElement(hpolicy_verify).isDisplayed();
	Assert.assertTrue(pverify);
	System.out.println("Hotel policies menu has been verified");
	Reporter.log("Hotel policies menu has been verified"+"<p>");
}
	
}
