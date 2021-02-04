package org.project.test;


import org.project.POM.Result_page_POM;
import org.project.POM.Search_page_POM;
import org.project.base.Base;
import org.project.excel.Datagenerator3;
import org.testng.annotations.Test;



public class Test_Search_products extends Base{

@Test(dataProvider="excell",dataProviderClass=Datagenerator3.class)
public void searchprod(String searchval, String temp) throws Exception {
	
	Search_page_POM search = new Search_page_POM(driver);
	Result_page_POM res = new Result_page_POM(driver);
	
//String searchitem = "NIKE SHOES";
search.enter_value(searchval);
search.Click_search();
search.click_result();	
	res.get_product_name_and_price();
}
	
	

	
	
	
	
	
}
