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
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotUtility;

public class OpportunityTest extends BaseTest{
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	AccountsPage accountspage;
	OpportunityPage opportunitypage;
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
		opportunitypage = new OpportunityPage(driver);
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

	@Test(enabled = false)
	public void opportunitiesDropdownTest() throws InterruptedException {
		Log.info("TestCase 16 opportunity ");
		Log.startTestCase("opportunity dropdown testcase started");
		opportunitypage.opportunityTab();
		opportunitypage.opportunityTabDropdwn();
		Log.info("opportunity tab dropdown is clicked.");
		Thread.sleep(4000);
	}
	@Test
	public void createNewOpportunity() throws IOException {
		Log.info("TestCase 17 create new Opportunity");
		Log.startTestCase("test is started");
		opportunitypage.opportunityTab();
		Log.info("opportunity button is clicked");
		opportunitypage.newOpportunity();
		String oppName= prop.getProperties("opportunityName");
		opportunitypage.opportunityName(oppName);
		String oppAccountname = prop.getProperties("opportunityAccountName");
		opportunitypage.opportunityAccountName(oppAccountname);
		opportunitypage.oppCloseDate();
		String stagevalue = prop.getProperties("opportunityStagevalue");
		opportunitypage.oppSelectStage(stagevalue);
		opportunitypage.oppProbability();
		String leadsourcevalue =prop.getProperties("opportunityLeadSourcevalue");
		opportunitypage.oppSelectLeadSource(leadsourcevalue);
		opportunitypage.primaryCampaignSourcebtn();
		opportunitypage.switchTowindowAndSelectCampaignSource();
		Log.info("switch to campaign window");
		Log.info("back to main window");
		opportunitypage.opportunitySaveButton();
		Log.info("New Opportunity is Created");
		Log.endTestCase("TestCase 17 is ended");
	}
	@Test
	public void opportunityPipelineLink() {
		Log.info("TestCase 18 opportunity pipeline link");
		Log.startTestCase("Test is started");
		opportunitypage.opportunityTab();
		Log.info("opportunity button is clicked");
		opportunitypage.opportunityPipeLine();
		Log.info("opportunity pipeline link is clicked successfully");
		opportunitypage.validatingopportunitypipelinePageIsDisplyed();
		Log.info("opportunity piprlinr link is displayed");
		Log.endTestCase("TestCase18 is ended.");

	}
	@Test
	public void stuckOpportunityLink() {
		Log.info("TestCase 19 Stuck opportunity link");
		Log.startTestCase("Test is started");
		opportunitypage.opportunityTab();
		Log.info("opportunity button is clicked");
		opportunitypage.stuckOpportunityLink();
		Log.info("Stuck opportunity link is clicked successfully");
		opportunitypage.validatingstuckOpportunityPageIsDisplyed();
		Log.info("Stuck opportunity page is displayed.");
		Log.endTestCase("TestCase19 is ended.");

	}
	@Test
	public void quarterlySummary() throws IOException {
		Log.info("TestCase 20 Test Quaterly summary");
		Log.startTestCase("Test is Started");
		opportunitypage.opportunityTab();
		String intervaloption = prop.getProperties("intervalDropdownvalue1"); 
		opportunitypage.selectInterval(intervaloption);
		Log.info("Current and Next FQ is selected.");
		String includeoption = prop.getProperties("intervalDropdownvalue1"); 
		opportunitypage.selectInclude(includeoption);
		Log.info("Open Opportunities");
		opportunitypage.clickOnRunAndReport();
		Log.info("run and report button is clicked successfully");
		Log.endTestCase("TestCase 20 is ended successfully.");
		
	}
	
	@AfterMethod
	public void tearDown() {
//		screenshot.takescreenshot(driver,testName);
		close();
		}

}
