package com.training.listeners;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.training.utilities.ScreenshotUtility;



public class TestListener extends ScreenshotUtility implements ITestListener {
	String testName;
	WebDriver driver;
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		testName = result.getName();
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	ExtentTestManager.getTest().log(Status.INFO,testName+"execution started ");
	}

	public void onTestSuccess(ITestResult result) {
		testName = result.getName();
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS,testName+ "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		testName = result.getName();
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		
		ExtentTestManager.getTest().log(Status.FAIL, testName+"Test Failed");
		driver = null;
		try {
			Field driverField = result.getTestClass().getRealClass().getDeclaredField("driver");
			driverField.setAccessible(true);
			driver = (WebDriver)driverField.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String screenshotPath = takescreenshot(driver,testName);
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExtentTestManager.getTest().log(Status.INFO,result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		testName = result.getName();
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP,testName+ "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
