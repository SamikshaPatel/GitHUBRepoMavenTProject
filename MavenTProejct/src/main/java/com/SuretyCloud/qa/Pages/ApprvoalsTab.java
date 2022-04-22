package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.SuretyCloud.qa.base.TestBase;

public class ApprvoalsTab extends TestBase{

	// Page Factory- OR
	
		
		@FindBy(xpath="//*[contains(text(),'Approvals']") WebElement tab_Approvals;  //Approvals tab ---- WHEN NOT SELECTED
		//@FindBy(xpath="//*[@id='j_id728_lbl']") WebElement tab_Issuance;  //Issuance tab---- WHEN NOT SELECTED

		// Initializing the Page objects
		
	public ApprvoalsTab() {				
		PageFactory.initElements(driver,this);//---this refers to the ApprovalsTab class
		}
							
//---------------------------------- ADD FUNCTIONS CODE HERE --------------------------------	
	public void select_Approvals_Tab() {
		new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElement(tab_Approvals, "Approvals"));
		if (!tab_Approvals.isSelected()) {
			tab_Approvals.click();					
				try {Thread.sleep(3000);
				} catch (InterruptedException e)
					{e.printStackTrace();}						
				System.out.println("Approvals tab is selected now");}
		else {
			System.out.println("Approvals tab is selected");
			}				
		}
	
	public void verifyApproval_TabContent (String expectedBondSelected, String expectedBondAmt) {
		
		select_Approvals_Tab();
		
	//	String actualBondSelected= BondSelected_text.getText();
	//	System.out.println(actualBondSelected);
	//	Assert.assertEquals(actualBondSelected, expectedBondSelected);
		
	//	boolean chk_selection= chk_Confirm_Bond_Form.isSelected();
	//	Assert.assertTrue(chk_selection, "Bond form confirm checkbox is not selected ");
		
	//	String verifyBondAmt= chk_Confirm_Bond_Amt.getText();
	//	System.out.println(verifyBondAmt);
	//	Assert.assertEquals(verifyBondAmt,expectedBondAmt);// in excel convert column to sting format
	
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(tab_Approvals));
		tab_Approvals.click();
		System.out.println("Approvals tab is selected");
	
		}
}
