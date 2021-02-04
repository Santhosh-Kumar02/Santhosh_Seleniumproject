package org.project.excel;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datagenerator3 {
	@DataProvider(name="excell")
	public static Object[][] testvalues(Method met) throws Exception {

		File credentials=new File("./Testvalueexcel/Testvalues.xlsx");
		
		FileInputStream fis=new FileInputStream(credentials);
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		if (met.getName().equalsIgnoreCase("checklogin")) {
			 sheet1=wb.getSheetAt(0);	
		}
		else {
			sheet1=wb.getSheetAt(1);
		}

		int rc=sheet1.getPhysicalNumberOfRows();
		Object[][] testvalue=new Object[rc][2];
		
		for(int i=0;i<rc;i++)
		{
			XSSFRow row=sheet1.getRow(i);
			XSSFCell emailid=row.getCell(0,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell passvalue=row.getCell(1,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			testvalue[i][0]=emailid.getStringCellValue();
			testvalue[i][1]=passvalue.getStringCellValue();
		}
		return testvalue;
	

	}
	
}
