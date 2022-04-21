package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SuretyCloud.qa.base.TestBase;

public class BondNotesTab extends TestBase{

	// Page Factory- OR
		//@FindBy(xpath="//*[@id='j_id729_lbl']") WebElement tab_BondNotes;  //BondNotes tab---- WHEN NOT SELECTED
		@FindBy(xpath="//*[contains(text),'Bond Notes']") WebElement tab_BondNotes;  //BondNotes tab---- WHEN NOT SELECTED

		// Initializing the Page objects
		
					public BondNotesTab() {				
						PageFactory.initElements(driver,this);//---this refers to the LoginPage class
					}
							
//---------------------------------- ADD FUNCTIONS CODE HERE --------------------------------	
					public void select_BondNotes_Tab() {
						new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElement(tab_BondNotes, "Bond Notes"));
						if (!tab_BondNotes.isSelected()) {
							tab_BondNotes.click();					
								try {Thread.sleep(3000);
								} catch (InterruptedException e)
									{e.printStackTrace();}						
								System.out.println("Bond Notes tab is selected now");}
						else {
							System.out.println("Bond Notes tab is selected");
							}				
						}
}
