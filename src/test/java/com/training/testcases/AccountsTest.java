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
import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotUtility;

public class AccountsTest extends BaseTest{
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	AccountsPage accountspage;
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
	
	@Test(priority = 1)
	public void createAnAccount() throws IOException {
		Log.info("TestCase : 11 - Edit Account");
		
		homepage.accountsTab();
//		Log.info("Account tab is clicked.");
		
		accountspage.newBtn();
//		Log.info("New button is clicked");
		
		accountspage.accountName(prop.getProperties("NewAccountName4"));
//		Log.info("Account name is entered.");
	
		accountspage.selectType(prop.getProperties("TypeofAccountOption7"));
//		Log.info("Technology Partner type is selected");
		
		accountspage.selectPriority(prop.getProperties("customerPriority2"));
//		Log.info("Priority as High is selected");
	
		accountspage.save();
//		Log.info("Accounts Details is saved.");
		
		Log.endTestCase("New Account is created.");
	}
	
	@Test
	public void createNewView() throws IOException {
		Log.info("TestCase : 12 - Create New View Link ");

		homepage.accountsTab();
//		Log.info("Account tab is clicked.");
		
		accountspage.newViewLink();
//		Log.info("New view Link is clicked.");
	
		String viename = prop.getProperties("Viewname");
		accountspage.enterViewName(viename);
//		Log.info("New view name is entered..");
	
		String viewuniquename = prop.getProperties("ViewUniqueName");
		accountspage.enterViewUniqueName(viewuniquename);
//		Log.info("View unique name is entered.");
	
		accountspage.saveNewViewDetails();
//		Log.info("New View details is saved.");
		Log.endTestCase("testcase 12 is ended");
	}
	@Test
	public void	editView() throws IOException, InterruptedException {
		Log.info("TestCase : 13 - Edit Account");

		homepage.accountsTab();
		Log.info("Account tab is clicked.");
		
		String value = prop.getProperties("ViewDropdownOption1Value");
		accountspage.selectView(value);
		Log.info("View name is selected.");
		
		accountspage.editLink();
		Log.info("Edit link is clicked.");
		
		String newname = prop.getProperties("NewViewName");
		accountspage.changeViewName(newname);
		Log.info("New view name is entered.");
		
		String fieldvalue = prop.getProperties("FieldInEditViewPageValue");
		accountspage.selectField(fieldvalue);
		Log.info("value in field is selected.");
		
		String operator = prop.getProperties("OperatorInEditViewPageValue");
		accountspage.selectOperator(operator);
		Log.info("Operator is selected.");
		
		String valueforfilter = prop.getProperties("ValueInEditViewPageValue");		
		accountspage.enterValue(valueforfilter);
		Log.info("Value is entered.");
		
		accountspage.scrolldown();

		String selectfield = prop.getProperties("SelectFieldToDisplayLastActivity");		
		accountspage.selectAvailableField(selectfield);
		Log.info("Last activity is selected");
		
		accountspage.addField();
		Log.info("Last activity is added");
		
		accountspage.saveEditPage();
		Log.info("Edit view page is saved.");
		Log.endTestCase("Testcase 13 is ended");
		Thread.sleep(4000);
	}
	@Test
	public void mergeAccount() throws IOException {
		Log.info("testCase 14 Merge Accounts");
		Log.startTestCase("Merge accounts is started");
		homepage.accountsTab();
//		Log.info("Account tab is clicked.");
		
		accountspage.clickOnMergeAccountLink();
		String existingaccount = prop.getProperties("accountnameForsearchboxinmergeaccounts");
		accountspage.enterIntoSearchAccountTextbox(existingaccount);
		accountspage.clickOnFindAcccountButton();
		accountspage.uncheckOtherCheckBoxes();
		accountspage.clickOnNextBtn();
		accountspage.clickOnMergeAccountBtn();
		accountspage.acceptTheAlert();
		Log.info("Accounts are merged.");
		Log.endTestCase("Merge accounts is ended");
	}

	@Test
	public void createAccountReport() throws IOException, InterruptedException {
		Log.info("Testcase 15 is started");
		Log.startTestCase("create account report test is started.");
		
		homepage.accountsTab();
		Log.info("Account tab is clicked.");
		
		accountspage.clickOnLastActivityLink();
		accountspage.clickOnDateFieldDropDown();
		accountspage.clickOnCreatedDate();
		accountspage.selectDateInFromField();
		accountspage.selectTodayDateInFromField();
		accountspage.selectDateInToField();
		accountspage.selectTodaysDateInToField();
		accountspage.clickOnSaveBtnInCreateReportPage();
		String reportnewname=prop.getProperties("reportnameincreatereportpage");
		accountspage.enterReportNameIntextBox(reportnewname);
		accountspage.enterReportUniqueNameIntextBox();
		accountspage.ClickOnSaveAndRunBtn();
		Thread.sleep(4000);
		Log.info("The Report is Created.");
		Log.endTestCase("Testcase 15 is ended");
	}

	@AfterMethod
	public void tearDown() {
//		screenshot.takescreenshot(driver,testName);
		close();
		}


}
