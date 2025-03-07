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
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotUtility;


public class UserMenuTest extends BaseTest{
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	UserMenuPage usermenupage;
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
	public void checkTheOptionsInUserMenu() throws IOException {		
		Log.info(" TestCase 6 user menu dropdown started");
		usermenupage.usermenu();
		Log.info("Successfully clicked on usermenudropdown");
		Log.endTestCase(" :UserMenuDropDown test ended");
	}
	
	@Test
	public void editProfile() throws IOException {
	Log.info("TestCase 7 Edit my profile started");
	usermenupage.usermenu();
	Log.info("Successfully clicked on usermenudropdown");
	Log.startTestCase(" :UserMenuDropDown test started");
	
//	1.Edit lastname
	Log.startTestCase("MY profile settings tectcase started");	
	usermenupage.myProfile();
	Log.info("MyProfile is clicked.");
	usermenupage.editBtn();
	Log.info("Edit Button next to contact is clicked.");
	usermenupage.abtFrame();
	Log.info("Successfully switched to frame.");
	usermenupage.aboutTab();
	Log.info("About tab is clicked.");
	String lastname = prop.getProperties("Lastname");
	usermenupage.enterIntoLastname(lastname);
	Log.info("Lastname is entered successfully.");
	usermenupage.clickSaveall();
	Log.info("Save All button is clicked.");
	usermenupage.switchToDefaultFrame();
	Log.info("Successfully switched to default frame.");
	Log.endTestCase(" :UserMenuDropDown test ended");

//	2.post
	
	homepage.post();
	homepage.textFrame();
	String text = prop.getProperties("Post");
	homepage.enterInToTextbox(text);
	homepage.postFrame();
	homepage.sharePost();
	Log.info("Posted Successfully");
	
//	3. file upload
	homepage.file();
	homepage.uploadFromComputer();
	String pathoffile = prop.getProperties("filepath");
	homepage.chooseFile(pathoffile);
	homepage.shareFile();
	Log.info("File is shared successfully.");

//	4. upload image
	homepage.addPhoto();
	homepage.clickAddPhotoLink();
	homepage.addFrame();
	String photopath = prop.getProperties("photopath");
	homepage.choosePhoto(photopath);
	homepage.clickOnChoosePhotoBtn();
	homepage.savePhoto();
	Log.info("Photo is uploaded successfully.");
	
	Log.endTestCase("Test case ended");
	}
	@Test
	public void mySettingsUsermenu() throws IOException, InterruptedException {
		Log.info("TestCase 8 Edit my Setings started");
		usermenupage.usermenu();
		Log.info("Usermenu dropdown is clicked.");
		
		usermenupage.mySettings();
		usermenupage.personalInfo();
		usermenupage.loginhistorybtn();
		usermenupage.loginhistorylink();
//		2. display and layout
		usermenupage.displayAndLayout();
		usermenupage.customizeMyTab();
		String value = prop.getProperties("valueformysettingscustomappdropdown");
		usermenupage.customappdropdown(value);
		Log.info("salesforce chatter is selected");
		String tabvalue = prop.getProperties("valueforavailabaletabsdropdown");
		usermenupage.availabletabs(tabvalue);
		usermenupage.reportTab();
		usermenupage.saveTheChange();
		Log.info("Report tab is added.");
		
//	3. email
		usermenupage.usermenu();
		Log.info("Usermenu dropdown is clicked.");
		
		usermenupage.mySettings();
		usermenupage.emailTab();
		usermenupage.myEmailSettings();
		String name = prop.getProperties("emailnameinmysettings");
		usermenupage.enterEmailName(name);
		String address = prop.getProperties("emailaddressinmysettings");
		usermenupage.enterEmailAddress(address);
		usermenupage.yesbtn();
		usermenupage.saveBtnInEmailSettings();
		usermenupage.acceptTheAlert();
		Log.info("Alert is Accepted");
		
//		4. calendars and reminders
		usermenupage.clickOncalendarsAndReminders();
		usermenupage.clickOnActivityReminder();
		usermenupage.clickOnTestReminder();
		Log.info("Test reminder button is clicked.");
		Thread.sleep(2000);
	}
	@Test
	public void developerConsole() throws IOException {
		Log.info("Test CAse : 9  - Devloper Console");
		usermenupage.usermenu();
		Log.info("Usermenu dropdown is clicked.");
	
		homepage.developerConsole();
		Log.info("Developer Console is clicked and window is opened.");
		Log.endTestCase(" :Developer Console Window test ended");

	}
	

	@Test
	public void logout() throws IOException, InterruptedException {
		Log.info("TestCase 10 logout");
		usermenupage.usermenu();
		Log.info("Usermenu dropdown is clicked.");
		
		homepage.logout();
		Thread.sleep(4000);
		Log.info("Logged out successfully");
		Log.endTestCase("usermanu dropdown test ended");
	}

	@Test
	public void verifyFirstAndLastName() throws IOException {
		Log.info("TEstcase 34 verify First and lastname on home page and myprofile is same ");
		Log.startTestCase("Test is started");
		homepage.homeTab();
		Log.info("HomeTab is clicked successfully");
		String name1=prop.getProperties("expectedTitleV1");
		String url=prop.getProperties("expectedUrlV2");
		homepage.validateFirstname(name1,url);
		Log.info("Firstname and Lastname is displayed");
		homepage.clickOnNameLink();
		Log.info("Click on Name link is successful");
		String name2=prop.getProperties("expectedTitleV1");
		usermenupage.validatingNameonProfilePage(name2);
		Log.info("Homapage is as same as My profile page");
		Log.endTestCase("Test is ended successfully");
	}
	
	@Test
	public void verifyFirstAndLastNameAtVAriousPages() throws IOException {
		Log.info("TEstcase 35 verify First and lastname at various places");
		Log.startTestCase("Test is started");
		homepage.homeTab();
		Log.info("HomeTab is clicked successfully");
		homepage.clickOnNameLink();
		Log.info("profile page is displayed");
		usermenupage.editBtn();
		Log.info("edit button is clicked successfully");
		usermenupage.abtFrame();
		Log.info("Switch to about frame successfully");
		usermenupage.aboutTab();
		Log.info("Clicked on about tab successfully");
		String lastname2 = prop.getProperties("Lastsname2");
		usermenupage.enterIntoLastname(lastname2);
		Log.info("LastName entered successfully");
		usermenupage.clickSaveall();
		Log.info("save all button is clicked");
		Log.info("Lastname is edited on every page.");
		Log.endTestCase("Testcase 35 is ended successfully");
	}
	
	
	@AfterMethod
	public void teardown() {
//		screenshot.takescreenshot(driver,testName); 
		quit();
	}
}
