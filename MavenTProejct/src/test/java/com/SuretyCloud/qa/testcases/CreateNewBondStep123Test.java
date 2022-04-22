package com.SuretyCloud.qa.testcases;

import com.SuretyCloud.qa.base.TestBase;
import com.SuretyCloud.qa.util.TestUtil;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SuretyCloud.qa.Pages.ClientList;
import com.SuretyCloud.qa.Pages.CommonWeb;
import com.SuretyCloud.qa.Pages.HomePage;
import com.SuretyCloud.qa.Pages.LPMStep1;
import com.SuretyCloud.qa.Pages.LPMStep2;
import com.SuretyCloud.qa.Pages.LoginPage;

public class CreateNewBondStep123Test extends TestBase {
	 LoginPage loginPage;
	 HomePage homePage;
	 //CommonWeb commonWeb;
	 ClientList clientlist;
	 LPMStep1 lpmStep1;
	 LPMStep2 lpmStep2;
	
	public CreateNewBondStep123Test() { // constructor
		super();   //TestBase is the super class here and we inherit by using the Super keyword in this class. Call the super class constructor. You need to do this to avoid null pointer error
	}

	@BeforeMethod //This will be executed before every @test annotated method.
	@BeforeSuite
	public void setup() {
		initialization(); // browser launch
		loginPage = new LoginPage();
		//commonWeb = new CommonWeb();
		homePage = new HomePage();
		clientlist= new ClientList();	
		lpmStep1 = new LPMStep1();
		lpmStep2= new LPMStep2();
	}

	@AfterSuite //A method with this annotation will run once after the execution of all tests in the suite is complete.
	public void Teardown() {
		close_browser();
	}
	
	@DataProvider
	public Iterator<Object[]> getCreateNBDataFromExcel() {
		ArrayList<Object[]> testData = TestUtil.getCreateNBDataFromExcel("CreateNB");
//		getLoginTestDataFromExcel
		return testData.iterator();
	}
	
	//@Test (dataProvider="getCreateNBDataFromExcel")
	@Test (dataProvider= "getCreateNBDataFromExcel")
	public void CreateNewBond (String TestCaseName, String UserName, String Password,
							   String ClientName, String State, String BondForm,String BondFormBeingSearched,String BondAmt)
			                   throws InterruptedException {
		
			homePage= loginPage.login(TestCaseName, UserName, Password);//parameter values will come from DataProvider
			homePage.HP_GoTo_ClientList();
		    clientlist.clientSelection(ClientName);
		    lpmStep1.lpmBRStep1();
			//lpmStep2.fLPMStep2and3(prop.getProperty("sState"), prop.getProperty("sBondForm"), prop.getProperty("sBondFormBeingSearched"), prop.getProperty("sBondAmt"));
			lpmStep2.fLPMStep2and3(State,BondForm,BondFormBeingSearched,BondAmt);
			CommonWeb.logOut();
			close_browser();
	}
		
		//@Test (enabled=false) // (enabled=false) is for skipping test case
	//public void LogOut() {
		//commonWeb.logOut();}
	
}
