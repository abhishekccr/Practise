package com.qa.Utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	// To handle screen shots, Frames , Snychroisation ,JSExecutor, Alerts
	
	public static void captureScreenShot(WebDriver driver)
	{  
		
		  File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   
		  try {
			FileHandler.copy(src, new File("./Screenshots/SampleFrameWork" +getCurrentDateTime() + ".png"));
		} catch (IOException e) {

            System.out.println("Unable to capture the screenshot"+ e.getMessage());
		}
		
	}
	
	
	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}

}
