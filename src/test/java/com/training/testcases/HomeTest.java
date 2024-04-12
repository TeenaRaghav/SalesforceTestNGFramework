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
		Log.info("TestCase 35 customize my tab");
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
	@AfterTest
	public void tearDown() {
		screenshot.takescreenshot(driver);
		close();
		}

}
