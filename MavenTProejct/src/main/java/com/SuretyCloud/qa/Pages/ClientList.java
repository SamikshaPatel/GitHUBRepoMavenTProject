package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.SuretyCloud.qa.base.TestBase;

//Client list page and CLient's Account profile objects and locators are stored here

public class ClientList extends TestBase {	
	// Initializing the Pageobjects
	
	public ClientList() {		
		PageFactory.initElements(driver,this);//---this refers to the ClientList class
	}
	
	//Client list's Page Object Locators goes here
	@FindBy(xpath="//*[@id='pageHead']//div[3]//div[1]//div") static WebElement ClientListPagetitle; //ClientList's page title object
	
	@FindBy(id="accountListForm:account") WebElement txt_client_Search;
	@FindBy(id="accountListForm:srch") WebElement btn_Search;
	@FindBy(linkText="BondAmt1") WebElement client_Selection;
	
	
	//Client account Profile page's locators goes here
	@FindBy(xpath="//*[@id='pageHead']/div[3]/div[1]/div]") WebElement ClientAccProfilePagetitle; //Client's Account Profile page title object
	// Methods goes here
	
	public void clientSelection (String sClientName) {
		txt_client_Search.click();
		txt_client_Search.sendKeys(sClientName);
		btn_Search.click();
		client_Selection.click();	
		new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElement(ClientAccProfilePagetitle, "Account Profile"));
		System.out.println("Landed On Client's Account Profile page ");	
		String Client_AccProfile_title = CommonWeb.validatePageTitle();
		Assert.assertEquals(Client_AccProfile_title,"Account Profile", "Page title is not matching");
	}
	public String validateClientListTitle() {
		return driver.getTitle();
	}	
		
}


