package com.mainProject.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mainProject.testCases.BaseClass;


public class Listeners extends BaseClass implements ITestListener {

	static ExtentReports extent;
	ExtentTest test;
	
	
	@Override
	public void onStart(ITestContext context) {
		// setup of extent reports in listeners
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shiva Ponnaganti");
	}
	
	
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		//System.out.println("listeners test started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		extentTest.set(test);
		
		String testMethodName=result.getName();
		
		  try { 
			  	//driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			 
				//add screenshot to extent reports
				test.addScreenCaptureFromPath(getScreenShotPath(testMethodName));
				
		  } 
		  catch (IllegalArgumentException |SecurityException | IOException e) {
		   
			  e.printStackTrace(); 
		  }
		  /*
		  BaseClass bClass=new BaseClass();
		  try { 
			  bClass.getScreenShotPath(testMethodName,driver); 
		  } catch (IOException e) {
		  e.printStackTrace(); 
		  }
		  */
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest.get().skip(result.getTestName());
		extentTest.set(test);
	}


	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
		
	}

}