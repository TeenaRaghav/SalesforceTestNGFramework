package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.training.utilities.DriverManager;


public class BaseTest {
	
	protected WebDriver driver;
	
	public void setup() {
		driver = DriverManager.getDriver();
	}
	
	
	public void teardown() {
		DriverManager.quit();
	}
}
