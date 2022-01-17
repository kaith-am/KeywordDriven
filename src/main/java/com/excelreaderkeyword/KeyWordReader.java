/**
 * 
 */
package com.excelreaderkeyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

/**
 * @author 91888
 *
 */
public class KeyWordReader {

  public Workbook w;
  public WebDriver driver;
  public WebElement element;
  public Properties p;
  public Sheet sheet;
  public Row row;
  
  /**
 * 
 */
public void keywordExcelReader(String fileName, String sheetName) {
	// TODO Auto-generated method stub
	try {
		FileInputStream fis = new FileInputStream(fileName);
		w = new XSSFWorkbook(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    sheet = w.getSheet(sheetName);
	int pom = sheet.getPhysicalNumberOfRows();
	for(int i=0; i<pom-1; i++)
	{
		 row = sheet.getRow(i+1);
		 String locator = row.getCell(2).getStringCellValue();
		 String locatorValue = row.getCell(3).getStringCellValue();
		 String action = row.getCell(4).getStringCellValue();
		 String value = row.getCell(5).getStringCellValue();
		 
		 if(!locator.isEmpty() || locator.equalsIgnoreCase("na"))
		 {
			try {
				switch(locator)
				{
				case "xpath":
					element = driver.findElement(By.xpath(locatorValue));
					break;
				case "id":
					element = driver.findElement(By.id(locatorValue));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 // action method
		 if(!action.isEmpty()||action.equalsIgnoreCase("na"))
		 {
			 try {
				switch(action)
				 {
				 case "open browser":
					if(value!=null)
					{
						driver= BaseClass.openBrowser(value);
					}
					else
					{
						p = BaseClass.propertiesReader("C:\\Users\\91888\\eclipse-workspace\\KeywordDriven\\testdata.properties");
						String browser= p.getProperty("browser");
					    driver = BaseClass.openBrowser(browser);
					}
					break;
				 case "url launch":
					 driver.get(value);
					 break;
				 case "send keys":
					 element.clear();
					 element.sendKeys(value);
					 break;
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}

}
  
	
}
