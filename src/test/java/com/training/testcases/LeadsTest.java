package com.training.testcases;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.AccountsPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
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
	
	@BeforeTest
	public void beforeTest() throws IOException {
		driver = getDriver();
		prop = new PropertiesFile();
		String url = prop.getProperties("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		screenshot = new ScreenshotUtility();
		accountspage = new AccountsPage(driver);
		leadspage = new LeadsPage(driver);
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
		leadspage.selectLeadsView();
		Log.info("All options are present in view Dropdown");
		Log.endTestCase("TestCase22 is ended.");

	}
	
		
	
	@AfterTest
	public void tearDown() {
		screenshot.takescreenshot(driver);
		close();
		}

}
