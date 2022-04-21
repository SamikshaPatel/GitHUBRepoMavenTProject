package com.SuretyCloud.qa.testcases;

import com.SuretyCloud.qa.base.TestBase;
import com.SuretyCloud.qa.util.TestUtil;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SuretyCloud.qa.Pages.ClientList;
import com.SuretyCloud.qa.Pages.CommonWeb;
import com.SuretyCloud.qa.Pages.HomePage;
import com.SuretyCloud.qa.Pages.LPMStep1;
import com.SuretyCloud.qa.Pages.LPMStep2;
import com.SuretyCloud.qa.Pages.LPMTab;
import com.SuretyCloud.qa.Pages.LoginPage;

public class CreateNBOffer_Test extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//CommonWeb commonWeb;
	ClientList clientlist;
	LPMStep1 lpmStep1;
	LPMStep2 lpmStep2;
	LPMTab lpmtab;
	
	public CreateNBOffer_Test() { // constructor
		super();   //TestBase is the super class here and we inherit by using the Super keyword in this class. Call the super class constructor. You need to do this to avoid null pointer error
	}

	@BeforeMethod //This will be executed before every @test annotated method.
	public void setup() {
		initialization(); // browser launch
		loginPage = new LoginPage();
		//commonWeb = new CommonWeb();
		homePage = new HomePage();
		clientlist= new ClientList();	
		lpmStep1 = new LPMStep1();
		lpmStep2= new LPMStep2();
		lpmtab = new LPMTab();
	}

	@AfterSuite //A method with this annotation will run once after the execution of all tests in the suite is complete.
	public void Teardown() {
		driver.quit();
	}
	
	@DataProvider
	public Iterator<Object[]> getCreateNBDataFromExcel() {
		ArrayList<Object[]> testData = TestUtil.getCreateNBDataFromExcel("CreateNB");
		return testData.iterator();
	}
	
	@Test (dataProvider= "getCreateNBDataFromExcel", priority=1)
	public void CreateNewBond (
			String TestCaseName, String UserName, String Password,
			String ClientName, String State, String BondForm,String BondFormBeingSearched,String BondAmt,
			String BondSelected,String RequiredByLine1, String RequiredByLine2, String RequiredByLine3, String ConfirmBondAmt)
			throws InterruptedException {
			
		//-------------------------------Create New Bond Steps 1 to 3--------------------------------------//
			homePage= loginPage.login(TestCaseName, UserName, Password);//parameter values will come from DataProvider
			homePage.HP_GoTo_ClientList();
		    clientlist.clientSelection(ClientName);
		    lpmStep1.lpmBRStep1();
		
		//lpmStep2.fLPMStep2and3(prop.getProperty("sState"), prop.getProperty("sBondForm"), prop.getProperty("sBondFormBeingSearched"), prop.getProperty("sBondAmt"));
			lpmStep2.fLPMStep2and3(State,BondForm,BondFormBeingSearched,BondAmt);
		
		//------------------------------------LPM Tab verification-------------------------------------------//
			lpmtab.verifyLPM_TabContent(BondSelected,RequiredByLine1,RequiredByLine2,RequiredByLine3,ConfirmBondAmt);
		
		//------------------------------------NB Offer Creation-------------------------------------------//
			
			
		//------------------------------------Log Out and Closing Browser-------------------------------------------//
			CommonWeb.logOut();
			close_browser();
	}
		
		//@Test (enabled=false) // (enabled=false) is for skipping test case
	//public void LogOut() {
		//commonWeb.logOut();}
	
}
