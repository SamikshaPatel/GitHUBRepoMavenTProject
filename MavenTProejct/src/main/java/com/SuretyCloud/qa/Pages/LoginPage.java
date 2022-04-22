package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.SuretyCloud.qa.base.TestBase;


public class LoginPage extends TestBase {
	// Page Factory- OR
	
	//Using FindBy for locating elements
	// @FindBy(how=How.ID,using="loginForm:emailAddress") WebElement txt_userName;	
	//@FindBy(how=How.XPATH, using="//*[@id=\"loginTable\"]/tbody/tr/td[1]/a/div[1]") WebElement SClogo;
	
		@FindBy(id="loginForm:emailAddress") WebElement txt_userName;
		@FindBy(id="loginForm:password") WebElement txt_password;
		@FindBy(id="loginForm:submit") WebElement btn_submit;
		@FindBy(id="logoutForm:Logout") WebElement btn_logout;
		@FindBy(xpath="//*[@id=\"loginTable\"]/tbody/tr/td[1]/a/div[1]") WebElement SClogo;
		
		// Initializing the Page objects
		
		public LoginPage() {
			
			PageFactory.initElements(driver,this);//---this refers to the LoginPage class
		}
		
		// Defining all the user actions (Methods) that can be performed in the Login Page
		
			//public HomePage login (String sUserName,String sPassword) {
			public HomePage login (String sTestCaseName, String sUserName,String sPassword) {	
				System.out.println("Landed On Login Page");
				System.out.println("Test Case Being executed = " + sTestCaseName);
				
				new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(txt_userName)).click();
				//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeSelected(txt_userName));
				txt_userName.clear();
				txt_userName.click();
				txt_userName.sendKeys(sUserName); // Enter User_id
								
				txt_password.clear();
				txt_password.click();
				txt_password.sendKeys(sPassword); // Enter Password
							
				btn_submit.click(); //Click on Submit button
				
				new WebDriverWait(driver, 20).until(ExpectedConditions.textToBePresentInElement(HomePage.HMPage_Title, "Home"));		
				System.out.println("Landed On Home Page");
				String title = CommonWeb.validatePageTitle();
				Assert.assertEquals(title,"Home","Page title is not matching"); //after successful login, validate page title
				
				return new HomePage(); // This method is returning HomePage class object				
			} 
			
		public boolean validateSClogo() {
			return SClogo.isDisplayed();
		}	
}
