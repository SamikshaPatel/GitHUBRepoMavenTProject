package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SuretyCloud.qa.base.TestBase;

public class LPMStep1 extends TestBase {
	
	// Page Factory- OR
	//Step 1 objects
	@FindBy(xpath="//*[@id='subMenuForm']/table/tbody/tr/td[3]/a/span") WebElement lnk_NewBondRequest;
	@FindBy(id="selectBondTypeForm:bondType:0") WebElement radbtn_LPMBondRqt;
	@FindBy(id="selectBondTypeForm:bondType:1") WebElement radbtn_ContractBondRqt;
	@FindBy(id="selectBondTypeForm:cont") WebElement btn_Continue;
	
	// Initializing the Pageobjects
	
	public LPMStep1() {		
		PageFactory.initElements(driver,this);//---this refers to the LoginPage class
	}
	

//----------------- ADD FUNCTIONS CODE HERE ------------------------------------------
		
		public void lpmBRStep1() {			
			lnk_NewBondRequest.click();
			System.out.println("Landed on Create New Bond- Process Bar Step 1");
			radbtn_LPMBondRqt.click();
			btn_Continue.click();				
		}
		
}
