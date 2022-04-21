package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SuretyCloud.qa.base.TestBase;

public class IssuanceTab extends TestBase{

	// Page Factory- OR
	
		//@FindBy(xpath="//*[@id='j_id728_lbl']") WebElement tab_Issuance;  //Issuance tab---- WHEN NOT SELECTED
		@FindBy(xpath="//*[contains(text),'Issuance']") WebElement tab_Issuance;  //Issuance tab---- WHEN NOT SELECTED
		

		// Initializing the Page objects
		
			public IssuanceTab() {				
				PageFactory.initElements(driver,this);//---this refers to the LoginPage class
				}
							
//---------------------------------- ADD FUNCTIONS CODE HERE --------------------------------	
			public void select_Issuance_Tab() {
				new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElement(tab_Issuance, "Issuance"));
				if (!tab_Issuance.isSelected()) {
					tab_Issuance.click();					
						try {Thread.sleep(3000);
						} catch (InterruptedException e)
							{e.printStackTrace();}						
						System.out.println("Issuance tab is selected now");}
				else {
					System.out.println("Issuance tab is selected");
					}				
				}
}
