package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SuretyCloud.qa.base.TestBase;

	public class CommonWeb extends TestBase {
	// Initializing the Pageobjects
			public CommonWeb() {				
				PageFactory.initElements(driver,this);//---this refers to the CommonWeb class
			}
			
	// Page objects goes here		
			@FindBy(id="logoutForm:Logout") static WebElement btn_logout;
			@FindBy(xpath="//*[@id=\"loginTable\"]/tbody/tr/td[1]/a/div[1]") WebElement SClogo;
			
	//Methods goes here			
	public static String validatePageTitle() {
		return driver.getTitle();
	}	
	
	public static void logOut() {
		if (btn_logout != null) {
			btn_logout.click(); 
		}
	}
		
// JAVASCRIPT METHODS GOES HERE
		
	public static void scrollDown() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 	
       
	    //js.executeScript("window.scrollBy(0,1000)");// This  will scroll down the page by  1000 pixel vertical	
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	  //This will scroll the web page till end.		
        //js.executeScript("arguments[0].scrollIntoView();", Element);//This will scroll the page till the element is found	
		}
	
	public static WebElement scrollUntilElementVisible (WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		return element; 
		
		
	}
}
