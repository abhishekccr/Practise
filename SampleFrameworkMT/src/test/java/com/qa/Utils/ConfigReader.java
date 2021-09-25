package com.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties prop;
	public ConfigReader()
	{
		
		File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
  prop = new Properties();	
  prop.load(fis);
		} catch (Exception  e) {
			System.out.println("Unable to load config file "+ e.getMessage());
		}
		
		
	}
	
	
	public String getDataFromConfig(String keyToSearch)
	{
		return prop.getProperty(keyToSearch);
		
	}
	

	public String getBrowser()
	{
		return prop.getProperty("browser");
		
	}
	

	public String getURL()
	{
		return prop.getProperty("qaURL");
		
	}

}
