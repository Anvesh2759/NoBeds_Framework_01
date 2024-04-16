package com.app.nobeds.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListeners extends ObjectManager implements ITestListener, PathConstants 
{
	ExtentReports report;
	ExtentTest test;
	String path;
	public void onStart(ITestContext context) 
	{
		//Create Report
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(reportpath+"ExecutionReport_"+getJavaUtility().generateDate()+".html");
		htmlreport.config().setDocumentTitle("TestReport");
		htmlreport.config().setReportName("NoBedsAPP");
		htmlreport.config().setTheme(Theme.STANDARD);
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Reporter", "Anvesh");
		//create New folder to save screenshots
		getJavaUtility().generateDate();
		path=getJavaUtility().createFolder();
		
		
		Reporter.log("Test Execution started",true);
		
	}
	public void onTestStart(ITestResult result) 
	{
		String testmethodname = result.getName();
		test= report.createTest(testmethodname);
		Reporter.log(testmethodname+" execution started",true);
		 
		 
	}
	public void onTestSuccess(ITestResult result) 
	{
		String testmethodname = result.getName();
		test.log(Status.PASS, testmethodname+" method pass");
		Reporter.log(testmethodname+" method execution pass", true);
		
	}
	public void onTestFailure(ITestResult result) 
	{
		String testmethodname = result.getName();
		test.log(Status.FAIL, testmethodname+" method fail");
		Reporter.log(testmethodname+" method execution fail", true);
		getSeleniumWebDriverActions(BaseClass.st_driver).getScreenShot(path, testmethodname);	
	}
	public void onTestSkipped(ITestResult result) 
	{
		String testmethodname = result.getName();
		test.log(Status.SKIP, testmethodname+" method skip");
		Reporter.log(testmethodname+" method execution skip", true);
		Reporter.log(testmethodname+" execution skipped",true);
	}
	public void onFinish(ITestContext context)
	{
		Reporter.log("test execution completed",true);
		report.flush();
	}
	
	
}
