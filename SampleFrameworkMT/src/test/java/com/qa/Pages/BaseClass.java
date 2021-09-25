package com.qa.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.qa.Utils.BrowserFactory;
import com.qa.Utils.ConfigReader;
import com.qa.Utils.ExcelDataProvider;
import com.qa.Utils.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider exceldata;
	public ConfigReader configreader;
	
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		
		 Reporter.log("*****************Setting up reports and test started********************", true);
		 exceldata = new ExcelDataProvider();
		 configreader = new ConfigReader();
		 
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/SampleFramwork.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		 Reporter.log("******************All configurations done********************", true);
	}
	
	
	@BeforeClass
	public void setup()
	{
		
		Reporter.log("******************Initialising Browser********************", true);
		driver= BrowserFactory.startBrowser(driver, configreader.getBrowser(), configreader.getURL());
		
		Reporter.log("******************Browser and application  Launched ********************", true);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		Reporter.log("******************Test about to End********************", true);
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			     Helper.captureScreenShot(driver);
		  }
		  
		  report.flush();
		  
		  Reporter.log("******************Test Completed >> Reports Generated********************", true);
	}
	
	
	@AfterClass()
	public void tearDown()
	{
		BrowserFactory.CloseBrowser(driver);
	}

	
}
