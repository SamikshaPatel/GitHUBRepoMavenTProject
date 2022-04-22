package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SuretyCloud.qa.base.TestBase;

//LPM Tab and Approvals Tab locators are added here

public class ApprovalsTabAddOffer2 extends TestBase {	
	// Initializing the Pageobjects
	
	public ApprovalsTabAddOffer2() {		
		PageFactory.initElements(driver,this);//---this refers to the ApprovalsTab class
	}
	
	//Page Object Locators goes here
	//@FindBy(id="j_id729_lbl") WebElement tab_Approvals;
	@FindBy(xpath="//*[@value='Approvals']") WebElement tab_Approvals;
	@FindBy(xpath="//*[@name='approvalsForm:addApprvl']") WebElement btn_AddApproval;
	
	//All the Add Approval overlay objects goes here
	@FindBy(xpath="//*[@id='approvalsOverlayForm:carrier']") WebElement dd_Carrier;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:wrtUpCo']") WebElement dd_WriteUp;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:agrmnt']") WebElement dd_IndAgrName;
	
	@FindBy(xpath="//*[@id='approvalsOverlayForm:apprBy:1']") WebElement radiobtn_ApprovedByAuthority;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:apprBy:0']") WebElement radiobtn_ApprovedByCarrier;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:rateTypeSel:0']") WebElement radiobtn_RateType_Flat;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:rateTypeSel:1']") WebElement radiobtn_RateType_Sliding;
	
	@FindBy(xpath="//*[@id='approvalsOverlayForm:poaType:0']") WebElement radiobtn_POAType_WetInc;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:poaType:0']") WebElement radiobtn_POAType_Electronic;
	
	@FindBy(xpath="//*[@id='approvalsOverlayForm:indmnType:0']") WebElement radiobtn_IndType_WetInc;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:indmnType:1']") WebElement radiobtn_IndType_Electronic;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:indmnType:2']") WebElement radiobtn_IndType_OnFile;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:indmnType:3']") WebElement radiobtn_IndType_Waive;
	
	@FindBy(xpath="//*[@id='approvalsOverlayForm:advancedOptionsLink']") WebElement link_ShowAdvancedOptions;
	
	@FindBy(xpath="//*[@id='approvalsOverlayForm:advancedOptions']/div[1]/div/input[1]']") WebElement chk_WaiveInd_Corporate;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:advancedOptions']/div[1]/div/input[2]']") WebElement chk_WaiveInd_Personal;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:advancedOptions']/div[1]/div/input[3]']") WebElement chk_WaiveInd_Spouse;

	
	@FindBy(xpath="//*[@id='approvalsOverlayForm:dtEff']") WebElement Cal_Effective_Date;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:dtExp']") WebElement Cal_Expiry_Date;
	@FindBy(xpath="//*[@id='approvalsOverlayForm:vldUntil']") WebElement cal_Valid_Until;


	@FindBy(xpath="//*[@id='approvalsOverlayForm:save']") WebElement btn_Save;

	
	// Methods goes here
	
	public void GotoApprovalsTab () {
			tab_Approvals.click();
	}
		
	public void SelectAddApprovalButton() {
			btn_AddApproval.click();
	}
	
	
	public void SelectCarrier(String sCarrier) {    // Select carrier form the Carrier drop down field
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dd_Carrier)).click();
			dd_Carrier.click();
			Select carrierlist= new Select (dd_Carrier);
			carrierlist.selectByVisibleText(sCarrier);
	}
	
	public void SelectWriteUp(String sWriteUp) {    // Select WriteUp form the Carrier drop down field
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dd_WriteUp)).click();
			dd_WriteUp.click();
			Select WriteUplist= new Select (dd_WriteUp);
			WriteUplist.selectByVisibleText(sWriteUp);
	}
	
	public void EnterEffectiveDate (String sEffectiveDate) { // Enter effective date
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(Cal_Effective_Date)).click();
		Cal_Effective_Date.clear();
		Cal_Effective_Date.sendKeys(sEffectiveDate);
	}
	
	public void EnterExpiryeDate (String sExpiryDate) { // Enter Expiry date
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(Cal_Expiry_Date)).click();
		Cal_Expiry_Date.clear();
		Cal_Expiry_Date.sendKeys(sExpiryDate);
	}
	
	public void SelectRateType(String sRateType) { // Select Approved by Radio button
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(radiobtn_RateType_Flat));
		if(sRateType.equals("Flat")) {
			radiobtn_RateType_Flat.click();			
		}else if(sRateType.equals("Sliding")) {
			radiobtn_RateType_Sliding.click();		
		}
	}		
	public void SelectApprovedBy(String sApprovedBy) { // Select Approved by Radio button
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(radiobtn_ApprovedByAuthority));		
		if(sApprovedBy.equals("Agency Authority")) {
				radiobtn_ApprovedByAuthority.click();			
			}else if(sApprovedBy.equals("Carrier")) {
				radiobtn_ApprovedByCarrier.click();		
			}
	}
	
	public void SelectPOAType(String sPOAType) { // Select POA Type Radio button
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(radiobtn_POAType_WetInc));	
		if(sPOAType.equals("Wet Inc")) {
			radiobtn_POAType_WetInc.click();			
		}else if(sPOAType.equals("Electronic")) {
			radiobtn_POAType_Electronic.click();		
		}
}
	
	public void SelectIndType(String sIndType) { // Select POA Type Radio button
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(radiobtn_IndType_WetInc));
		if(sIndType.equals("Wet Inc")) {
			radiobtn_IndType_WetInc.click();			
		}else if(sIndType.equals("Electronic")) {
			radiobtn_IndType_Electronic.click();		
		}else if(sIndType.equals("On File")) {
			radiobtn_IndType_OnFile.click();
		}else if(sIndType.equals("Waive")) {
			radiobtn_IndType_Waive.click();
		}
}
	public void SelectIndAgrName(String sIndAgrName) {    // Select WriteUp form the Carrier drop down field
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dd_IndAgrName)).click();
		dd_IndAgrName.click();
		Select IndAgrList= new Select (dd_IndAgrName);
		IndAgrList.selectByVisibleText(sIndAgrName);
}
	
	public void SelectShowAdvancedOptionsLink() {  // Select Show Advanced Options link
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(link_ShowAdvancedOptions)).click();
		link_ShowAdvancedOptions.click();
}
	
	
	public void SelectWaiveIndChk(String sWaiveIndChk) { // Select Waive Ind Checkboxes for DocuSign
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(chk_WaiveInd_Corporate)).click();
		if(sWaiveIndChk.equals("Corporate")) {
			boolean display= chk_WaiveInd_Corporate.isDisplayed();
			if (display == true) {
			chk_WaiveInd_Corporate.click();		}	
		}else if(sWaiveIndChk.equals("Personal")) {
			boolean display= chk_WaiveInd_Personal.isDisplayed();
			if (display == true) {
			chk_WaiveInd_Personal.click();	}	
		}else if(sWaiveIndChk.equals("Spouse")) {
			boolean display= chk_WaiveInd_Spouse.isDisplayed();
			if (display == true) {
			chk_WaiveInd_Spouse.click();}
		}
		else if(sWaiveIndChk.equals("CorporatePersonalSpouse")) {
				boolean display1= chk_WaiveInd_Corporate.isDisplayed();
				if (display1 == true) {
				chk_WaiveInd_Corporate.click();		}	
				boolean display2= chk_WaiveInd_Personal.isDisplayed();
				if (display2 == true) {
				chk_WaiveInd_Personal.click();	}
				boolean display3= chk_WaiveInd_Spouse.isDisplayed();
				if (display3 == true) {
				chk_WaiveInd_Spouse.click();}
		}
	}
	

	public void EnterValidUntilDate (String sValidUntilDate) { // Enter Valid Until date
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dd_WriteUp)).click();
		cal_Valid_Until.clear();
		cal_Valid_Until.sendKeys(sValidUntilDate);
	}
	
	public void SelectSaveButton() { // Select Save Button
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dd_WriteUp)).click();
		btn_Save.click();
	}
	

	//TestCaseMain Method goes here
	public void AddOffer(String sTestCaseName, String sCarrier, String sWriteUp, String sEffectiveDate, String sExpiryDate, String sRateType, String sApprovedBy, String sPOAType, String sIndType, String sIndAgrName, String sWaiveIndChk, String sValidUntilDate) {
		
		//SelectCarrier(prop.getProperty("Carrier"));              //Select Carrier
		
		System.out.println("Test Case Being executed = ;" + sTestCaseName);
		
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeSelected(txt_userName));
		
		SelectCarrier (sCarrier);
		System.out.println("Carrier Selected Successfully");
		SelectWriteUp (sWriteUp);
		System.out.println("WriteUp Selected Successfully");
		EnterEffectiveDate (sEffectiveDate);
		System.out.println("EffectiveDate entered Successfully");
		EnterExpiryeDate (sExpiryDate);
		System.out.println("ExpiryDate entered Successfully");
		SelectRateType(sRateType);
		System.out.println("RateType Selected Successfully");
		SelectApprovedBy(sApprovedBy);
		System.out.println("ApprovedBy Selected Successfully");
		SelectPOAType(sPOAType);
		System.out.println("POAType Selected Successfully");
		SelectIndAgrName(sIndAgrName);
		System.out.println("IndAgrName Selected Successfully");
		SelectShowAdvancedOptionsLink();
		System.out.println("ShowAdvancedOptionsLink Selected Successfully");
		SelectWaiveIndChk(sWaiveIndChk);
		System.out.println("WaiveIndChk Selected Successfully");
		EnterValidUntilDate (sValidUntilDate);
		System.out.println("ValidUntilDate Selected Successfully");
		SelectSaveButton();
		System.out.println("Save Button Selected Successfully");
			
	}		

	
}

