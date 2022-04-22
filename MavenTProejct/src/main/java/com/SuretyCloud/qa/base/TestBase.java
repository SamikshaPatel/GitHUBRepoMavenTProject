package com.SuretyCloud.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.SuretyCloud.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase() {  // this is a constructor
		//load property file
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/shamiksha/Documents/SeleniumProject2020/MavenTProejct/src/main/java/com/SuretyCloud/qa/config/config.properties");
		prop.load(ip);
		//initialization();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}	
	
	public  void initialization() {
		//read properties
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shamiksha\\Documents\\SeleniumProject2020\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();  
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\shamiksha\\Documents\\SeleniumProject2020\\msedgedriver.exe");
		    driver = new EdgeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\shamiksha\\Documents\\SeleniumProject2020\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}else if(browserName.equals("IE")) {
		    System.setProperty("webdriver.ie.driver", "C:\\Users\\shamiksha\\Documents\\SeleniumProject2020\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	//	long Page_Load_Iimeout= prop.getProperty("page_load_timeout");
	//	long Implicit_Wait= prop.getProperty("implicit_wait");
		
	//  driver.manage().timeouts().pageLoadTimeout(Page_Load_Iimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void close_browser() {
		if (driver != null) {
		driver.close();}
		//TestBase.driver.quit();
	}
	
}
