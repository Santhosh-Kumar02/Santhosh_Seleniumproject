package org.project.test;

import org.project.POM.Login_page_POM;
import org.project.base.Base;
import org.project.excel.Datagenerator3;
import org.testng.annotations.Test;

public class Test_Validate_login extends Base {
	
	@Test(dataProvider="excell",dataProviderClass=Datagenerator3.class)
	public void checklogin(String email,String pwd) throws Throwable
	{
		Login_page_POM login=new Login_page_POM(driver);
		login.clicksignin();
		login.enteremail(email);
		login.enterpassword(pwd);
		login.ClickLogin();
		Thread.sleep(2000);
		login.verify_incorrect_login();	
	}
}
