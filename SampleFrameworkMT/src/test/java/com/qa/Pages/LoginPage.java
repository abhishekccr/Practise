package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		
		
	}
	
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	
	public void logInToFBApp(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		
	}

}
