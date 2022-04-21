package com.SuretyCloud.qa.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.SuretyCloud.qa.Pages.CommonWeb;

import com.SuretyCloud.qa.base.TestBase;

public class LPMStep2 extends TestBase { // This method covers Bond Form (Step 2) and Bond Quote (Step 3) button click
	
	//CommonWeb commonWeb = new CommonWeb();
	
	// Initializing the Page objects
	
			public LPMStep2() {				
				PageFactory.initElements(driver,this);//---this refers to the LoginPage class
			}
			
			
	//private String sState ="";
	
	//Step2 Objects	
		@FindBy(id="lPMiscBondRequestForm:stateBond") WebElement lst_BondState1;
		@FindBy(id="lPMiscBondRequestForm:search") WebElement txt_BndFormSearch;
		@FindBy(xpath="//*[@id='lPMiscBondRequestForm:searchBondTable']/tbody") WebElement tbl_htmltable;
		
		//public WebElement lst_BondStateSelect (WebElement lst_BondState1, String sState) {
		//	WebElement element= lst_BondState1.findElement(By.xpath("//option[. = '" + sState + "']"));
		//return element; }
		
		
		public List<WebElement> tbl_htmltableRows (WebElement tbl_htmltable) {
			List<WebElement> rows = tbl_htmltable.findElements(By.tagName("tr"));
		return rows;}
		
		//public List<WebElement> tbl_htmltableData(WebElement row) {
		//	List<WebElement> columns= (List<WebElement>) row.findElement(By.tagName("td"));
		//return columns;	}
		
		//public WebElement jsExecutor(WebDriver driver, WebElement element) {
		//	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		//	jse2.executeScript("arguments[0].scrollIntoView()", element);
		//	return element; 
	//	}
		
		public WebElement btn_selectBond(int rnum) {
			WebElement element=driver.findElement(By.xpath("//*[@id=\"lPMiscBondRequestForm:searchBondTable\"]/tbody/tr["+(rnum+1)+"]/td[5]/input"));
		return element;}
		
		@FindBy(id="lPMiscBondRequestForm:cnfrmBndFrm") WebElement chk_Checkbox;		
		@FindBy(id= "lPMiscBondRequestForm:bndAmt") WebElement txt_BondAmt;
		@FindBy(id= "lPMiscBondRequestForm:cont") WebElement btn_Continue;
		@FindBy(id= "supportingDocumentsForm:qualify") WebElement btn_QualifyBasedOnInfoProvided;
		//---------------------------------- ADD FUNCTIONS CODE HERE --------------------------------		
		
		public void fSelectState (String sState) {				
			System.out.println("Landed on Create New Bond- Process Bar Step 2");
			lst_BondState1.click();	
			Select stateSel= new Select (lst_BondState1);
			stateSel.selectByVisibleText(sState);			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		public void fEnterBondFormName (String sBondForm) {
			txt_BndFormSearch.sendKeys(sBondForm);		
			//driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
			  try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		public void fClickSelectBondButton (String sBondFormBeingSearched) {
		
			List<WebElement> rows= tbl_htmltableRows(tbl_htmltable);
						
			for(int rnum=0; rnum<rows.size(); rnum++)
			{
				List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
				
				System.out.println("Number of columns:"+columns.size());
				int cnum=0;
				//String BondFormBeingSearched = "Franchise Bond";  //for Illinois state
//				String BondFormBeingSearched = "Motor Vehicle Dealer Bond (Hauling)";
				String celltext =columns.get(cnum).getText();			
		    	System.out.println("Cell Value Of row number " + rnum+ " and column number 1 is " + celltext);
		    		
		    	if (celltext.startsWith(sBondFormBeingSearched)) {
					 // 23 | click | id=lPMiscBondRequestForm:cnfrmBndFrm |  | 
		    		//driver.findElement().click();
		    		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    		WebElement selectBondButton = btn_selectBond(rnum);
		    		
		    		try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    				    		
		    		selectBondButton= CommonWeb.scrollUntilElementVisible (selectBondButton);
		    		
		    		//selectBondButton =jsExecutor(driver, selectBondButton);
		    		selectBondButton.click();
		    		break;
		    	 } 	
			}
		}	
		public void fSelectConfirmCheckbox () {
			//WebElement chk_Checkbox = chk_Checkbox(driver);
			boolean checkboxValue= chk_Checkbox.isSelected();	
			System.out.println("Checkbox Selcted=" +checkboxValue);
			
			Actions actions = new Actions(driver);
			actions.moveToElement(chk_Checkbox).click().build().perform();
		}
		
		
		public void fEnterBondAmt (String sBondAmt) {	
			txt_BondAmt.sendKeys(sBondAmt);	
		}

		public void fClickContinueButton () {
		      	//Scroll down the page
			    //JavascriptExecutor js = (JavascriptExecutor) driver;
			    //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			    
			    CommonWeb.scrollDown();
			    
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		  
				btn_Continue.click();
			}  
		
		public void fClickQualifyBasedOnInfoProvided () {  //this method is for clicking 'Qualify based on Info provided' button
			System.out.println("Landed on Create New Bond- Process Bar Step 3");
			String pagetitle = CommonWeb.validatePageTitle();
			Assert.assertEquals(pagetitle,"Request Quote"); // validate page title on page landing
						
			btn_QualifyBasedOnInfoProvided.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		  
			
		}
		
		public LPMTab fLPMStep2and3(String sState, String sBondForm, String sBondFormBeingSearched, String sBondAmt) {
			  fSelectState(sState);
			  fEnterBondFormName(sBondForm);
			  fClickSelectBondButton(sBondFormBeingSearched);
			  fSelectConfirmCheckbox();
			  fEnterBondAmt(sBondAmt);
			  fClickContinueButton();
			  fClickQualifyBasedOnInfoProvided();
			  return new LPMTab();
		}
				

}
