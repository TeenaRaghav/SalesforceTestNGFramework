package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
	WebDriver driver;
	
	public WebDriver getDriver() {
		if (driver == null) {
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

	public void close() {
		driver.close();
		driver = null;
	}
	
	public void quit() {
		driver.quit();
		driver = null;
	}

}
