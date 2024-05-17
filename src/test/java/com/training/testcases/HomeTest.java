package com.training.testcases;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotUtility;

public class HomeTest extends BaseTest{
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	UserMenuPage usermenupage;
	@BeforeTest
	public void beforeTest() throws IOException {
		driver = getDriver();
		prop = new PropertiesFile();
		String url = prop.getProperties("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		screenshot = new ScreenshotUtility();
		usermenupage =  new UserMenuPage(driver);
		DOMConfigurator.configure("log4j.xml");
//		login
		Log.info(" Enter valid username and valid password");
		String uname = prop.getProperties("username");
		loginpage.enterIntoUsername(uname);
		Log.info("Successfully entered the username ");
		
		String psswrd = prop.getProperties("password");
		loginpage.enterIntoPassword(psswrd);
		Log.info("Successfully entered the password " );
		
		loginpage.clickLogin();
		Log.info("Login successful.");

	}
	@Test
	public void customizeMyTab() {
		Log.info("TestCase 36 customize my tab");
		Log.startTestCase("Test is started");
		homepage.clickOnPlusBtn();
		Log.info("+ button is clicked successfully");
		homepage.clickOnCustomizeMyTabBtn();
		Log.info("button is clicked successfully");
		homepage.selectatbFromselectedarea();
		Log.info("Leads Tab is selected successfully");
		homepage.clickOnRemovebtn();
		Log.info("Leads Tab is remover successfully.");
		homepage.clickOnsavebtn();
		Log.info("Change is updated");
		Log.endTestCase("Testcase 36 is ended successfully");
	}
	@Test
	public void blockingAnEventInTheCalendar() {
		Log.info("TestCase 37 Blocking an event in the calendar");
		Log.startTestCase("Test is started");
		homepage.homeTab();
		Log.info("Home Tab is clicked Successfully");
		homepage.currentDateDisplayAndClicked();
		Log.info("Current date is displayed and clicked successfully");
		homepage.eightPmLink();
		Log.info("Eightpm linke is clicke successfully");
		homepage.subjectComboIcon();
		Log.info("Subject combo icon is clicked successfully");
		homepage.clickOnOther();
		Log.info("Successfully clicked on other and switched the window");
		homepage.clickOnEndTimeField();
		Log.info("Successfully clicked on end tme field");
		homepage.clickOnNinePmFromDropDown();
		Log.info("Successfully clicked on Nine pm form the dropdown");
		homepage.clickOnSaveBtn1();
		Log.info("Successfullly clicked on save button");
		Log.endTestCase("TestCase37 is ended successfully");
	}
	
	@Test
	public void blockingAnEventInTheCalendarWithWeeklyRecurrence() {
		Log.info("TestCase 38 Blocking an event in the calendar with weekly recurrence");
		Log.startTestCase("Test is started");
		homepage.homeTab();
		Log.info("Home Tab is clicked Successfully");
		homepage.currentDateDisplayAndClicked();
		Log.info("Current date is displayed and clicked successfully");
		homepage.fourPmLink();
		Log.info("fourpm link is clicked successfully");
		homepage.subjectComboIcon();
		Log.info("Subject combo icon is clicked successfully");
		homepage.clickOnOther();
		Log.info("Successfully clicked on other and switched the window");
		homepage.clickOnEndTimeField();
		Log.info("Successfully clicked on end tme field");
		homepage.clickOnSevenPmFromDropDown();
		Log.info("Successfully clicked on Nine pm form the dropdown");
		homepage.chrckRecurrenceField();
		Log.info("recurrence is clicked succesfully");
		homepage.selectFrequency();
		Log.info("Frequency is selected succesfully");
		homepage.selectEndDate();
		Log.info("End date is selected succesfully");
		homepage.selectDateof2weeksFromCurrentDate();
		Log.info("Date is selected From calendar of 2 weeks from current date");
		homepage.clickOnSaveBtn1();
		Log.info("Successfullly clicked on save button");
		Log.endTestCase("TestCase38 is ended successfully");
	}

	@AfterTest
	public void tearDown() {
		screenshot.takescreenshot(driver);
		close();
		}

}
