/**
 * 
 */
package com.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author 91888
 *
 */
public class BaseClass {
public static WebDriver driver;
public static Properties p;
/**
 * 
 */
public static WebDriver openBrowser(String browserName) {
	try {
		switch(browserName)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			break;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return driver;
}
/**
 * 
 */
public static Properties propertiesReader(String fileName) {
	try {
		FileInputStream fis = new FileInputStream(fileName);
		p = new Properties();
		p.load(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;
	

}
}
