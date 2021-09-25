package com.qa.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static WebDriver startBrowser(WebDriver driver, String browsername, String appURL)
	{
		
		if(browsername.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
			 driver = new ChromeDriver();
			 
		}
		
		else if(browsername.equals("firefox"))
		{
			
			
		}
		
		
		else
		{
			System.out.println("Browwser not supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	
	public static void CloseBrowser(WebDriver driver)
	{
		
		driver.quit();
		
		
	}

}
