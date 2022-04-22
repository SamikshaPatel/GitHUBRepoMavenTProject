package com.SuretyCloud.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.SuretyCloud.qa.Pages.ClientList;
import com.SuretyCloud.qa.Pages.CommonWeb;
import com.SuretyCloud.qa.Pages.HomePage;
import com.SuretyCloud.qa.Pages.LoginPage;
import com.SuretyCloud.qa.base.TestBase;
import com.SuretyCloud.qa.util.TestUtil;
import com.SuretyCloud.qa.util.TestUtil2;

/*
@BeforeSuite: It will run only once, before all tests in the suite are executed.
@BeforeTest: This will be executed before the first @Test annotated method. It can be executed multiple times before the test case.
@BeforeClass: This will be executed before first @Test method execution. It will be executed one only time throughout the test case.
	@BeforeMethod: This will be executed before every @test annotated method.
		@Test
	@AfterMethod: This will be executed after every @test annotated method.

	@BeforeMethod: This will be executed before every @test annotated method.
		@Test
	@AfterMethod: This will be executed after every @test annotated method.

@AfterClass: This will be executed after all test methods in the current class have been run
@AfterTest: A method with this annotation will be executed when all @Test annotated methods complete the execution of those classes inside the <test> tag in the TestNG.xml file.
@AfterSuite: A method with this annotation will run once after the execution of all tests in the suite is complete.

@BeforeGroups: This method will run before the first test run of that specific group.
@AfterGroups: This method will run after all test methods of that group complete their execution. */

public class LoginPage_Test extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
//	CommonWeb commonWeb;
	ClientList clientlist;
	
	public LoginPage_Test() { //constructor
		super();   //TestBase is the super class here and we inherit by using the Super keyword in this class. Call the super class constructor. You need to do this to avoid null pointer error
	}
		
	@BeforeMethod //This will be executed before every @test annotated method.
	@BeforeSuite
	public void setup() {
		initialization(); // browser launch
		loginPage = new LoginPage();
//		commonWeb = new CommonWeb();
		homePage = new HomePage();
		clientlist= new ClientList();	
	}

	//@AfterSuite //A method with this annotation will run once after the execution of all tests in the suite is complete.
	//@AfterMethod
	public void Teardown() {
		//driver.close();
		driver.quit();
	}
	
	//@AfterClass // This will be executed after all test methods in the current class have been run
	//public void Teardown() { // if we use Teardown method in Afte
		//driver.close();
	//	driver.quit();
	//}
	
	@DataProvider	
		//public Iterator<Object[]> getLoginTestDataFromExcel() {
		//	ArrayList<Object[]> testData = TestUtil.getLoginTestDataFromExcel("Login");
		//	return testData.iterator();
	//}
	public Object[][] getLoginData() {
	Object data [][]= TestUtil2.getTestData("Login");	
	return data;
	}
	
	@Test  (enabled=false) //is for skipping test case
	public void loginPageTitleTest() {
		String title = CommonWeb.validatePageTitle();
		Assert.assertEquals(title,"Login"); //before login, validate page title
		}
	@Test  (enabled=false)// is for skipping test case
	public void SCLogoTest() {
		boolean flag = loginPage.validateSClogo();
		Assert.assertTrue(flag);
		}
		
	//@Test (dataProvider= "getLoginData", priority=1)
	//@Test (dataProvider= "getLoginDataFromExcel", priority=1)
	
	//@Test (dataProvider= "getLoginTestDataFromExcel", priority=1)
	@Test (dataProvider= "getLoginData")
	//public void loginTest (String UserName, String Password) throws InterruptedException {	
	public void loginTest (String TestCaseName, String UserName, String Password) throws InterruptedException {		
		String beforetitle = CommonWeb.validatePageTitle();
		Assert.assertEquals(beforetitle,"Login"); //before login, validate page title
		
		boolean flag = loginPage.validateSClogo();
		Assert.assertTrue(flag);
		
		//homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	
		homePage= loginPage.login(TestCaseName, UserName, Password);//parameter values will come from DataProvider
		// 	Print the name of the test case as well
		
		String Homepagetitle = CommonWeb.validatePageTitle();
		Assert.assertEquals(Homepagetitle,"Home"); //after successful login, validate page title
		
		//homePage.GoTo_ClientList_via_Tile();
				homePage.HP_GoTo_ClientList();
				
				String Cltitle = clientlist.validateClientListTitle();
				Assert.assertEquals(Cltitle,"Client List");						
				CommonWeb.logOut();
				driver.close();	
	}	
		
		
	@Test (enabled=false)  //is for skipping test case
	public void LogOut() {
		CommonWeb.logOut();
		}
	
	}
		
