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
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotUtility;

public class ContactsTest extends BaseTest {
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	AccountsPage accountspage;
	LeadsPage leadspage;
	UserMenuPage usermenupage;
	ContactsPage contactspage;

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
		usermenupage = new UserMenuPage(driver);
		contactspage = new ContactsPage(driver);
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
	public void createNewContacts() throws IOException {
		Log.info("TestCase26 create new Contacts");
		Log.startTestCase("Test is started");
		contactspage.contactsTab();
		Log.info("Contacts tab is clicked");
		contactspage.clickOnNewBtn();
		Log.info("New button is clicked");
		String lastname = prop.getProperties("lastNameInContactsTab");
		contactspage.enterLastName(lastname);
		Log.info("LastName is entered successfully");
		contactspage.clickOnLookUpIcon();
		Log.info("lookup icon is clicked successfully");
		contactspage.switchToWindowAndSelectAccountName();
		Log.info("Account name is selected from lookup icon window successfully");
		contactspage.clickOnSaveBtn();
		Log.info("New Contacts is created.");
		Log.endTestCase("TestCase 26 is ended");
	}

	@Test
	public void createNewView() throws IOException {
		Log.info("TestCase27 create new Contacts");
		Log.startTestCase("Test is started");
		contactspage.contactsTab();
		Log.info("Contacts tab is clicked");
		contactspage.clickOnNewViewLink();
		Log.info("New View Link is clicked successfully");
		String newViewname = prop.getProperties("newViewNameIncontacts");
		contactspage.enterNewViewName(newViewname);
		Log.info("New View Name is entered successfully");
		String newViewuniquename = prop.getProperties("newViewUniqueNameInContacts");
		contactspage.enterNewViewUniqueName(newViewuniquename);
		Log.info("New View Unique Name is entered successfully");
		contactspage.clickOnSaveBtninContacts();
		Log.info("New View in contacts is created successfully");
		Log.endTestCase("TestCase 17 is ended successfully");
	}

	@Test
	public void filterView() throws IOException {
		Log.info("TestCase27 create new Contacts");
		Log.startTestCase("Test is started");
		contactspage.contactsTab();
		Log.info("Contacts tab is clicked");
		String value = prop.getProperties("filterViewOption");
		contactspage.selectFilter(value);
		Log.info("Recent created contacts are displayed.");
		Log.endTestCase("TestCase28 is ended");
	}

	@AfterTest
	public void tearDown() {
		screenshot.takescreenshot(driver);
		close();
	}

}
