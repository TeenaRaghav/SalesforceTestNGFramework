package com.training.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public void takescreenshot(WebDriver driver) {
//		takescreenshot object
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
//		store this object in a file
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date current = new Date();
		String timestamp= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
		
		String userdir = System.getProperty("user.dir");
		String fileseperator = System.getProperty("file.separator");
		String filepath = userdir+fileseperator+"screenshots"+fileseperator+"Salesforce"+timestamp+".jpeg";
		File destfile = new File(filepath);
		
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
