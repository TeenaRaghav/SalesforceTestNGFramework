package com.training.listeners;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
  //ExtentReports : populating some common info on the report.
  //ex: tester name, browser name, OS name, project name, module name, environment details.
    private static ExtentSparkReporter sparkReporter;
    //> ExtentSparkReporter : it is respoinsible for Ui of the report, how it looks like, look and feel?

 	static Date currentDate = new Date();
  	static String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
  	
    private static String reportFileName = "Salesforce_Automation_Report" + timestamp + ".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "Extent_Report";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
//    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/Tekarch" + timestamp + " .html" + "Extent_report");
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
       //there are multiple reporters ,to generate a report it has to use a reporter
         sparkReporter = new ExtentSparkReporter(fileName);
//        sparkReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//        sparkReporter.config().setChartVisibilityOnOpen(true);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle(reportFileName);//title of the report
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Functional Testing");//name of the report
        //htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);//by attachReporter method we are attaching extent report and ExtentSparkReport
        
        //Set environment details
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester_name", "Teena Raghav");
		extent.setSystemInfo("BrowserName", "Chrome");
 
        return extent;
    }
     
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
 
}
