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
	
	public String takescreenshot(WebDriver driver,String TestName) {
//		takescreenshot object
		
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
//		store this object in a file
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);		
		Date current = new Date();
		String timestamp= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
		
		String userdir = System.getProperty("user.dir");
		String fileseperator = System.getProperty("file.separator");
		String filepath = userdir+fileseperator+"screenshots"+fileseperator+timestamp+ "_" + TestName +".jpeg";
		File destfile = new File(filepath);
		
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return destfile.getAbsolutePath();
	}
}
//package com.training.utilities;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class ScreenshotUtility {
//    
//    public String takescreenshot(WebDriver driver, String TestName) {
//        // Check if driver is null
//        if (driver == null) {
//            throw new IllegalArgumentException("WebDriver instance is null.");
//        }
//
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//
//        // Attempt to capture screenshot
//        File srcfile = null;
//        try {
//            srcfile = screenshot.getScreenshotAs(OutputType.FILE);
//        } catch (Exception e) {
//            System.out.println("Failed to capture screenshot: " + e.getMessage());
//            return null;
//        }
//
//        // Generate timestamp and file path
//        Date current = new Date();
//        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
//
//        String userdir = System.getProperty("user.dir");
//        String fileseperator = System.getProperty("file.separator");
//        String filepath = userdir + fileseperator + "screenshots" + fileseperator + "Salesforce" + fileseperator + timestamp + "_" + TestName + ".jpeg";
//
//        File destfile = new File(filepath);
//
//        // Attempt to save the file
//        try {
//            FileUtils.copyFile(srcfile, destfile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Screenshot saved at: " + filepath);  // Debugging
//        return destfile.getAbsolutePath();
//    }
//}
