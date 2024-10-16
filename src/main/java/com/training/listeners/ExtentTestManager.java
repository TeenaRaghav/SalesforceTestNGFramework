package com.training.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;




public class ExtentTestManager {
	static Map<Long, ExtentTest> extentTestMap = new ConcurrentHashMap<Long, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
//    public static ExtentTest test = null;
	
	
    
    public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((Thread.currentThread().getId()));
	}
	
	

//	public static synchronized void endTest() {
//		extent.flush();
//		
//		
//	}
	
	

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put(Thread.currentThread().getId(), test);
		return test;
	}
	
	
}
