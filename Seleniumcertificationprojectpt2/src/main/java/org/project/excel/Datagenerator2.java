package org.project.excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datagenerator2 {
	@DataProvider(name="excel2")
	public static Object[] testvalues() throws Exception {
		
		File credentials=new File("./Testvalueexcel/Testvalues.xlsx");
		
		FileInputStream fis=new FileInputStream(credentials);
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet1=wb.getSheetAt(1);
		
		int rc=sheet1.getPhysicalNumberOfRows();
		Object[] testvalue=new Object[rc];
		
		for(int i=0;i<rc;i++)
		{
			XSSFRow row=sheet1.getRow(i);
			XSSFCell searchval=row.getCell(0,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			//XSSFCell passvalue=row.getCell(1,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			testvalue[i]=searchval.getStringCellValue();
			//testvalue[i]=passvalue.getStringCellValue();
		}
		return testvalue;
	}
	
}
