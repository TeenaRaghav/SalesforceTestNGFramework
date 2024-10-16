package com.training.testcases;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.AccountsPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotUtility;

public class LeadsTest extends BaseTest{
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	AccountsPage accountspage;
	LeadsPage leadspage;
	UserMenuPage usermenupage;
	LoginTest logintest;
	String testName;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		prop = new PropertiesFile();
		String url = prop.getProperties("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		screenshot = new ScreenshotUtility();
		accountspage = new AccountsPage(driver);
		leadspage = new LeadsPage(driver);
		usermenupage = new UserMenuPage(driver);
		logintest  = new LoginTest();
		DOMConfigurator.configure("log4j.xml");
		
//		login
		Log.info("Login TestCase");
		
		String uname = prop.getProperties("username");
		loginpage.enterIntoUsername(uname);
//		Log.info("Successfully entered the username");
		
		String psswrd = prop.getProperties("password");
		loginpage.enterIntoPassword(psswrd);
//		Log.info("Successfully entered the password");
		
		loginpage.clickLogin();
//		Log.info("Login successful.");
	}
	
	@Test
	public void leadsTab() {
		Log.info("TestCase 21 check leads Tab link");
		Log.startTestCase("Test is started");
		leadspage.clickOnLeadsTab();
		Log.info("Leads tab is clicked successfully");
		Log.endTestCase("TestCase is ended.");

	}
	
	@Test
	public void ViewDropdownListContents() {
		Log.info("TestCase 22 validate view dropdown list ");
		Log.startTestCase("Test is started");
		leadspage.clickOnLeadsTab();
		Log.info("Leads tab is clicked successfully");
		leadspage.clickOnLeadsView();
		Log.info("All options are present in view Dropdown");
		Log.endTestCase("TestCase22 is ended.");

	}
	@Test
	public void SelectViewFromDropdownInLeads() throws IOException, InterruptedException {
		Log.info("TestCase 23 select view from dropdown in Leads page ");
		Log.startTestCase("Test is started");
		leadspage.clickOnLeadsTab();
		Log.info("Leads tab is clicked successfully");
		String viewOption = prop.getProperties("viewOptioninLeads");
		leadspage.selectLeadsView(viewOption);
		Log.info("Today's lead is selected");
		usermenupage.usermenu();
		Log.info("UserMenu is clicked successfully.");
		homepage.logout();
		Log.info("Logout Succesfully");
		String uname = prop.getProperties("username");
		loginpage.enterIntoUsername(uname);
		String passwrd = prop.getProperties("password");	
		loginpage.enterIntoPassword(passwrd);
		loginpage.clickLogin();
		leadspage.clickOnLeadsTab();
		Log.info("Leads tab is clicked successfully");
		leadspage.ClickOnGoBtn();
		Thread.sleep(4000);
		Log.info("Go button is clicked successfully");
		Log.endTestCase("TestCase23 is ended.");
	}
	
	@Test	
	public void validateTodaysLeadPageIsDisplayed() throws IOException {
			Log.info("TestCase 24 select view from dropdown in Leads page ");
			Log.startTestCase("Test is started");
			leadspage.clickOnLeadsTab();
			Log.info("Leads tab is clicked successfully");
			String viewOption = prop.getProperties("viewOptioninLeads");
			leadspage.selectLeadsView(viewOption);
			Log.info("Today's lead is selected");
			leadspage.checkFirstSelectedOption();
			Log.info("Today's lead is diplayed");
			Log.endTestCase("TestCase24 is ended.");
		}
		@Test
		public void createNewLead() throws IOException {
			Log.info("TestCase 25 check new button on leads home ");
			Log.startTestCase("Test is started");
			leadspage.clickOnLeadsTab();
			Log.info("Leads tab is clicked successfully");
			leadspage.newBtnOnLeadsPage();
			Log.info("New button is clicked successfully");
			String lastname = prop.getProperties("LastNameInNewView");
			leadspage.EnterLastNameOnLeadsPage(lastname);
			Log.info("Lastname is entered successfully");
			String Compname = prop.getProperties("CompanyNameInNewView");
			leadspage.EnterCompanyNameOnLeadsPage(Compname);
			Log.info("Company name is entered successfully");
			leadspage.ClickOnSaveButton();
			Log.info("New View is created successfully");
			Log.endTestCase("TestCase 25 is ended successfully");

		}
	
	@AfterMethod
	public void tearDown() {
//		screenshot.takescreenshot(driver,testName);
		quit();
		}

}
