package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SuretyCloud.qa.base.TestBase;

public class AttachmentsTab extends TestBase {
	// Page Factory- OR
	
	//@FindBy(xpath="//*[@id='j_id725_lbl']") WebElement tab_Attachments;  //Attachments tab  ---- WHEN NOT SELECTED
	@FindBy(xpath="//*[contains(text),'Attachments']") WebElement tab_Attachments;  //Attachments tab  ---- WHEN NOT SELECTED
	
	// Initializing the Page objects
	
	public AttachmentsTab() {				
		PageFactory.initElements(driver,this);//---this refers to the LoginPage class
		}
						
				//---------------------------------- ADD FUNCTIONS CODE HERE --------------------------------	
	
	public void select_Attachments_Tab() {
			new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElement(tab_Attachments, "Attachments"));
			if (!tab_Attachments.isSelected()) {
				tab_Attachments.click();					
					try {Thread.sleep(3000);
					} catch (InterruptedException e)
						{e.printStackTrace();}						
					System.out.println("Attachments tab is selected now");}
			else {
				System.out.println("Attachments tab is selected");
				}				
			}
	}


