package com.SuretyCloud.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.SuretyCloud.qa.base.TestBase;

public class HomePage extends TestBase {
	// Page Factory- OR
	
		//Using FindBy for locating elements
		// @FindBy(how=How.ID,using="loginForm:emailAddress") WebElement txt_userName;	
		//@FindBy(how=How.XPATH, using="//*[@id=\"loginTable\"]/tbody/tr/td[1]/a/div[1]") WebElement SClogo;
		
			//Homepage Page Title
			@FindBy(xpath="//*[@id='pageHead']/div[3]/div[1]/div") static WebElement HMPage_Title;
			
			//Home page- Menu Tiles
			@FindBy(xpath="//*[@id='bulletinBoard']/a[1]") WebElement Inbox_Tile;
			@FindBy(xpath="//*[@id='bulletinBoard']/a[2]") WebElement MyClients_Tile;
			@FindBy(xpath="//*[@id='bulletinBoard']/a[3]") WebElement MySB_Tile;
			@FindBy(xpath="//*[@id'bulletinBoard']/a[4]") WebElement NewMessage_Tile;
			@FindBy(xpath="//*[@id'bulletinBoard']/a[5]") WebElement MyOrg_Tile;
			@FindBy(xpath="//*[@id'bulletinBoard']/a[6]") WebElement WBInstall_Tile;
			
			//HomePage Main Menu
			@FindBy(xpath="//*[@id='menuForm']//child::td[2]") WebElement MyAccount_MainMenu; 
			@FindBy(xpath="//*[@id='menuForm']//child::td[3]") WebElement MyClients_MainMenu;
			@FindBy(xpath="//*[@id='menuForm']//child::td[4]") WebElement MySB_MainMenu;
			@FindBy(xpath="//*[@id='menuForm']//child::td[5]") WebElement MyOrg_MainMenu;
			
			//HomePage Sub-Menu of MyClients_MainMenu
			@FindBy(xpath="//*[@id='menuForm']//child::td[3]//following::div[4]/span[2]") WebElement Add_Client;
			@FindBy(xpath="//*[@id='menuForm']//child::td[3]//following::div[5]/span[2]") WebElement Client_List;
			@FindBy(xpath="//*[@id='menuForm']//child::td[3]//following::div[5]/span[2]") WebElement ActiveBond_Mgt;
			@FindBy(xpath="//*[@id='menuForm']//child::td[3]//following::div[5]/span[2]") WebElement Lead_List;
			
			
			
			// Initializing the Pageobjects
					
			public HomePage() {
				
				PageFactory.initElements(driver,this);//---this refers to the HomePage class
			}
			
			// Defining all the user actions (Methods) that can be performed in the Home Page
			
			// Go to the respective Pages using HomePage Tile's click
			
			public void GoTo_ClientList_via_Tile () {  //This method will navigate to: HomePage>MyClients_MainMenu>Client_List	
				MyClients_Tile.click();
			}
			
			
			//My Clients Sub-menu click
			
			public ClientList HP_GoTo_ClientList () throws InterruptedException { //This method will navigate to: HomePage>MyClients_MainMenu>Client_List				
				Actions builder = new Actions(driver);
				builder.moveToElement(MyClients_MainMenu).build().perform();
				Thread.sleep(8000);
				builder.moveToElement(Client_List).click().build().perform();
				//Thread.sleep(8000);
				// new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(txt_userName)).click();
			
				new WebDriverWait(driver, 20).until(ExpectedConditions.textToBePresentInElement(ClientList.ClientListPagetitle, "Client List"));
				
				System.out.println("Landed On Client List page");		
				String Cltitle = CommonWeb.validatePageTitle();
				Assert.assertEquals(Cltitle,"Client List","Page title is not matching");			
				return new ClientList(); // This method is returning ClientList class object	
				
			}
		
			public void HP_GoTo_Add_Client () { //This method will navigate to: HomePage>MyClients_MainMenu>Add Client
				
				Actions builder = new Actions(driver);
				builder.moveToElement(MyClients_MainMenu).build().perform();
				builder.moveToElement(Add_Client).click().build().perform();										
			}
			public void HP_GoTo_ActiveBond_Mgt () { //This method will navigate to: HomePage>MyClients_MainMenu>ActiveBond_Mgt
				
				Actions builder = new Actions(driver);
				builder.moveToElement(MyClients_MainMenu).build().perform();
				builder.moveToElement(ActiveBond_Mgt).click().build().perform();										
			}
			public void HP_GoTo_Lead_List () { //This method will navigate to: HomePage>MyClients_MainMenu>Lead List
				
				Actions builder = new Actions(driver);
				builder.moveToElement(MyClients_MainMenu).build().perform();
				builder.moveToElement(Lead_List).click().build().perform();										
			}
		
			
}


