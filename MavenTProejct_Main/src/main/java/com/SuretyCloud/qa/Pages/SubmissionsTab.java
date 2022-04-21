package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SuretyCloud.qa.base.TestBase;

public class SubmissionsTab extends TestBase {

	// Page Factory- OR
	
		
		//@FindBy(xpath="//*[@id='j_id726_lbl']") WebElement tab_Submissions;  //Submissions tab ---- WHEN NOT SELECTED
		@FindBy(xpath="//*[contains(text),'Submissions']") WebElement tab_Submissions;  //Submissions tab ---- WHEN NOT SELECTED
		

		// Initializing the Page objects
		
	public SubmissionsTab() {				
		PageFactory.initElements(driver,this);//---this refers to the LoginPage class
		}
							
//---------------------------------- ADD FUNCTIONS CODE HERE --------------------------------	
	public void select_Submissions_Tab() {
		new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElement(tab_Submissions, "Submissions"));
		if (!tab_Submissions.isSelected()) {
			tab_Submissions.click();					
				try {Thread.sleep(3000);
				} catch (InterruptedException e)
					{e.printStackTrace();}						
				System.out.println("Submissions tab is selected now");}
		else {
			System.out.println("Submissions tab is selected");
			}				
		}
}
