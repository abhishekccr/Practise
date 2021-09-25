package com.qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.BaseClass;
import com.qa.Pages.LoginPage;
import com.qa.Utils.BrowserFactory;
import com.qa.Utils.ExcelDataProvider;
import com.qa.Utils.Helper;

public class LoginAppTest extends BaseClass {


	LoginPage loginpage;
	

	
	@Test
	public void loginApp()
	{
		
		
		logger = report.createTest("Login to FB");
		
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		loginpage.logInToFBApp(exceldata.getStringData("Login", 0, 0), exceldata.getStringData("Login", 0, 1));
		
		logger.pass("login Successfull");
	}
	
	
	
}
