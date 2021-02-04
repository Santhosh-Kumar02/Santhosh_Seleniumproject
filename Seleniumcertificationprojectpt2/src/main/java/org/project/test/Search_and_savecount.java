package 
org.project.test;
import org.project.POM.Search_page_POM;
import org.project.base.Base;
import org.testng.annotations.Test;

@Test
public class Search_and_savecount extends Base {

	@Test(testName = "search and verify count", description = "Search a product and verify the count of results")
	public void savecount() throws Exception {
		
	Search_page_POM ver = new Search_page_POM(driver);

	ver.enter_value("headphone");
	ver.robot_click();
	ver.verifycounts();
	}	
}