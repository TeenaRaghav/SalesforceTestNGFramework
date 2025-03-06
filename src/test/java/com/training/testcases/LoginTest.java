package com.training.testcases;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.training.listeners.TestListener.class)
public class LoginTest extends BaseTest {
	WebDriver driver;
	LoginPage loginpage;
	PropertiesFile prop;
	ScreenshotUtility scrnshot = new ScreenshotUtility();
	HomePage homepage;
	UserMenuPage usermenupage;
	String testName;

	@BeforeMethod
//	@Parameters("browser")
	public void beforeMethod() throws IOException {
		setup();
//		if(browser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		}else if(browser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		}
		prop = new PropertiesFile();
		String url = prop.getProperties("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		usermenupage = new UserMenuPage(driver);
		DOMConfigurator.configure("log4j.xml");
	}

	@Test(priority = 1)
	public void invalidLogin() throws IOException {
		Log.info("TestCase 1 : Enter only username and click on login button");
		Log.startTestCase("Invalid Login Test started");
		String uname = prop.getProperties("username");
		loginpage.enterIntoUsername(uname);
		Log.info("Successfully entered the username:" + uname);
		loginpage.clickLogin();
		loginpage.getErrorMessage();
		Log.endTestCase(" :Invalid Login test ended");

	}

	@Test(priority = 2)
	public void validLogin() throws IOException {
		Log.info("TestCase 2 : Enter valid username and valid password");
		Log.startTestCase("valid credentials Test started");

		String uname = prop.getProperties("username");
		loginpage.enterIntoUsername(uname);
		Log.info("Successfully entered the username :" + uname);

		String psswrd = prop.getProperties("password");
		loginpage.enterIntoPassword(psswrd);
		Log.info("Successfully entered the password :" + psswrd);

		loginpage.clickLogin();
		Log.info("Login successful.");
	}

	@Test(priority = 3)
	public void checkRememberme() throws IOException {
		Log.info("TestCase 3 : Enter valid username and valid password and click on Remember Me checkbox");

		Log.startTestCase("TestCase started");

		String uname = prop.getProperties("username");
		loginpage.enterIntoUsername(uname);
		Log.info("Succesfully entered the username");

		String psswrd = prop.getProperties("password");
		loginpage.enterIntoPassword(psswrd);
		Log.info("Successfully password entered.");

		loginpage.checkRememberme();
		Log.info("Successfully checked remember me checkbox. .");

		loginpage.clickLogin();
		Log.info("Login successful.");
		usermenupage.usermenu();
		homepage.logout();
		Log.endTestCase(" :RememberMeClick test ended");
	}

	@Test(priority = 4)
	public void forgotPasswordTest() throws IOException {
		Log.info("TestCase 4 : Forgot Password link");
		Log.startTestCase("Forgot password Test is started.");
		String username = prop.getProperties("username");
		loginpage.clickOnForgotPasswordLink(username);
		Log.info("Password reset message is displayed");
		Log.endTestCase("An Email associated with the username is sent.");
	}

	@Test(priority = 5)
	public void WrongUsernameAndPassword() throws IOException {
		Log.info("TestCase 5 : Enter invalid username and invalid password");
		Log.startTestCase("WrongUsernameAndPasswordTest is started ");
		String uname = prop.getProperties("WrongUname");
		loginpage.enterIntoUsername(uname);
		Log.info("Successfully entered the username :" + uname);

		String psswrd = prop.getProperties("WrongPwd");
		loginpage.enterIntoPassword(psswrd);
		Log.info("Successfully entered the password :" + psswrd);

		loginpage.clickLogin();
		Log.info("Login button is clicked.");

		loginpage.errorMessageAfterWrongusernameAndPassword();
		Log.endTestCase(": invalid credentials test ended");

	}

	@AfterMethod
	public void teardown() {
//		scrnshot.takescreenshot(driver,testName);
		quit();

	}
}
