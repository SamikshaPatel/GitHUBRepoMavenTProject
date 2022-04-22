package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.SuretyCloud.qa.base.TestBase;

public class LPMTab extends TestBase {

	
	// Page Factory- OR
			//--LPM TAB content's Locators ----
			//@FindBy(xpath="//*[@id='j_id79_lbl']") WebElement tab_LPM;   //License &amp; Permit / Misc TAB  ----When SELECTED
			@FindBy(xpath="//*[contains(text(),'License /& Permit // Misc']") WebElement tab_LPM;  //License &amp; Permit / Misc TAB  ----When SELECTED
		
			@FindBy(xpath="//*[@id='lPMiscBondRequestForm:bondInfo']/div[1]/div") WebElement BondSelected_text;  
			@FindBy(xpath="//*[@id='lPMiscBondRequestForm:bondInfo']/div[2]/div/div[1]") WebElement Required_by_text_line1;
			@FindBy(xpath="//*[@id='lPMiscBondRequestForm:bondInfo']/div[2]/div/div[2]") WebElement Required_by_text_line2;
			@FindBy(xpath="//*[@id='lPMiscBondRequestForm:bondInfo']/div[2]/div/div[3]") WebElement Required_by_text_line3;
			@FindBy(xpath="//*[@id='lPMiscBondRequestForm:cnfrmBndFrm']") WebElement chk_Confirm_Bond_Form;  
			@FindBy(xpath="//*[@id='lPMiscBondRequestForm:bndAmt']") WebElement chk_Confirm_Bond_Amt;  
			
		// Initializing the Page objects
		
		public LPMTab() {				
			PageFactory.initElements(driver,this);//---this refers to the LoginPage class
		}
				
		//---------------------------------- ADD FUNCTIONS CODE HERE --------------------------------		
		
		public void select_LPM_Tab() {
			new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElement(tab_LPM, "License /& Permit // Misc"));
			if (!tab_LPM.isSelected()) {				
				tab_LPM.click();
				 try {Thread.sleep(3000);
					} catch (InterruptedException e) {e.printStackTrace();}			 
				System.out.println("LPM tab is selected now");}
			else {
				System.out.println("LPM tab is selected");
				}
		}
		
		public void verifyLPM_TabContent(String sBondSelected,String sRequired_by_line1, String sRequired_by_line2, String sRequired_by_line3, String sBondAmt ) {
				
			select_LPM_Tab();	// Select LPM Tab if not selected already
				
			String actualBondSelected= BondSelected_text.getText();
			System.out.println(actualBondSelected);
			Assert.assertEquals(actualBondSelected, sBondSelected);
			
			String actualRequired_by_line1 = Required_by_text_line1.getText();
			System.out.println(actualRequired_by_line1);
			Assert.assertEquals(actualRequired_by_line1, sRequired_by_line1, "Required By line1 text is not matching");
			
			String actualRequired_by_line2 = Required_by_text_line2.getText();
			System.out.println(actualRequired_by_line2);
			Assert.assertEquals(actualRequired_by_line2, sRequired_by_line2, "Required By line1 text is not matching");
			
			String actualRequired_by_line3 = Required_by_text_line3.getText();
			System.out.println(actualRequired_by_line3);
			Assert.assertEquals(actualRequired_by_line3, sRequired_by_line3, "Required By line1 text is not matching");
			
			boolean chk_selection= chk_Confirm_Bond_Form.isSelected();
			Assert.assertTrue(chk_selection, "Bond form confirm checkbox is not selected ");
			
			String verifyBondAmt= chk_Confirm_Bond_Amt.getText();
			System.out.println(verifyBondAmt);
			Assert.assertEquals(verifyBondAmt,sBondAmt);// in excel convert column to sting format						
			}				
}


