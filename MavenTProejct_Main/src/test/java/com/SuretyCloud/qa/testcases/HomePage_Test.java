package com.SuretyCloud.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SuretyCloud.qa.Pages.ClientList;
import com.SuretyCloud.qa.Pages.HomePage;
import com.SuretyCloud.qa.base.TestBase;

public class HomePage_Test extends TestBase {
	HomePage homepage;
	ClientList clientlist;
	
	public HomePage_Test() {
		super();   //TestBase is the super class here and we inherit by using the Super keyword in this class. Call the super class constructor. You need to do this to avoid null pointer error
	}
	
	@Test (priority=1)
	public void NavigateTo_Clientlist() {
		try {
			homepage.HP_GoTo_ClientList();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String title = clientlist.validateClientListTitle();
		Assert.assertEquals(title,"Client Bond List");
		}
}
